package forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import dao.PetClinic;

public class EditCustForm extends Form implements ActionListener {
	
	JButton save;
	JButton cancel;

	EditCustForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}
	
	public void createAndShowGUI() {
		this.setTitle("Edit Customer");
        this.setLocationRelativeTo(null);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        JPanel panelForAll = new JPanel(new BorderLayout());
        JPanel panelForForm = new JPanel(new SpringLayout());

        JTextField nameTF = new JTextField("Dante", 15);
        nameTF.setEditable(true);
        JTextField addressTF = new JTextField("123 Baylor Street", 15);
        addressTF.setEditable(true);
        JTextField ageTF = new JTextField("24", 15);
        ageTF.setEditable(true);
        JTextField usernameTF = new JTextField("dantehart123", 15);
        usernameTF.setEditable(true);
        JTextField passwordTF = new JTextField("password", 15);
        passwordTF.setEditable(true);

        JLabel nameLbl = new JLabel("Name:", JLabel.TRAILING);
        JLabel addressLbl = new JLabel("Address:", JLabel.TRAILING);
        JLabel ageLbl = new JLabel("Age:", JLabel.TRAILING);
        JLabel usernameLbl = new JLabel("Username:", JLabel.TRAILING);
        JLabel passwordLbl = new JLabel("Password:", JLabel.TRAILING);

        nameLbl.setLabelFor(nameTF);
        addressLbl.setLabelFor(addressTF);
        ageLbl.setLabelFor(ageTF);
        usernameLbl.setLabelFor(usernameTF);
        passwordLbl.setLabelFor(passwordTF);

        panelForForm.add(nameLbl);
        panelForForm.add(nameTF);
        panelForForm.add(addressLbl);
        panelForForm.add(addressTF);
        panelForForm.add(ageLbl);
        panelForForm.add(ageTF);
        panelForForm.add(usernameLbl);
        panelForForm.add(usernameTF);
        panelForForm.add(passwordLbl);
        panelForForm.add(passwordTF);

        SpringUtilities.makeCompactGrid(panelForForm, 5, 2, 10, 10, 10, 10);

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
        panelForAll.add(panelForButton, BorderLayout.SOUTH);

        panelForAll.setOpaque(true);
        this.add(panelForAll);
        this.pack();
        this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			// perform save on customer DAO if valid
		}
		if(e.getSource().equals(cancel)) {
			// simply close the form
			this.dispose();
			// maybe create main here later for DAO
		}
		
	}

}
