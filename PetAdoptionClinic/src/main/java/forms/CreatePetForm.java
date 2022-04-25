package forms;
import javax.swing.*;

import dao.PetClinic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class CreatePetForm extends Form implements ActionListener{
     
	JButton save;
	JButton cancel;


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

        
        JTextField idTF = new JTextField("1");
        idTF.setEditable(false);
        JTextField nameTF = new JTextField("e.g. Boo-Boo", 15);
        nameTF.setEditable(true);
        JTextField ageTF = new JTextField("e.g. 1 (Integer Please)", 15);
        ageTF.setEditable(true);
        JTextField birthdayTF = new JTextField("e.g. 2020.6.20", 15);
        birthdayTF.setEditable(true);
        JTextField breedTF = new JTextField("e.g. Tabby", 15);
        breedTF.setEditable(true);
        
        JLabel idLbl = new JLabel("ID:", JLabel.TRAILING);
        JLabel nameLbl = new JLabel("Name:", JLabel.TRAILING);
        JLabel ageLbl = new JLabel("Age:", JLabel.TRAILING);
        JLabel birthdayLbl = new JLabel("Birthday:", JLabel.TRAILING);
        JLabel breedLbl = new JLabel("Breed:", JLabel.TRAILING);

        idLbl.setLabelFor(idTF);
        nameLbl.setLabelFor(nameTF);
        ageLbl.setLabelFor(ageTF);
        birthdayLbl.setLabelFor(birthdayTF);
        breedLbl.setLabelFor(breedTF);

        
        panelForForm.add(idLbl);
        panelForForm.add(idTF);
        panelForForm.add(nameLbl);
        panelForForm.add(nameTF);
        panelForForm.add(ageLbl);
        panelForForm.add(ageTF);
        panelForForm.add(birthdayLbl);
        panelForForm.add(birthdayTF);
        panelForForm.add(breedLbl);
        panelForForm.add(breedTF);

        SpringUtilities.makeCompactGrid(panelForForm, 5, 2, 10, 10, 10, 10);

        JPanel panelForCheckbox = new JPanel(new SpringLayout());
        JLabel genderLbl = new JLabel("Gender:", JLabel.TRAILING);
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JLabel speciesLbl = new JLabel("Species:", JLabel.TRAILING);
        JRadioButton cat = new JRadioButton("Cat");
        JRadioButton dog = new JRadioButton("Dog");

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
			System.out.println("Pet Should Be Created and Saved");
			this.dispose();
		}
		if(e.getSource().equals(cancel)) {
			System.out.println("Pet Creation Cancelled");
			this.dispose();
		}
	}
    }
