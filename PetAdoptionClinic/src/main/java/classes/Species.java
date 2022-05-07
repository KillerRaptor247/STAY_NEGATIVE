package classes;

// enum for Species member variable for Pet
public enum Species {
	CAT("Cat"),
	DOG("Dog");
	
	protected String species;
	
	private Species(String spc) {
		species = spc;
	}
	
	@Override
	public String toString() {
		return this.species;
	}
}
