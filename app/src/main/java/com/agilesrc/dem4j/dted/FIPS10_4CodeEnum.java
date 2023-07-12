/*
 *  Copyright 2001 AgileSrc LLC
 *
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 */
package com.agilesrc.dem4j.dted;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>Title:       FIPS10_4CodeEnum</p>
 * <p>Description: The FIPS10_4CodeEnum object is 
 * The two-letter country codes were used by the US government 
 * for geographical data processing</p>
 *
 * <p>Organization: AgileSrc LLC (www.agilesrc.com)</p>
 * @author  Mark Horn
 */
public enum FIPS10_4CodeEnum {
	AFGHANISTAN("AFGHANISTAN","AF","ISLAMIC STATE OF AFGHANISTAN"),
	ALBANIA("ALBANIA","AL","REPUBLIC OF ALBANIA"),
	ALGERIA("ALGERIA","AG","PEOPLE\'S DEMOCRATIC REPUBLIC OF ALGERIA"),
	ANDORRA("ANDORRA","AN","PRINCIPALITY OF ANDORRA"),
	ANGOLA("ANGOLA","AO","REPUBLIC OF ANGOLA"),
	ANTIGUA_AND_BARBUDA("ANTIGUA AND BARBUDA","AC","NONE"),
	ARGENTINA("ARGENTINA","AR","ARGENTINE REPUBLIC"),
	ARMENIA("ARMENIA","AM","REPUBLIC OF ARMENIA"),
	AUSTRALIA("AUSTRALIA","AS","COMMONWEALTH OF AUSTRALIA"),
	AUSTRIA("AUSTRIA","AU","REPUBLIC OF AUSTRIA"),
	AZERBAIJAN("AZERBAIJAN","AJ","REPUBLIC OF AZERBAIJAN"),
	THE_BAHAMAS("THE BAHAMAS","BF","COMMONWEALTH OF THE BAHAMAS"),
	BAHRAIN("BAHRAIN","BA","STATE OF BAHRAIN"),
	BANGLADESH("BANGLADESH","BG","PEOPLE\'S REPUBLIC OF BANGLADESH"),
	BARBADOS("BARBADOS","BB","NONE"),
	BELARUS("BELARUS","BO","REPUBLIC OF BELARUS"),
	BELGIUM("BELGIUM","BE","KINGDOM OF BELGIUM"),
	BELIZE("BELIZE","BH","NONE"),
	BENIN("BENIN","BN","REPUBLIC OF BENIN"),
	BHUTAN("BHUTAN","BT","KINGDOM OF BHUTAN"),
	BOLIVIA("BOLIVIA","BL","REPUBLIC OF BOLIVIA"),
	BOSNIA_AND_HERZEGOVINA("BOSNIA AND HERZEGOVINA","BK","NONE"),
	BOTSWANA("BOTSWANA","BC","REPUBLIC OF BOTSWANA"),
	BRAZIL("BRAZIL","BR","FEDERATIVE REPUBLIC OF BRAZIL"),
	BRUNEI("BRUNEI","BX","NEGARA BRUNEI DARUSSALAM"),
	BULGARIA("BULGARIA","BU","NONE"),
	BURKINA_FASO("BURKINA FASO","UV","NONE"),
	BURMA("BURMA","BM","UNION OF BURMA"),
	BURUNDI("BURUNDI","BY","REPUBLIC OF BURUNDI"),
	CAMBODIA("CAMBODIA","CB","KINGDOM OF CAMBODIA"),
	CAMEROON("CAMEROON","CM","REPUBLIC OF CAMEROON"),
	CANADA("CANADA","CA","NONE"),
	CAPE_VERDE("CAPE VERDE","CV","REPUBLIC OF CAPE VERDE"),
	CENTRAL_AFRICAN_REPUBLIC("CENTRAL AFRICAN REPUBLIC","CT","NONE"),
	CHAD("CHAD","CD","REPUBLIC OF CHAD"),
	CHILE("CHILE","CI","REPUBLIC OF CHILE"),
	CHINA("CHINA (see note 1)","CH","PEOPLE\'S REPUBLIC OF CHINA"),
	COLOMBIA("COLOMBIA","CO","REPUBLIC OF COLOMBIA"),
	COMOROS("COMOROS","CN","FEDERAL ISLAMIC REPUBLIC OF THE COMOROS"),
	CONGO_BRAZZAVILLE("CONGO (Brazzaville)","CF","REPUBLIC OF THE CONGO"),
	CONGO_KINSHASA("CONGO (Kinshasa)","CG","DEMOCRATIC REPUBLIC OF THE CONGO"),
	COSTA_RICA("COSTA RICA","CS","REPUBLIC OF COSTA RICA"),
	COTE_DIVOIRE("COTE D\'IVOIRE","IV","REPUBLIC OF COTE D\'IVOIRE"),
	CROATIA("CROATIA","HR","REPUBLIC OF CROATIA"),
	CUBA("CUBA","CU","REPUBLIC OF CUBA"),
	CYPRUS("CYPRUS","CY","REPUBLIC OF CYPRUS"),
	CZECH_REPUBLIC("CZECH REPUBLIC","EZ","NONE"),
	DENMARK("DENMARK","DA","KINGDOM OF DENMARK"),
	DJIBOUTI("DJIBOUTI","DJ","REPUBLIC OF DJIBOUTI"),
	DOMINICA("DOMINICA","DO","COMMONWEALTH OF DOMINICA"),
	DOMINICAN_REPUBLIC("DOMINICAN REPUBLIC","DR","NONE"),
	ECUADOR("ECUADOR","EC","REPUBLIC OF ECUADOR"),
	EGYPT("EGYPT","EG","ARAB REPUBLIC OF EGYPT"),
	EL_SALVADOR("EL SALVADOR","ES","REPUBLIC OF EL SALVADOR"),
	EQUATORIAL_GUINEA("EQUATORIAL GUINEA","EK","REPUBLIC OF EQUATORIAL GUINEA"),
	ERITREA("ERITREA","ER","STATE OF ERITREA"),
	ESTONIA("ESTONIA","EN","REPUBLIC OF ESTONIA"),
	ETHIOPIA("ETHIOPIA","ET","FEDERAL DEMOCRATIC REPUBLIC OF ETHIOPIA"),
	FIJI("FIJI","FJ","REPUBLIC OF THE FIJI ISLANDS"),
	FINLAND("FINLAND","FI","REPUBLIC OF FINLAND"),
	FRANCE("FRANCE","FR","FRENCH REPUBLIC"),
	GABON("GABON","GB","GABONESE REPUBLIC"),
	THE_GAMBIA("THE GAMBIA","GA","REPUBLIC OF THE GAMBIA"),
	GEORGIA("GEORGIA","GG","NONE"),
	GERMANY("GERMANY","GM","FEDERAL REPUBLIC OF GERMANY"),
	GHANA("GHANA","GH","REPUBLIC OF GHANA"),
	GREECE("GREECE","GR","HELLENIC REPUBLIC"),
	GRENADA("GRENADA","GJ","NONE"),
	GUATEMALA("GUATEMALA","GT","REPUBLIC OF GUATEMALA"),
	GUINEA("GUINEA","GV","REPUBLIC OF GUINEA"),
	GUINEA_BISSAU("GUINEA-BISSAU","PU","REPUBLIC OF GUINEA-BISSAU"),
	GUYANA("GUYANA","GY","CO-OPERATIVE REPUBLIC OF GUYANA"),
	HAITI("HAITI","HA","REPUBLIC OF HAITI"),
	HONDURAS("HONDURAS","HO","REPUBLIC OF HONDURAS"),
	HUNGARY("HUNGARY","HU","REPUBLIC OF HUNGARY"),
	ICELAND("ICELAND","IC","REPUBLIC OF ICELAND"),
	INDIA("INDIA","IN","REPUBLIC OF INDIA"),
	INDONESIA("INDONESIA","ID","REPUBLIC OF INDONESIA"),
	IRAN("IRAN","IR","ISLAMIC REPUBLIC OF IRAN"),
	IRAQ("IRAQ","IZ","REPUBLIC OF IRAQ"),
	IRELAND("IRELAND","EI","NONE"),
	ISRAEL("ISRAEL (see note 2)","IS","STATE OF ISRAEL"),
	ITALY("ITALY","IT","ITALIAN REPUBLIC"),
	JAMAICA("JAMAICA","JM","NONE"),
	JAPAN("JAPAN","JA","NONE"),
	JORDAN("JORDAN","JO","HASHEMITE KINGDOM OF JORDAN"),
	KAZAKHSTAN("KAZAKHSTAN","KZ","REPUBLIC OF KAZAKHSTAN"),
	KENYA("KENYA","KE","REPUBLIC OF KENYA"),
	KIRIBATI("KIRIBATI","KR","REPUBLIC OF KIRIBATI"),
	NORTH_KOREA("NORTH KOREA","KN","DEMOCRATIC PEOPLE\'S REPUBLIC OF KOREA"),
	SOUTH_KOREA("SOUTH KOREA","KS","REPUBLIC OF KOREA"),
	KUWAIT("KUWAIT","KU","STATE OF KUWAIT"),
	KYRGYZSTAN("KYRGYZSTAN","KG","KYRGYZ REPUBLIC"),
	LAOS("LAOS","LA","LAO PEOPLE\'S DEMOCRATIC REPUBLIC"),
	LATVIA("LATVIA","LG","REPUBLIC OF LATVIA"),
	LEBANON("LEBANON","LE","LEBANESE REPUBLIC"),
	LESOTHO("LESOTHO","LT","REPUBLIC OF LESOTHO"),
	LIBERIA("LIBERIA","LI","REPUBLIC OF LIBERIA"),
	LIBYA("LIBYA","LY","GREAT SOCIALIST PEOPLE\'S LIBYAN ARAB JAMAHIRIYA"),
	LIECHTENSTEIN("LIECHTENSTEIN","LS","PRINCIPALITY OF LIECHTENSTEIN"),
	LITHUANIA("LITHUANIA","LH","REPUBLIC OF LITHUANIA"),
	LUXEMBOURG("LUXEMBOURG","LU","GRAND DUCHY OF LUXEMBOURG"),
	THE_FORMER_YUGOSLAV_REPUBLIC_OF_MACEDONIA("THE FORMER YUGOSLAV REPUBLIC OF MACEDONIA","MK","NONE"),
	MADAGASCAR("MADAGASCAR","MA","REPUBLIC OF MADAGASCAR"),
	MALAWI("MALAWI","MI","REPUBLIC OF MALAWI"),
	MALAYSIA("MALAYSIA","MY","NONE"),
	MALDIVES("MALDIVES","MV","REPUBLIC OF MALDIVES"),
	MALI("MALI","ML","REPUBLIC OF MALI"),
	MALTA("MALTA","MT","REPUBLIC OF MALTA"),
	MARSHALL_ISLANDS("MARSHALL ISLANDS","RM","REPUBLIC OF THE MARSHALL ISLANDS"),
	MAURITANIA("MAURITANIA","MR","ISLAMIC REPUBLIC OF MAURITANIA"),
	MAURITIUS("MAURITIUS","MP","REPUBLIC OF MAURITIUS"),
	MEXICO("MEXICO","MX","UNITED MEXICAN STATES"),
	FEDERATED_STATES_OF_MICRONESIA("FEDERATED STATES OF MICRONESIA","FM","NONE"),
	MOLDOVA("MOLDOVA","MD","REPUBLIC OF MOLDOVA"),
	MONACO("MONACO","MN","PRINCIPALITY OF MONACO"),
	MONGOLIA("MONGOLIA","MG","NONE"),
	MOROCCO("MOROCCO","MO","KINGDOM OF MOROCCO"),
	MOZAMBIQUE("MOZAMBIQUE","MZ","REPUBLIC OF MOZAMBIQUE"),
	NAMIBIA("NAMIBIA","WA","REPUBLIC OF NAMIBIA"),
	NAURU("NAURU","NR","REPUBLIC OF NAURU"),
	NEPAL("NEPAL","NP","KINGDOM OF NEPAL"),
	NETHERLANDS("NETHERLANDS","NL","KINGDOM OF THE NETHERLANDS"),
	NEW_ZEALAND("NEW ZEALAND","NZ","NONE"),
	NICARAGUA("NICARAGUA","NU","REPUBLIC OF NICARAGUA"),
	NIGER("NIGER","NG","REPUBLIC OF NIGER"),
	NIGERIA("NIGERIA","NI","FEDERAL REPUBLIC OF NIGERIA"),
	NORWAY("NORWAY","NO","KINGDOM OF NORWAY"),
	OMAN("OMAN","MU","SULTANATE OF OMAN"),
	PAKISTAN("PAKISTAN","PK","ISLAMIC REPUBLIC OF PAKISTAN"),
	PALAU("PALAU","PS","REPUBLIC OF PALAU"),
	PANAMA("PANAMA","PM","REPUBLIC OF PANAMA"),
	PAPUA_NEW_GUINEA("PAPUA NEW GUINEA","PP","INDEPENDENT STATE OF PAPUA NEW GUINEA"),
	PARAGUAY("PARAGUAY","PA","REPUBLIC OF PARAGUAY"),
	PERU("PERU","PE","REPUBLIC OF PERU"),
	PHILIPPINES("PHILIPPINES","RP","REPUBLIC OF THE PHILIPPINES"),
	POLAND("POLAND","PL","REPUBLIC OF POLAND"),
	PORTUGAL("PORTUGAL","PO","PORTUGUESE REPUBLIC"),
	QATAR("QATAR","QA","STATE OF QATAR"),
	ROMANIA("ROMANIA","RO","NONE"),
	RUSSIA("RUSSIA","RS","RUSSIAN FEDERATION"),
	RWANDA("RWANDA","RW","RWANDESE REPUBLIC"),
	SAINT_KITTS_AND_NEVIS("SAINT KITTS AND NEVIS","SC","FEDERATION OF SAINT KITTS AND NEVIS"),
	SAINT_LUCIA("SAINT LUCIA","ST","NONE"),
	SAINT_VINCENT_AND_THE_GRENADINES("SAINT VINCENT AND THE GRENADINES","VC","NONE"),
	SAMOA("SAMOA","WS","INDEPENDENT STATE OF SAMOA"),
	SAN_MARINO("SAN MARINO","SM","REPUBLIC OF SAN MARINO"),
	SAO_TOME_AND_PRINCIPE("SAO TOME AND PRINCIPE","TP","DEMOCRATIC REPUBLIC OF SAO TOME AND PRINCIPE"),
	SAUDI_ARABIA("SAUDI ARABIA","SA","KINGDOM OF SAUDI ARABIA"),
	SENEGAL("SENEGAL","SG","REPUBLIC OF SENEGAL"),
	SEYCHELLES("SEYCHELLES","SE","REPUBLIC OF SEYCHELLES"),
	SIERRA_LEONE("SIERRA LEONE","SL","REPUBLIC OF SIERRA LEONE"),
	SINGAPORE("SINGAPORE","SN","REPUBLIC OF SINGAPORE"),
	SLOVAKIA("SLOVAKIA","LO","SLOVAK REPUBLIC"),
	SLOVENIA("SLOVENIA","SI","REPUBLIC OF SLOVENIA"),
	SOLOMON_ISLANDS("SOLOMON ISLANDS","BP","NONE"),
	SOMALIA("SOMALIA","SO","NONE"),
	SOUTH_AFRICA("SOUTH AFRICA","SF","REPUBLIC OF SOUTH AFRICA"),
	SPAIN("SPAIN","SP","KINGDOM OF SPAIN"),
	SRI_LANKA("SRI LANKA","CE","DEMOCRATIC SOCIALIST REPUBLIC OF SRI LANKA"),
	SUDAN("SUDAN","SU","REPUBLIC OF THE SUDAN"),
	SURINAME("SURINAME","NS","REPUBLIC OF SURINAME"),
	SWAZILAND("SWAZILAND","WZ","KINGDOM OF SWAZILAND"),
	SWEDEN("SWEDEN","SW","KINGDOM OF SWEDEN"),
	SWITZERLAND("SWITZERLAND","SZ","SWISS CONFEDERATION"),
	SYRIA("SYRIA","SY","SYRIAN ARAB REPUBLIC"),
	TAJIKISTAN("TAJIKISTAN","TI","REPUBLIC OF TAJIKISTAN"),
	TANZANIA("TANZANIA","TZ","UNITED REPUBLIC OF TANZANIA"),
	THAILAND("THAILAND","TH","KINGDOM OF THAILAND"),
	TOGO("TOGO","TO","TOGOLESE REPUBLIC"),
	TONGA("TONGA","TN","KINGDOM OF TONGA"),
	TRINIDAD_AND_TOBAGO("TRINIDAD AND TOBAGO","TD","REPUBLIC OF TRINIDAD AND TOBAGO"),
	TUNISIA("TUNISIA","TS","REPUBLIC OF TUNISIA"),
	TURKEY("TURKEY","TU","REPUBLIC OF TURKEY"),
	TURKMENISTAN("TURKMENISTAN","TX","NONE"),
	TUVALU("TUVALU","TV","NONE"),
	UGANDA("UGANDA","UG","NONE"),
	UKRAINE("UKRAINE","UP","NONE"),
	UNITED_ARAB_EMIRATES("UNITED ARAB EMIRATES","AE","NONE"),
	UNITED_KINGDOM("UNITED KINGDOM","UK","UNITED KINGDOM OF GREAT BRITAIN AND NORTHERN IRELAND"),
	UNITED_STATES("UNITED STATES","US","UNITED STATES OF AMERICA"),
	URUGUAY("URUGUAY","UY","ORIENTAL REPUBLIC OF URUGUAY"),
	UZBEKISTAN("UZBEKISTAN","UZ","REPUBLIC OF UZBEKISTAN"),
	VANUATU("VANUATU","NH","REPUBLIC OF VANUATU"),
	VATICAN_CITY("VATICAN CITY","VT","STATE OF THE VATICAN CITY"),
	VENEZUELA("VENEZUELA","VE","BOLIVARIAN REPUBLIC OF VENEZUELA"),
	VIETNAM("VIETNAM","VM","SOCIALIST REPUBLIC OF VIETNAM"),
	YEMEN("YEMEN","YM","REPUBLIC OF YEMEN"),
	YUGOSLAVIA("YUGOSLAVIA","YI","FEDERAL REPUBLIC OF YUGOSLAVIA"),
	ZAMBIA("ZAMBIA","ZA","REPUBLIC OF ZAMBIA"),
	ZIMBABWE("ZIMBABWE","ZI","REPUBLIC OF ZIMBABWE"),
	TAIWAN("OTHER: TAIWAN","TW","NONE (Part Of China)");

