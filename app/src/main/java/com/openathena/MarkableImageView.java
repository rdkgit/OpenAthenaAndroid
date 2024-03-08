package com.openathena;

import static com.openathena.AthenaActivity.TAG;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import java.io.FileNotFoundException;

public class MarkableImageView extends androidx.appcompat.widget.AppCompatImageView {
    Marker theMarker = null;
    private Paint paint;
    AthenaActivity parent;
    private Matrix matrix = new Matrix();

    private ScaleGestureDetector scaleGestureDetector;
    private GestureDetector gestureDetector;
    // Time when last intent was fired
    private long lastIntentTime = 0;
    // Cooldown period of 1 second
    private static final long INTENT_COOLDOWN_MS = 1000;

    private float scaleFactor = 1.f;
    private float lastTouchX = 0;
    private float lastTouchY = 0;
    private int activePointerId = -1;
    private float posX = 0f;
    private float posY = 0f;

    public MarkableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!(context instanceof AthenaActivity)) {
            throw new RuntimeException("ERROR: tried to initiate MarkableImageView from a non-AthenaActivity!");
        }
        parent = (AthenaActivity) context;
        scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (!scaleGestureDetector.isInProgress()) {
                    setMarkerPosition(e.getX(), e.getY());
                    return true;
                }
                return false;
            }
            // Implement other gesture detections if necessary
        });
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#FE00DD")); // Set the marker color
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f); // Set the stroke width
        setScaleType(ScaleType.MATRIX);


        MarkableImageView yahweh = this; // reference to this MarkableImageView, for use in listener

        this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (theMarker != null) {
                    // Invalidate the view to redraw the marker at the correct position
                    yahweh.invalidate();
                }
                // Remove the listener to avoid multiple calls
                yahweh.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        float lastFocalX;
        float lastFocalY;

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            lastFocalX = detector.getFocusX();
            lastFocalY = detector.getFocusY();
            return true;
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactorFactor = detector.getScaleFactor();
            float newScaleFactor = scaleFactor * scaleFactorFactor;

            // Limit the scale factor to prevent the image from becoming too small or too large.
            newScaleFactor = Math.max(0.1f, Math.min(newScaleFactor, 5.0f));
            // Bound scaleFactorFactor based on result of the previous
            scaleFactorFactor = newScaleFactor / scaleFactor;

            // Calculate the translation needed to keep the focal point stationary
            float focalX = detector.getFocusX();
            float focalY = detector.getFocusY();

            // Calculate the focal point shift from the start of the gesture
            float focalShiftX = focalX - lastFocalX;
            float focalShiftY = focalY - lastFocalY;

            scaleFactor = newScaleFactor;

            // Adjust posX and posY to account for the focal point movement
            // This keeps the focal point under the user's fingers stationary
            posX += focalShiftX * (1 - scaleFactorFactor);
            posY += focalShiftY * (1 - scaleFactorFactor);

            // Update the last focal point
            lastFocalX = focalX;
            lastFocalY = focalY;

            invalidate();
            return true;
        }
    }

    private class MyScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            long currentTime = System.currentTimeMillis();


            // This condition ensures that zoom functionality is only available in SelectionActivity
            if (parent instanceof SelectionActivity) {
                float currentScaleFactor = detector.getScaleFactor();
                // Adjust scale factor within bounds
                float newScaleFactor = scaleFactor * currentScaleFactor;
                boolean doReturnToMainActivity = (newScaleFactor < 0.80f && currentTime - lastIntentTime > INTENT_COOLDOWN_MS);
                newScaleFactor = Math.max(1f, Math.min(newScaleFactor, 5.0f));

                // If user tries to zoom out beyond a certain threshold, return to MainActivity
                if (doReturnToMainActivity) {
                    // Reset scale factor to default to prepare for next use
                    scaleFactor = 1f;
                    Intent intent = new Intent(parent, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    parent.startActivity(intent);
                    lastIntentTime = currentTime;
                } else {
                    // Apply zooming within SelectionActivity
                    float focusX = detector.getFocusX();
                    float focusY = detector.getFocusY();

                    // Calculate the difference caused by scaling to adjust posX and posY accordingly
                    float scaleChange = newScaleFactor / scaleFactor;
                    posX = (posX - focusX) * scaleChange + focusX;
                    posY = (posY - focusY) * scaleChange + focusY;

                    // This is where the view is updated reflect the new scale factor
                    scaleFactor = newScaleFactor;
                    invalidate();
                }
            } else if (parent instanceof MainActivity && currentTime - lastIntentTime > INTENT_COOLDOWN_MS) {
                // Condition for transitioning from MainActivity to SelectionActivity
                // based on some criteria, e.g., a significant pinch gesture detected
                if (detector.getCurrentSpan() > 125 && detector.getTimeDelta() > 75) {
                    Intent intent = new Intent(parent, SelectionActivity.class);
                    parent.startActivity(intent);
                    lastIntentTime = currentTime;
                }
            }
            return super.onScale(detector);
        }
    }

    private void setMarkerPosition(float x, float y) {
        float x_prop; float y_prop;
        if (getWidth() > 0 && getHeight() > 0) {
            // Adjust the marker position to account for the current zoom and pan
            x_prop = (x - posX) / (getWidth() * scaleFactor);
            y_prop = (y - posY) /  (getHeight() * scaleFactor);
        } else {
            Log.e(TAG, "Error: width or height was zero at time of marking");
            return;
        }
        theMarker = new Marker(x_prop, y_prop);
    }

    /**
     * Given an x and y of a pixel in full-sized image, draw a mark on that same point on this imageView
     * @param selection_x The x coordinate of a pixel in full-sized image. 0 is left side and increases rightward
     * @param selection_y The y coordinate of a pixel in full-sized image. 0 is top side and increases downward
     */
    public void restoreMarker(int selection_x, int selection_y) {
        int[] original_dimensions = parent.getImageDimensionsFromUri(parent.imageUri);
        int original_x = original_dimensions[0];
        int original_y = original_dimensions[1];

        int render_width = getMeasuredWidth();
        int render_height = getMeasuredHeight();

        double x = (1.0d * selection_x) / original_x;
        double y = (1.0d * selection_y) / original_y;

        parent.calculateImage(this, false); // this may cause the view to re-size due to constraint layout
        mark(x,y);
    }

    /**
     * Given an x and y proportion (range [0, 1]) draw a mark that point
     * @param x The x proportion of a point on this imageView to draw a mark on. 0.0d is left, 0.5d is mid, 1.0d is right
     * @param y The y proportion of a point on this imageView to draw a mark on. 0.0d is top, 0.5d is mid, 1.0d is bottom
     */
    public void mark(double x, double y) {
        theMarker = new Marker(x, y);
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.scale(scaleFactor, scaleFactor);
        canvas.translate(posX, posY);
        super.onDraw(canvas); // Draw the image

        // Draw the marker
        if (theMarker != null) {
//            float actualX = (float) (theMarker.x_prop * getWidth() * scaleFactor) + posX;
//            float actualY = (float) (theMarker.y_prop * getHeight() * scaleFactor) + posY;
            float actualX = (float) theMarker.x_prop * getWidth();
            float actualY = (float) theMarker.y_prop * getHeight();
            // Adjust marker drawing size based on scale
            float markerSize = 20 * scaleFactor;
            canvas.drawCircle(actualX, actualY, markerSize, paint);
        }
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event); // Make sure this is called
        final int action = event.getAction();

         if (parent == null || !parent.isImageLoaded || parent.imageUri == null || parent.iView == null) {
             return true;
         }
        int original_width;
        int original_height;
        int[] original_dimensions = parent.getImageDimensionsFromUri(parent.imageUri);
        if (original_dimensions == null) {
            return true;
        } else {
            original_width = original_dimensions[0];
            original_height = original_dimensions[1];
        }

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                final float x = event.getX();
                final float y = event.getY();
                lastTouchX = x;
                lastTouchY = y;
                activePointerId = event.getPointerId(0);
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final int pointerIndex = event.findPointerIndex(activePointerId);
                final float x = event.getX(pointerIndex);
                final float y = event.getY(pointerIndex);

                // Only move if the ScaleGestureDetector isn't processing a gesture.
                if (!scaleGestureDetector.isInProgress()) {
                    final float dx = x - lastTouchX;
                    final float dy = y - lastTouchY;
                    posX += dx;
                    posY += dy;
                    invalidate();
                }

                lastTouchX = x;
                lastTouchY = y;
                break;
            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                activePointerId = -1;
                setMarkerPosition(event.getX(), event.getY());
                // pixel coordinate in (u, v) of original image size
                parent.set_selection_x((int) Math.round(theMarker.x_prop * original_width));
                parent.set_selection_y((int) Math.round(theMarker.y_prop * original_height));
                if (parent.isImageLoaded && parent.isDEMLoaded) {
                    parent.calculateImage(this, false); // this may cause the view to re-size due to constraint layout
                }
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {
                final int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK)
                        >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = event.getPointerId(pointerIndex);

                if (pointerId == activePointerId) {
                    // This was our active pointer going up. Choose a new active pointer and adjust accordingly.
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    lastTouchX = event.getX(newPointerIndex);
                    lastTouchY = event.getY(newPointerIndex);
                    activePointerId = event.getPointerId(newPointerIndex);
                }
                break;
            }
        }

        return true;
    }

    protected void drawMarker(Canvas canvas) {

        // After scaling and translating, draw your marker
        // The drawing operations here are affected by the transformations applied above
        if (theMarker != null) {
            float length = Math.max(getWidth() / 48, getHeight() / 48) * scaleFactor;
            float gap = (length / 1.5f) * scaleFactor;
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#FE00DD")); // HI-VIS PINK
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(gap);

            // Adjust marker's position based on current scale and translation
            float actualX = (float) theMarker.x_prop * getWidth();
            float actualY = (float) theMarker.y_prop * getHeight();

            // Adjust for translation
            actualX += posX;
            actualY += posY;

            // Adjust for scale
            actualX *= scaleFactor;
            actualY *= scaleFactor;

            // Draw the marker
            canvas.drawLine(actualX - length - gap, actualY, actualX - gap, actualY, paint);
            canvas.drawLine(actualX + gap, actualY, actualX + length + gap, actualY, paint);
            canvas.drawLine(actualX, actualY - length - gap, actualX, actualY - gap, paint);
            canvas.drawLine(actualX, actualY + gap, actualX, actualY + length + gap, paint);
        }

    }

    protected class Marker {
        public double x_prop;
        public double y_prop;

        public Marker(double x_prop, double y_prop) {
            this.x_prop = x_prop;
            this.y_prop = y_prop;
        }
    }

    @Override
    /**
     * Override ImageView's setImageURI to make sure we scale down huge images instead of crashing
     */
    public void setImageURI(final Uri uri) {
        if(getWidth() == 0 && getHeight() == 0) {
            ViewTreeObserver vto = getViewTreeObserver();
            vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    getViewTreeObserver().removeOnPreDrawListener(this);
                    int render_width = getMeasuredWidth();
                    int render_height = getMeasuredHeight();
                    Bitmap bitmap = decodeSampledBitmapFromUri(uri, render_width, render_height);
                    setImageBitmap(bitmap);
                    return true;
                }
            });
        } else {
            int render_width = getMeasuredWidth();
            int render_height = getMeasuredHeight();
            Bitmap bitmap = decodeSampledBitmapFromUri(uri, render_width, render_height);
            setImageBitmap(bitmap);
        }
    }

    public Bitmap decodeSampledBitmapFromUri(Uri uri, int reqWidth, int reqHeight) {
        if (uri == null) {
            return null;
        }

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(parent.getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException fnfe) {
            Log.e(TAG, "Could not find file: " + uri.toString());
            fnfe.printStackTrace();
            return null;
        }

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeStream(parent.getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException fnfe) {
            Log.e(TAG, "Could not find file: " + uri.toString());
            fnfe.printStackTrace();
            return null;
        }
    }

    public int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
