package lastminute;

public enum Type {

	BOOK("Book"), MEDICAL("Medical"), FOOD("Food"), OTHER("Other");


	private String string;

	Type(String name) {
		string = name;
	}

	@Override
	public String toString() {
		return string;
	}

}
