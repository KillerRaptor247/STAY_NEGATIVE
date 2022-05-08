package dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import classes.*;

public class PetDAO {
	// map pet id to a pet
	public Map<Integer, Pet> pets;
	
	public PetDAO(){
		pets = new HashMap<Integer,Pet>();
	}
	
	// return size of collection
	public int getSize() {
		return pets.size();
	}
	
	public void addPet(String name, String age, String breed, Species species, Sex sex) {
		// create new pet
		Pet newPet = new Pet(name, age, breed, species, sex);
		
		// insert put into DAO
		pets.put(newPet.getID(), newPet);
		
		
	}
	
	public void removePet(Integer id) {
		// if we can find a pet, remove it
		if(pets.get(id) != null) {
			pets.remove(id);
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
						+ pet.getSpecies().toString() + "," +  pet.getSex().toString() + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void importDAO() {
		// first clear the DAO
		pets.clear();
		// if the file doesn't already exist create it
		File dao = new File("petDAO.dat");
		try {
			if(!dao.createNewFile()) {
				BufferedReader br = new BufferedReader(new FileReader(dao));
				
				String line;
				while((line = br.readLine()) != null) {
					// tokenize line and create customers, put them in the map
					String [] words = line.split(",");
					Pet newPet = new Pet(words[1], words[2], words[3], Species.valueOf(words[4]), Sex.valueOf(words[5]));
					newPet.setID(Integer.parseInt(words[0]));
					pets.put(newPet.getID(), newPet);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
