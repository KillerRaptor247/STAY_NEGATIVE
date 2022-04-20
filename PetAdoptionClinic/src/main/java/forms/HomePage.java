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

public class HomePage extends JFrame implements ActionListener{
	
	// declare JSwing components
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu createMenu;
	JMenu editMenu;
	JMenuItem SignOutItem;
	JMenuItem ImportItem;
	JMenuItem ExportItem;
	JMenuItem CreateEmpItem;
	JMenuItem  CreateCusItem;
	JMenuItem CreatePetItem;
	JMenuItem EditEmpItem;
	JMenuItem EditCusItem;
	JMenuItem EditPetItem;
	
	// panels and layout
	JPanel panel = new JPanel(new GridBagLayout());
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	// Labels and Buttons
	JLabel welcomeLabel;
	JButton checkoutButton;
	JButton displayButton;
	
	public void createAndShowGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = Toolkit.getDefaultToolkit().getImage("HomePage.jpg");
                g.drawImage(img, 0, 0, null);
            }
        });
		
        ImageIcon img = new ImageIcon("dog-32-32.png");
        this.setIconImage(img.getImage());
		
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		fileMenu.getAccessibleContext().setAccessibleDescription("Program Functionality is here");
		
		createMenu = new JMenu("Create");
		createMenu.getAccessibleContext().setAccessibleDescription("Creation Forms are here");
		
		editMenu = new JMenu("Edit");
		editMenu.getAccessibleContext().setAccessibleDescription("Edit Forms are here");
		
		SignOutItem = new JMenuItem("Sign Out");
		ImportItem = new JMenuItem("Import Data");
		ExportItem = new JMenuItem("Export Data");
		
		fileMenu.add(SignOutItem);
		fileMenu.add(ImportItem);
		fileMenu.add(ExportItem);
		
		CreateEmpItem = new JMenuItem("Create Employee");
		CreateCusItem = new JMenuItem("Create Customer");
		CreatePetItem = new JMenuItem("Create Pet");

		// Create Pet Form Call
		CreatePetItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePetForm create = new CreatePetForm();
				create.createAndShowGUI();
				// TODO: wait to get data to database
			}
		});
		
		createMenu.add(CreateEmpItem);
		createMenu.add(CreateCusItem);
		createMenu.add(CreatePetItem);
		
		EditEmpItem = new JMenuItem("Edit Employee");
		EditCusItem = new JMenuItem("Edit Customer");
		EditPetItem = new JMenuItem("Edit Pet");
		
		editMenu.add(EditEmpItem);
		editMenu.add(EditCusItem);
		editMenu.add(EditPetItem);
		
		menuBar.add(fileMenu);
		menuBar.add(createMenu);
		menuBar.add(editMenu);
		
		// buttons and panel
		welcomeLabel = new JLabel();
		welcomeLabel.setText("Welcome to the Pet Adoption Center!");
		
		checkoutButton = new JButton("Adopt a Pet!");
		displayButton = new JButton("Display our Pets!");
		
		panel.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(welcomeLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		panel.add(displayButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(checkoutButton, gbc);
		
		add(panel, BorderLayout.CENTER);
		pack();
		
		EditPetItem.addActionListener(this);
		displayButton.addActionListener(this);
		SignOutItem.addActionListener(this);
		checkoutButton.addActionListener(this);
		
		
		this.setTitle("Home Page");
		this.setJMenuBar(menuBar);
		this.setSize(400, 250);
		setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(displayButton)) {
            DisplayForm display = new DisplayForm();
            display.createAndShowGUI();
	}
		else if(e.getSource().equals(EditPetItem)) {
			EditPetForm edit = new EditPetForm();
			edit.createAndShowGui();
		}
		else if(e.getSource().equals(SignOutItem)) {
			this.dispose();
	    	LoginFormEmployee form = new LoginFormEmployee();
	    	form.createAndShowGUI();
		}
		else if(e.getSource().equals(checkoutButton)) {
			CheckoutForm form = new CheckoutForm();
			form.createAndShowGUI();
		}
		
	}

}