	//=========================================================================
	// CONSTANTS
	//=========================================================================
	private static final Map<String,FIPS10_4CodeEnum> _LOOKUP 
		= new HashMap<String,FIPS10_4CodeEnum>();
	
	static {
	    for(FIPS10_4CodeEnum s : EnumSet.allOf(FIPS10_4CodeEnum.class)) {
	         _LOOKUP.put(s.getCode(), s);
	    }
	}

	//=========================================================================
	// VARIABLES
	//=========================================================================
	private String _name;
	private String _code;
	private String _description;
		
	//=========================================================================
	// CONSTRUCTORS
	//=========================================================================
	/**
	 * constructor
	 */
	FIPS10_4CodeEnum(final String name, final String code, 
			final String description) {
		_name = name;
		_code = code;
		_description = description;
	}
	
	//=========================================================================
	// PUBLIC METHODS
	//=========================================================================
	/**
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return _code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return _description;
	}
	
	/**
	 * @param code
	 * @return
	 */
	public static FIPS10_4CodeEnum fromCodeString(final String code) {
		FIPS10_4CodeEnum result = null;
		
		if (StringUtils.isNotEmpty(code)) {
			String lookup = code;
			if (code.length() > 2) {
				lookup = StringUtils.substring(code,0,2);
			}
			
			result = _LOOKUP.get(lookup);
		}
		
		return result;
	}
	
	//=========================================================================
	// DEFAULT METHODS
	//=========================================================================

	//=========================================================================
	// PROTECTED METHODS
	//=========================================================================

	//=========================================================================
	// PRIVATE METHODS
	//=========================================================================

	//=========================================================================
	// INNER CLASSES
	//=========================================================================

}

