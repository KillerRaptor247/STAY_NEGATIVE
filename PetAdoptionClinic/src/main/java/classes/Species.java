package classes;

public enum Species {
	CAT("Cat"),
	DOG("Dog");
	
	private String species;
	
	private Species(String spc) {
		species = spc;
	}
	
	@Override
	public String toString() {
		return this.species;
	}
}
