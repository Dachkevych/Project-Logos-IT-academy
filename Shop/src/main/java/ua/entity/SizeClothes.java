package ua.entity;

public enum SizeClothes {
	
	SIZE_0("0"),
	SIZE_S("S"),
	SIZE_M("M"),
	SIZE_L("L"),
	SIZE_XL("XL"),
	SIZE_XXL("XXl");
	
	private String value;

	private SizeClothes(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}