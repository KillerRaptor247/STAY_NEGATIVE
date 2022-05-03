package forms;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.PetClinic;

public class LoginFormEmployee extends Form implements ActionListener {

    public LoginFormEmployee(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	// variables
    JButton signInButton;
    // test fail button
    JButton failButton;
    JPanel panel = new JPanel(new GridBagLayout());
    JLabel userLabel, passLabel;
    JLabel welcomeLabel;
    JTextField userText;
    JPasswordField passText;
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    // constructor
    public void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = Toolkit.getDefaultToolkit().getImage("dog.jpg");
                g.drawImage(img, 0, 0, null);
            }
        });

        ImageIcon img = new ImageIcon("dog-32-32.png");
        this.setIconImage(img.getImage());

        // create welcomeLabel
        welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome Employee! Please Sign in!");

        //create labels for username
        userLabel = new JLabel();
        userLabel.setText("Username");

        // create text field to get Username;
        userText = new JTextField(15);

        // create label for password
        passLabel = new JLabel();
        passLabel.setText("Password");

        // create password text field to get password
        passText = new JPasswordField(15);

        // create sign in button
        signInButton = new JButton("Sign in");
        // create fail button for error message
        failButton = new JButton("Intentional Fault");

        // create panel to put elements on
        panel.setLayout(layout);

        //add welcome label
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(welcomeLabel, gbc);

        // add userlabel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(userLabel, gbc);

        // add user text field
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(userText, gbc);

        // add passLabel
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(passLabel, gbc);

        // add passtext
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(passText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(signInButton, gbc);

        //set border to panel
        add(panel, BorderLayout.CENTER);

        //perform action on button click
        signInButton.addActionListener(this);
        failButton.addActionListener(this);
        setTitle("Login Form");

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(310, 200);
        setVisible(true);
        
        // check to see if store is empty
        if(this.store.isEmployeeEmpty()) {
        	JOptionPane.showMessageDialog(this, "No Employees Detected! Going to Manager Creation!",
        			"No Employees Found.", JOptionPane.WARNING_MESSAGE);
        	CreateEmpForm form = new CreateEmpForm(this.store);
        	form.createAndShowGUI();
        	this.dispose();
        }

    }

    // define abstract method actionPerformed which will be called on button click
    public void actionPerformed(ActionEvent e) {
    	// FULL LOGIN FUNCTIONALITY
    	// only login if user can be found
        if (e.getSource().equals(signInButton)) {
        	
        	if(this.store.empLogin(userText.getText(), String.valueOf(passText.getPassword())))
        	{
               	HomePage form = new HomePage(this.store);
            	form.createAndShowGUI();
                this.dispose();
        		
        	}
        	// if user cant be found throw error message
        	else {
        		JOptionPane.showMessageDialog(this, "Invalid Login! Please Try Again!",
        				"Employee Login Fail!", JOptionPane.ERROR_MESSAGE);
        	}
        } 
    }
}