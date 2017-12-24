package ua.entity;

public enum SizeShoes {
	
	SIZE_0("0"),
	SIZE_36("36"),
	SIZE_37("37"),
	SIZE_38("38"),
	SIZE_39("39"),
	SIZE_40("40"),
	SIZE_41("41"),
	SIZE_42("42"),
	SIZE_43("43"),
	SIZE_44("44"),
	SIZE_45("45");
	
	private String value;

	private SizeShoes(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
