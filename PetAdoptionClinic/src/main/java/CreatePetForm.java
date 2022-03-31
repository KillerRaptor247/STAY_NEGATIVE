import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

<<<<<<< HEAD:PetAdoptionClinic/src/main/java/CreatePetForm.java
public class CreatePetForm {
    public void createAndShowGui() {
        JFrame frame = new JFrame("Edit Form");
=======
public class EditForm {
    public void createAndShowGUI() {
    	
    	ImageIcon img = new ImageIcon("dog-32-32.png");
		
        final JFrame frame = new JFrame("Edit Form");
        frame.setIconImage(img.getImage());
>>>>>>> 1bdb2b7 (Implemented Display and Checkout):PetAdoptionClinic/src/main/java/EditForm.java
        frame.setLocationRelativeTo(null);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        JPanel panelForAll = new JPanel(new BorderLayout());
        JPanel panelForForm = new JPanel(new SpringLayout());

        JTextField nameTF = new JTextField("e.g. Boo-Boo", 15);
        nameTF.setEditable(true);
        JTextField ageTF = new JTextField("e.g. 1 (Integer Please)", 15);
        ageTF.setEditable(true);
        JTextField birthdayTF = new JTextField("e.g. 2020.6.20", 15);
        birthdayTF.setEditable(true);
        JTextField colorTF = new JTextField("e.g. Gold", 15);
        colorTF.setEditable(true);
        JTextField weightTF = new JTextField("e.g. 11 (lb Please)", 15);
        weightTF.setEditable(true);

        JLabel nameLbl = new JLabel("Name:", JLabel.TRAILING);
        JLabel ageLbl = new JLabel("Age:", JLabel.TRAILING);
        JLabel birthdayLbl = new JLabel("Birthday:", JLabel.TRAILING);
        JLabel colorLbl = new JLabel("Color:", JLabel.TRAILING);
        JLabel weightLbl = new JLabel("Weight:", JLabel.TRAILING);

        nameLbl.setLabelFor(nameTF);
        ageLbl.setLabelFor(ageTF);
        birthdayLbl.setLabelFor(birthdayTF);
        colorLbl.setLabelFor(colorTF);
        weightLbl.setLabelFor(weightTF);

        panelForForm.add(nameLbl);
        panelForForm.add(nameTF);
        panelForForm.add(ageLbl);
        panelForForm.add(ageTF);
        panelForForm.add(birthdayLbl);
        panelForForm.add(birthdayTF);
        panelForForm.add(colorLbl);
        panelForForm.add(colorTF);
        panelForForm.add(weightLbl);
        panelForForm.add(weightTF);

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

        JPanel panelForButton = new JPanel();
        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                // TODO: wait for implement
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panelForButton.add(cancel);
        panelForButton.add(save);

        panelForForm.setOpaque(true);
        panelForButton.setOpaque(true);
        panelForForm.setOpaque(true);
        panelForAll.add(panelForForm, BorderLayout.NORTH);
        panelForAll.add(panelForCheckbox, BorderLayout.CENTER);
        panelForAll.add(panelForButton, BorderLayout.SOUTH);

        panelForAll.setOpaque(true);
        frame.add(panelForAll);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
