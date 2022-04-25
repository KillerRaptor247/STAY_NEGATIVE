package dao;
import java.util.HashSet;
import java.util.Set;

import classes.Pet;

public class PetDAO {
	private Set<Pet> pets;
	
	PetDAO(){
		pets = new HashSet<Pet>();
	}
	
	public int getSize() {
		return pets.size();
	}
	
	public void createPet() {
		
	}
	
	public void deletePet() {
		
	}
	
	public void editPet() {
		
	}
}
