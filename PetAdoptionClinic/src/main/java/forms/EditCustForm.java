package forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import dao.PetClinic;

public class EditCustForm extends Form implements ActionListener {
	
	JButton save;
	JButton cancel;
	JTextField idTF;
	JTextField nameTF;
	JTextField addressTF;
	JTextField ageTF;
	JTextField usernameTF;
	JTextField passwordTF;
	JTextField emailTF;
	JCheckBox IsManagerTF;
	
	int row;
	DefaultTableModel model;

	EditCustForm(PetClinic pc,int row, DefaultTableModel model) {
		super(pc);
		this.row=row;
		this.model=model;
		System.out.println("editor created");
		// TODO Auto-generated constructor stub
	}
	
	public void createAndShowGUI() {
		this.setTitle("Edit Customer");
        this.setLocationRelativeTo(null);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        JPanel panelForAll = new JPanel(new BorderLayout());
        JPanel panelForForm = new JPanel(new SpringLayout());

        idTF = new JTextField(model.getValueAt(row, 0).toString(), 15);
        idTF.setEditable(false);
        nameTF = new JTextField((String) model.getValueAt(row, 1), 15);
        nameTF.setEditable(true);
        addressTF = new JTextField((String) model.getValueAt(row, 2), 15);
        addressTF.setEditable(true);
        ageTF = new JTextField((String) model.getValueAt(row, 3));
        ageTF.setEditable(true);
        usernameTF = new JTextField((String) model.getValueAt(row, 4), 15);
        usernameTF.setEditable(true);
        passwordTF = new JTextField((String) model.getValueAt(row, 5), 15);
        passwordTF.setEditable(true);
        emailTF = new JTextField((String) model.getValueAt(row, 6), 15);
        emailTF.setEditable(true);
        

        JLabel nameLbl = new JLabel("Name:", JLabel.TRAILING);
        JLabel addressLbl = new JLabel("Address:", JLabel.TRAILING);
        JLabel ageLbl = new JLabel("Age:", JLabel.TRAILING);
        JLabel usernameLbl = new JLabel("Username:", JLabel.TRAILING);
        JLabel passwordLbl = new JLabel("Password:", JLabel.TRAILING);
        JLabel emailLbl = new JLabel("Email:", JLabel.TRAILING);
        JLabel idLbl = new JLabel("Id:", JLabel.TRAILING);
        
        idLbl.setLabelFor(idTF);
        nameLbl.setLabelFor(nameTF);
        addressLbl.setLabelFor(addressTF);
        ageLbl.setLabelFor(ageTF);
        usernameLbl.setLabelFor(usernameTF);
        passwordLbl.setLabelFor(passwordTF);
        emailLbl.setLabelFor(emailTF);

        
        panelForForm.add(idLbl);
        panelForForm.add(idTF);
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
        panelForForm.add(emailLbl);
        panelForForm.add(emailTF);

        SpringUtilities.makeCompactGrid(panelForForm, 7, 2, 10, 10, 10, 10);

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
			
			// check if any values are empty
			if(nameTF.getText().isEmpty() || addressTF.getText().isEmpty() || ageTF.getText().isEmpty() || usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty() ||
					emailTF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please leave no fields empty!", "Empty Fields Detected", JOptionPane.WARNING_MESSAGE);
			}
			else {
				// perform save on employee DAO if valid
				model.setValueAt(Integer.parseInt(idTF.getText()), row, 0);
				model.setValueAt(nameTF.getText(), row, 1);
				model.setValueAt(addressTF.getText(), row, 2);
				model.setValueAt(Integer.parseInt(ageTF.getText()), row, 3);
				model.setValueAt(usernameTF.getText(), row, 4);
				model.setValueAt(passwordTF.getText(), row, 5);
				model.setValueAt(emailTF.getText(), row, 6);
				
				this.store.customerDAO.editCustomer(Integer.parseInt(idTF.getText()),nameTF.getText(), addressTF.getText(), ageTF.getText(), usernameTF.getText(),
						passwordTF.getText(), emailTF.getText());
				JOptionPane.showMessageDialog(this, "Customer has been Saved!", "Customer Edit", JOptionPane.INFORMATION_MESSAGE);
				DisplayCustForm form = new DisplayCustForm(this.store);
				form.createAndShowGUI();
				this.dispose();
				
			}
		}
		if(e.getSource().equals(cancel)) {
			// simply close the form
			DisplayCustForm form = new DisplayCustForm(this.store);
			form.createAndShowGUI();
			this.dispose();
			// maybe create main here later for DAO
		}
		
	}

}
