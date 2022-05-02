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

	public Pet(String name, String breed,String age, Species species, Sex sex){
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.species = species;
		this.sex = sex;
		ID = number.incrementAndGet();
		
	}
	
	public Pet(){
		
	}
	public Integer getID() {
		return ID;
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
	public Sex getSex() {
		return this.sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
}
