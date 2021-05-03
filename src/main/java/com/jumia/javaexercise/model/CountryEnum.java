package com.jumia.javaexercise.model;

public enum CountryEnum {
	CR("Cameroon", "CR", "(237)","\\(237\\)\\ ?[2368]\\d{7,8}$"),
	ET("Ethiopia", "ET", "(251)","\\(251\\)\\ ?[1-59]\\d{8}$"),
	MR("Morocco", "MR", "(212)","\\(212\\)\\ ?[5-9]\\d{8}$"),
	MZ("Mozambique", "MZ", "(258)","\\(258\\)\\ ?[28]\\d{7,8}$"),
	UG("Uganda", "UG", "(256)", "\\(256\\)\\ ?\\d{9}$"),;

	private final String name;
	private final String label;
	private final String code;
    private final String regex;
    
	
	CountryEnum(String name, String label, String code, String regex) {
		this.name = name;
		this.label = label;
		this.code = code;
		this.regex = regex;
	}

	public String getName() {
		return name;
	}
	
	public String getLabel() {
		return label;
	}

	public String getCode() {
		return code;
	}

	public String getRegex() {
		return regex;
	}


}
