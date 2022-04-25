package classes;
import java.util.concurrent.atomic.AtomicInteger;

public class Pet {
	private static final AtomicInteger number = new AtomicInteger(0);
	Integer ID;
	String age;
	String breed;
	String name;
	Species species;
	Sex sex;
	
	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	Pet(String nm, String brd,String ag){
		name = nm;
		age = ag;
		breed = brd;
		ID = number.incrementAndGet();
	}
	
	public Pet(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
}
