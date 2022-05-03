package forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import classes.Reciept;
import classes.Sale;
import dao.PetClinic;

public class RecieptForm extends Form implements ActionListener{
	
	RecieptForm(PetClinic pc, Integer petId) {
		super(pc);
		// TODO Auto-generated constructor stub
		this.petID = petId;
	}
	// Declare ID for pet look up
	Integer petID;
	
	// declare JSwing components
	JPanel labelPanel = new JPanel(new SpringLayout());
	JPanel buttonPanel = new JPanel();
	JPanel formPanel = new JPanel(new BorderLayout());
	
	// Label and Text Fields
	JLabel petIDLbl;
	JLabel petNameLbl;
	JLabel cusIDLbl;
	JLabel cusNameLbl;
	JLabel empIDLbl;
	JLabel empNameLbl;
	JLabel adoptDateLbl;
	
	JTextField petIDTF;
	JTextField petNameTF;
	JTextField cusIDTF;
	JTextField cusNameTF;
	JTextField empIDTF;
	JTextField empNameTF;
	JTextField adoptDateTF;
	
	JButton closeButton;
	
	public void createAndShowGUI() {
		this.setTitle("Certificate of Adoption!");
		// create labels and Text Fields
		petIDLbl = new JLabel("Pet ID: ");
		petNameLbl = new JLabel("Pet Name: ");
		cusIDLbl = new JLabel("Customer ID: ");
		cusNameLbl = new JLabel("Customer Name: ");
		empIDLbl = new JLabel("Employee ID: ");
		empNameLbl = new JLabel("Employee Name: ");
		adoptDateLbl = new JLabel("Adoption Date: ");
		
		petIDTF = new JTextField(petID.toString(), 15);
		petNameTF = new JTextField(store.petDAO.pets.get(petID).getName(), 15);
		// first check if there is a logged in customer otherwise it is a guest login
		if(store.signedInCustomer != null) {
			cusIDTF = new JTextField(store.signedInCustomer.getID().toString(), 15);
			cusNameTF = new JTextField(store.signedInCustomer.getName(), 15);
		}
		else {
			cusIDTF = new JTextField("N\\A", 15);
			cusNameTF = new JTextField("GUEST", 15);
		}
		empIDTF = new JTextField(store.signedInEmployee.getID().toString(), 15);
		empNameTF = new JTextField(store.signedInEmployee.getName(), 15);
		
		// create date to put into textfield
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		adoptDateTF = new JTextField(dtf.format(now).toString(), 15);
		
		// make textfields non editable
		petIDTF.setEditable(false);
		petNameTF.setEditable(false);
		cusIDTF.setEditable(false);
		cusNameTF.setEditable(false);
		empIDTF.setEditable(false);
		empNameTF.setEditable(false);
		adoptDateTF.setEditable(false);
		
		// add labels and textfields to panel
		labelPanel.add(petIDLbl);
		labelPanel.add(petIDTF);
		labelPanel.add(petNameLbl);
		labelPanel.add(petNameTF);
		labelPanel.add(cusIDLbl);
		labelPanel.add(cusIDTF);
		labelPanel.add(cusNameLbl);
		labelPanel.add(cusNameTF);
		labelPanel.add(empIDLbl);
		labelPanel.add(empIDTF);
		labelPanel.add(empNameLbl);
		labelPanel.add(empNameTF);
		labelPanel.add(adoptDateLbl);
		labelPanel.add(adoptDateTF);
		
		SpringUtilities.makeCompactGrid(labelPanel, 7, 2, 10, 10, 10, 10);
		
		// create close button
		closeButton = new JButton("Close");
		
		closeButton.addActionListener(this);
		
		// add to button panel
		buttonPanel.add(closeButton);
		
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
		if(e.getSource().equals(closeButton)) {
			// after the reciept has been shown
			// generate the reciept
			Reciept newReciept = new Reciept(new Sale(store.petDAO.pets.get(petID),store.signedInCustomer, store.signedInEmployee, adoptDateTF.getText()));
			
			// add the reciept to the store's collection of reciepts
			store.addReciept(newReciept);
			
			// finally remove the pet from the petDAO to show the pet has been adopted!
			store.petDAO.removePet(petID);
			
			JOptionPane.showMessageDialog(this, "Thank you so much!", "Pet Adopted!", JOptionPane.INFORMATION_MESSAGE);
			
			// close the form and return to the homepage
			HomePage form = new HomePage(this.store);
			form.createAndShowGUI();
			this.dispose();
		}
		
	}
	
	

}
