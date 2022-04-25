package classes;

public enum Sex {
	MALE("Male"),
	FEMALE("Female");
	
	private String sex;
	
	private Sex(String sx) {
		sex = sx;
	}
	
	@Override
	public String toString() {
		return this.sex;
	}
	
}
