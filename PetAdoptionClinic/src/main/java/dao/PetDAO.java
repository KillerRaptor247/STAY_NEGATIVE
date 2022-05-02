package dao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import classes.*;

public class PetDAO {
	protected Map<Integer, Pet> pets;
	
	PetDAO(){
		pets = new HashMap<Integer,Pet>();
	}
	
	public int getSize() {
		return pets.size();
	}
	
	public void addPet(String name, String age, String breed, Species species, Sex sex) {
		// create new pet
		Pet newPet = new Pet(name, age, breed, species, sex);
		
		// insert put into DAO
		pets.put(newPet.getID(), newPet);
		
		
	}
	
	public void removePet(Pet pet) {
		// if we can find a pet, remove it
		if(pets.get(pet.getID()) != null) {
			pets.remove(pet.getID());
		}
		
	}
	
	public void editPet(Integer ID, String name, String age, String breed, Species species, Sex sex) {
		// first grab Pet from DAO with Pet Id
		Pet updatedPet = pets.get(ID);
		// Then update customer member variables
		updatedPet.setName(name);
		updatedPet.setAge(age);
		updatedPet.setBreed(breed);
		updatedPet.setSpecies(species);
		updatedPet.setSex(sex);
		
		// finally update the DAO with the updated pet
		pets.put(ID, updatedPet);
		
	}
	
	public void export() {
		// create file to append
		try {
			FileWriter writer = new FileWriter("PetDAO.dat", Boolean.TRUE);
			for(Pet pet : pets.values()) {
				writer.write(pet.getID() + "," + pet.getName() + "," + pet.getBreed() + "," + pet.getAge() + ","
						+ pet.getSpecies() + pet.getSex() + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
