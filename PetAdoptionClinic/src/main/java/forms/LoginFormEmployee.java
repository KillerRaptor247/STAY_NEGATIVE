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

public class LoginFormEmployee extends JFrame implements ActionListener {

    // variables
    JButton signInButton;
    // test fail button
    JButton failButton;
    JPanel panel = new JPanel(new GridBagLayout());
    JLabel userLabel, passLabel;
    JLabel welcomeLabel;
    JTextField userText, passText;
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

        // add test fail button DELETE THIS LATER YOU BOZO
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(failButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
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

    }

    // define abstract method actionPerformed which will be called on button click
    public void actionPerformed(ActionEvent e) {
        // get the values from the textfields
        // and check if authentic
        // but for now simple implementation
        if (e.getSource().equals(signInButton)) {
        	HomePage form = new HomePage();
        	form.createAndShowGUI();
            this.dispose();
        } else if (e.getSource().equals(failButton)) {
            System.out.println("WRONG PASSWORD INPUT: SYSTEM FAULT");
        } else {
            System.out.println("SYSTEM ERROR");
        }
    }
}