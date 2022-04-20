package forms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginChoose extends JFrame implements ActionListener {
	
    
    JPanel panel = new JPanel(new BorderLayout());

    JPanel messagePanel = new JPanel();
    JLabel message;
    JPanel buttonPanel = new JPanel();
    JButton customerButton;
    JButton employeeButton;
	

    public void createAndShowGUI() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	message = new JLabel("Hello! Please Choose Your Role");
        customerButton = new JButton("I'm a Customer");
        employeeButton = new JButton("I'm a Employee");
        
        messagePanel.add(message);
        buttonPanel.add(customerButton);
        buttonPanel.add(employeeButton);
        panel.add(messagePanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
        // add action listener to buttons
        customerButton.addActionListener(this);
        employeeButton.addActionListener(this);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	        if (e.getSource().equals(customerButton)) {
	        	System.out.println("CUSTOMER ALERT");
	            LoginFormCustomer loginFormCustomer = new LoginFormCustomer();
	            loginFormCustomer.createAndShowGUI();
	            this.dispose();
	        	
	        } else if (e.getSource().equals(employeeButton)) {
	            System.out.println("EMPLOYEE ALERT");
	            LoginFormEmployee loginFormEmployee = new LoginFormEmployee();
	            loginFormEmployee.createAndShowGUI();
	            this.dispose();
	            
	        } else {
	            System.out.println(e.getSource());
	        }
		
	}



}
