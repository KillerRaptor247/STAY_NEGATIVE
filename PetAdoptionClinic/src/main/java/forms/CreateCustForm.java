package forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import dao.PetClinic;

public class CreateCustForm extends Form implements ActionListener{

	CreateCustForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	// declare JSwing components
	
	// panels and layout
	JPanel labelPanel = new JPanel(new SpringLayout());
	JPanel buttonPanel = new JPanel();
	JPanel formPanel = new JPanel(new BorderLayout());
	
	// Label and Text Fields
	JLabel cusNameLbl;
	JLabel cusAddressLbl;
	JLabel cusAgeLbl;
	JLabel cusUserNameLbl;
	JLabel cusPasswordLbl;
	JLabel cusEmailLbl;
	
	JTextField cusNameTF;
	JTextField cusAddressTF;
	JTextField cusAgeTF;
	JTextField cusUsernameTF;
	JPasswordField cusPasswordPF;
	JTextField cusEmailTF;
	
	//Buttons
	JButton createCusSave;
	JButton createCusCancel;
	

	
	public void createAndShowGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Create Customer!");
		// create labels and text fields
		cusNameLbl = new JLabel("Custoemr Name: ");
		cusAddressLbl = new JLabel("Customer Address: ");
		cusAgeLbl = new JLabel("Customer Age: ");
		cusUserNameLbl = new JLabel("Customer Username: ");
		cusPasswordLbl = new JLabel("Customer Password: ");
		cusEmailLbl = new JLabel("Customer Email: ");
		
		cusNameTF = new JTextField("Bobby", 20);
		cusAddressTF = new JTextField("224 Cashion Ln", 20);
		cusAgeTF = new JTextField("24", 20);
		cusUsernameTF = new JTextField("bobbyBaylor", 20);
		cusPasswordPF = new JPasswordField("password", 20);
		cusEmailTF = new JTextField("dantehart@baylor.edu", 20);
		
		// set non editable textfields
		cusPasswordPF.setEditable(false);
		
		cusNameLbl.setLabelFor(cusNameTF);
		cusAddressLbl.setLabelFor(cusAddressTF);
		cusAgeLbl.setLabelFor(cusAddressTF);
		cusUserNameLbl.setLabelFor(cusUsernameTF);
		cusPasswordLbl.setLabelFor(cusPasswordPF);
		cusEmailLbl.setLabelFor(cusEmailTF);
		
		// add all labels and textfields to panel
		labelPanel.add(cusNameLbl);
		labelPanel.add(cusNameTF);
		labelPanel.add(cusAddressLbl);
		labelPanel.add(cusAddressTF);
		labelPanel.add(cusAgeLbl);
		labelPanel.add(cusAgeTF);
		labelPanel.add(cusUserNameLbl);
		labelPanel.add(cusUsernameTF);
		labelPanel.add(cusPasswordLbl);
		labelPanel.add(cusPasswordPF);
		labelPanel.add(cusEmailLbl);
		labelPanel.add(cusEmailTF);
		
		SpringUtilities.makeCompactGrid(labelPanel, 6, 2, 10, 10, 10, 10);
		
		// create save and cancel buttons
		createCusSave = new JButton("Save");
		createCusCancel = new JButton("Cancel");
		// add action listeners for buttons
		createCusSave.addActionListener(this);
		createCusCancel.addActionListener(this);
		
		// add to button panel
		buttonPanel.add(createCusSave);
		buttonPanel.add(createCusCancel);
		
		labelPanel.setOpaque(true);
		buttonPanel.setOpaque(true);
		// add smaller panels to larger panel
		formPanel.add(labelPanel, BorderLayout.NORTH);
		formPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		formPanel.setOpaque(true);
		this.add(formPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(createCusSave)) {
			System.out.println("Should Create and Save Customer");
			this.dispose();
		}
		if(e.getSource().equals(createCusCancel)) {
			System.out.println("Customer Creation Cancelled");
			this.dispose();
		}
		
	}

}
