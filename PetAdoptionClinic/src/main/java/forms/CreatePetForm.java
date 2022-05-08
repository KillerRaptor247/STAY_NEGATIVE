package forms;
import javax.swing.*;

import classes.Pet;
import classes.Sex;
import classes.Species;
import dao.PetClinic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class CreatePetForm extends Form implements ActionListener{
     
	JButton save;
	JButton cancel;

	JTextField idTF;
	JTextField nameTF;
	JTextField ageTF;
	JTextField breedTF;
	
	JRadioButton male, female, dog, cat;

    CreatePetForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	public void createAndShowGUI() {
    	
		this.setTitle("Create Pet Form");
    	ImageIcon img = new ImageIcon("dog-32-32.png");
		
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        JPanel panelForAll = new JPanel(new BorderLayout());
        JPanel panelForForm = new JPanel(new SpringLayout());

        
        idTF = new JTextField(Pet.number.toString(), 15);
        idTF.setEditable(false);
        nameTF = new JTextField(15);
        nameTF.setEditable(true);
        ageTF = new JTextField(15);
        ageTF.setEditable(true);
        breedTF = new JTextField(15);
        breedTF.setEditable(true);
        
        JLabel idLbl = new JLabel("ID:", JLabel.TRAILING);
        JLabel nameLbl = new JLabel("Name:", JLabel.TRAILING);
        JLabel ageLbl = new JLabel("Age:", JLabel.TRAILING);
        JLabel breedLbl = new JLabel("Breed:", JLabel.TRAILING);

        idLbl.setLabelFor(idTF);
        nameLbl.setLabelFor(nameTF);
        ageLbl.setLabelFor(ageTF);
        breedLbl.setLabelFor(breedTF);

        
        panelForForm.add(idLbl);
        panelForForm.add(idTF);
        panelForForm.add(nameLbl);
        panelForForm.add(nameTF);
        panelForForm.add(ageLbl);
        panelForForm.add(ageTF);
        panelForForm.add(breedLbl);
        panelForForm.add(breedTF);

        SpringUtilities.makeCompactGrid(panelForForm, 4, 2, 10, 10, 10, 10);

        JPanel panelForCheckbox = new JPanel(new SpringLayout());
        JLabel genderLbl = new JLabel("Gender:", JLabel.TRAILING);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        JLabel speciesLbl = new JLabel("Species:", JLabel.TRAILING);
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderLbl.setLabelFor(male);
        genderLbl.setLabelFor(female);

        panelForCheckbox.add(genderLbl);
        panelForCheckbox.add(male);
        panelForCheckbox.add(female);

        ButtonGroup speciesGroup = new ButtonGroup();
        speciesLbl.setLabelFor(cat);
        speciesLbl.setLabelFor(dog);
        speciesGroup.add(cat);
        speciesGroup.add(dog);
        panelForCheckbox.add(speciesLbl);
        panelForCheckbox.add(cat);
        panelForCheckbox.add(dog);
        SpringUtilities.makeCompactGrid(panelForCheckbox, 2, 3, 13, 0, 10, 10);
        
        male.setSelected(true);
        cat.setSelected(true);

        JPanel panelForButton = new JPanel();
        save = new JButton("Save");
        cancel = new JButton("Cancel");
        save.addActionListener(this);
        cancel.addActionListener(this);

        panelForButton.add(cancel);
        panelForButton.add(save);

       panelForForm.setOpaque(true);
       panelForButton.setOpaque(true);
        panelForForm.setOpaque(true);
        panelForAll.add(panelForForm, BorderLayout.NORTH);
        panelForAll.add(panelForCheckbox, BorderLayout.CENTER);
        panelForAll.add(panelForButton, BorderLayout.SOUTH);

        panelForAll.setOpaque(true);
        this.add(panelForAll);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    
}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(nameTF.getText().isEmpty() || ageTF.getText().isEmpty() || breedTF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please leave no fields empty!", "Empty Fields Detected", JOptionPane.WARNING_MESSAGE);
			}else {
				Sex sex;
				Species sp;
				
				if(male.isSelected()) {
					sex = Sex.MALE;
				}else {
					sex = Sex.FEMALE;
				}
				if(dog.isSelected()) {
					sp = Species.DOG;
				}else {
					sp = Species.CAT;
				}
				
				store.petDAO.addPet(nameTF.getText(), ageTF.getText(), breedTF.getText(), sp, sex);
				
				HomePage form = new HomePage(this.store);
				form.createAndShowGUI();
				this.dispose();
			}
		}
		if(e.getSource().equals(cancel)) {
			HomePage form = new HomePage(this.store);
			form.createAndShowGUI();
			this.dispose();
		}
	}
    }
