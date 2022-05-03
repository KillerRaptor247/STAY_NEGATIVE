package forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import classes.Employee;
import dao.PetClinic;

public class CreateEmpForm extends Form implements ActionListener{
	
	// declare JSwing components
	
	// panels and layout
	JPanel labelPanel = new JPanel(new SpringLayout());
	JPanel radioPanel = new JPanel(new SpringLayout());
	JPanel buttonPanel = new JPanel();
	JPanel formPanel = new JPanel(new BorderLayout());
	
	// Label and Text Fields
	JLabel empIDLbl;
	JLabel empNameLbl;
	JLabel empAddressLbl;
	JLabel empAgeLbl;
	JLabel empUserNameLbl;
	JLabel empPasswordLbl;
	JLabel empEmailLbl;
	JLabel empManagerLbl;
	
	JTextField empIDTF;
	JTextField empNameTF;
	JTextField empAddressTF;
	JTextField empAgeTF;
	JTextField empUsernameTF;
	JTextField empPasswordTF;
	JTextField empEmailTF;
	
	//Buttons
	JRadioButton managerTrue;
	JRadioButton managerFalse;
	JButton createEmpSave;
	JButton createEmpCancel;
	
	// Button Groups
	ButtonGroup managerGroup = new ButtonGroup();

	CreateEmpForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}
	
	public void createAndShowGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Create Employee!");
		// create labels and text fields
		empIDLbl = new JLabel("Employee ID: ");
		empNameLbl = new JLabel("Employee Name: ");
		empAddressLbl = new JLabel("Employee Address: ");
		empAgeLbl = new JLabel("Employee Age: ");
		empUserNameLbl = new JLabel("Employee Username: ");
		empPasswordLbl = new JLabel("Employee Password: ");
		empEmailLbl = new JLabel("Employee Email: ");
		Integer newID = Employee.empCount.get();
		newID++;
		empIDTF = new JTextField(newID.toString(), 20);
		empNameTF = new JTextField("", 20);
		empAddressTF = new JTextField("", 20);
		empAgeTF = new JTextField("", 20);
		empUsernameTF = new JTextField("", 20);
		empPasswordTF = new JTextField("", 20);
		empEmailTF = new JTextField("", 20);
		
		// set non editable textfields
		empIDTF.setEditable(false);
		
		empIDLbl.setLabelFor(empIDTF);
		empNameLbl.setLabelFor(empNameTF);
		empAddressLbl.setLabelFor(empAddressTF);
		empAgeLbl.setLabelFor(empAddressTF);
		empUserNameLbl.setLabelFor(empUsernameTF);
		empPasswordLbl.setLabelFor(empPasswordTF);
		empEmailLbl.setLabelFor(empEmailTF);
		
		// add all labels and textfields to panel
		labelPanel.add(empIDLbl);
		labelPanel.add(empIDTF);
		labelPanel.add(empNameLbl);
		labelPanel.add(empNameTF);
		labelPanel.add(empAddressLbl);
		labelPanel.add(empAddressTF);
		labelPanel.add(empAgeLbl);
		labelPanel.add(empAgeTF);
		labelPanel.add(empUserNameLbl);
		labelPanel.add(empUsernameTF);
		labelPanel.add(empPasswordLbl);
		labelPanel.add(empPasswordTF);
		labelPanel.add(empEmailLbl);
		labelPanel.add(empEmailTF);
		
		SpringUtilities.makeCompactGrid(labelPanel, 7, 2, 10, 10, 10, 10);
		
		// create radio label and controls
		empManagerLbl = new JLabel("Manager Status: ");
		managerTrue = new JRadioButton("Yes");
		managerFalse = new JRadioButton("No");
		managerGroup.add(managerTrue);
		managerGroup.add(managerFalse);
		empManagerLbl.setLabelFor(managerTrue);
		empManagerLbl.setLabelFor(managerFalse);
		
		// add to radio panel
		radioPanel.add(empManagerLbl);
		radioPanel.add(managerTrue);
		radioPanel.add(managerFalse);
		SpringUtilities.makeCompactGrid(radioPanel, 1, 3, 13, 0, 10, 10);
		
		managerTrue.setSelected(true);
		
		// create save and cancel buttons
		createEmpSave = new JButton("Save");
		createEmpCancel = new JButton("Cancel");
		// add action listeners for buttons
		createEmpSave.addActionListener(this);
		createEmpCancel.addActionListener(this);
		
		// add to button panel
		buttonPanel.add(createEmpSave);
		buttonPanel.add(createEmpCancel);
		
		labelPanel.setOpaque(true);
		radioPanel.setOpaque(true);
		buttonPanel.setOpaque(true);
		// add smaller panels to larger panel
		formPanel.add(labelPanel, BorderLayout.NORTH);
		formPanel.add(radioPanel, BorderLayout.CENTER);
		formPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		
		// if the store is empty, the current employee HAS to be a manager
		if(this.store.isEmployeeEmpty()) {
			managerTrue.setSelected(true);
			managerFalse.setEnabled(false);
		}
		
		formPanel.setOpaque(true);
		this.add(formPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(createEmpSave)) {
			// if any fields are empty display error message
			if(empNameTF.getText().isEmpty() || empAddressTF.getText().isEmpty() || empAgeTF.getText().isEmpty() || empUsernameTF.getText().isEmpty() || empPasswordTF.getText().isEmpty() ||
					empEmailTF.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please leave no fields empty!", "Empty Fields Detected", JOptionPane.WARNING_MESSAGE);
			}
			else {
				if(this.store.isEmployeeEmpty()) {
					// create employee and save it
					store.employeeDAO.addEmployee(empNameTF.getText(), empAddressTF.getText(), empAgeTF.getText(), empUsernameTF.getText(), empPasswordTF.getText(), empEmailTF.getText(),
							managerTrue.isSelected());
					LoginFormEmployee form = new LoginFormEmployee(this.store);
					form.createAndShowGUI();
					this.dispose();
				}
				else {
					// create employee and save it
					store.employeeDAO.addEmployee(empNameTF.getText(), empAddressTF.getText(), empAgeTF.getText(), empUsernameTF.getText(), empPasswordTF.getText(), empEmailTF.getText(),
							managerTrue.isSelected());
					HomePage form = new HomePage(this.store);
					form.createAndShowGUI();
					this.dispose();
				}
			}
		}
		if(e.getSource().equals(createEmpCancel)) {
			System.out.println("Employee creation cancelled");
			HomePage form = new HomePage(this.store);
			form.createAndShowGUI();
			this.dispose();
		}
	}
	
}
