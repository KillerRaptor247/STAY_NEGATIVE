package forms;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import classes.Sex;
import classes.Species;
import dao.PetClinic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

// TODO: get the data from database or list maybe still pending
public class EditPetForm extends Form implements ActionListener{
	
	JButton save;
	JButton cancel;
	
	JTextField idTF;
	JTextField nameTF;
	JTextField ageTF;
	JTextField breedTF;
	
	JRadioButton male, female, dog, cat;
	
	int row;
	DefaultTableModel model;
	
    EditPetForm(PetClinic pc, int row, DefaultTableModel model) {
		super(pc);
		this.row = row;
		this.model = model;
		// TODO Auto-generated constructor stub
	}

	public void createAndShowGUI() {
		this.setTitle("Edit Pet Form");
        this.setLocationRelativeTo(null);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        JPanel panelForAll = new JPanel(new BorderLayout());
        JPanel panelForForm = new JPanel(new SpringLayout());

        idTF = new JTextField(model.getValueAt(row, 0).toString(), 15);
        idTF.setEditable(false);
        nameTF = new JTextField(model.getValueAt(row, 1).toString(), 15);
        nameTF.setEditable(true);
        ageTF = new JTextField(model.getValueAt(row, 2).toString(), 15);
        ageTF.setEditable(true);
        breedTF = new JTextField(model.getValueAt(row, 3).toString(), 15);
        breedTF.setEditable(true);

        JLabel idLbl = new JLabel("Id:", JLabel.TRAILING);
        JLabel nameLbl = new JLabel("Name:", JLabel.TRAILING);
        JLabel ageLbl = new JLabel("Age:", JLabel.TRAILING);
        JLabel breedLbl = new JLabel("Breed:", JLabel.TRAILING);

        nameLbl.setLabelFor(nameTF);
        ageLbl.setLabelFor(ageTF);
        idLbl.setLabelFor(idTF);
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

        JPanel panelForButton = new JPanel();
        save = new JButton("Save");
        cancel = new JButton("Cancel");
        save.addActionListener(this);
        cancel.addActionListener(this);
        
        cat.setSelected(true);
        male.setSelected(true);

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
        this.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			if(nameTF.getText().isEmpty() || ageTF.getText().isEmpty() || breedTF.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Please leave no fields empty!", "Empty Fields Detected", JOptionPane.WARNING_MESSAGE);
			}else {
				Sex sex;
				Species sp;
				
				model.setValueAt(nameTF.getText(), row, 1);
				model.setValueAt(ageTF.getText(), row, 2);
				model.setValueAt(breedTF.getText(), row, 3);
				
				if(male.isSelected()) {
					model.setValueAt("Male", row, 4);
					sex = Sex.MALE;
				}else {
					model.setValueAt("Female", row, 4);
					sex = Sex.FEMALE;
				}
				if(dog.isSelected()) {
					model.setValueAt("Dog", row, 5);
					sp = Species.DOG;
				}else {
					model.setValueAt("Cat", row, 5);
					sp = Species.CAT;
				}
				
				this.store.petDAO.editPet(Integer.parseInt(idTF.getText()), nameTF.getText(), ageTF.getText(), breedTF.getText(), sp, sex);
				
				JOptionPane.showMessageDialog(this, "Pet has been Saved!", "Pet Edit", JOptionPane.INFORMATION_MESSAGE);
				DisplayForm form = new DisplayForm(this.store);
				form.createAndShowGUI();
				this.dispose();
			}
		}
		if(e.getSource().equals(cancel)) {
			DisplayForm form = new DisplayForm(this.store);
			form.createAndShowGUI();
			this.dispose();
		}
	}
}
