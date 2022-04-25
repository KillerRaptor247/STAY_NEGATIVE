import dao.PetClinic;
import forms.*;

/**
 * This file is just for testing, to make it more obv
 */
public class test {
    public static void main(String[] args) {
    	PetClinic mainStore = new PetClinic();
    	// load in mainStores
        LoginChoose loginChoose = new LoginChoose(mainStore);
        loginChoose.createAndShowGUI();
        //EditForm editForm = new EditForm();
        //editForm.createAndShowGui();
    	
    	//HomePage form = new HomePage();
    	//form.createAndShowGUI();
    	
    	//LoginFormEmployee form = new LoginFormEmployee();
    	//form.createAndShowGUI();
    }
}
