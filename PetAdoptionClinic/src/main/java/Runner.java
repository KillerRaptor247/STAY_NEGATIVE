import dao.PetClinic;
import forms.*;

/**
 * This file is just for testing, to make it more obv
 */
public class Runner {
    public static void main(String[] args) {
    	// create the store
    	PetClinic mainStore = new PetClinic();
    	// load in mainStores
    	mainStore.importData();
        LoginFormEmployee login = new LoginFormEmployee(mainStore);
        login.createAndShowGUI();

    }
}
