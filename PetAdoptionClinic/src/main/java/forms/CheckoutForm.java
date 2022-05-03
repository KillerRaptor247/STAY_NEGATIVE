package forms;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import classes.Pet;
import dao.PetClinic;

public class CheckoutForm extends Form implements ActionListener{
	
	    CheckoutForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

		// declare JSwing components
		JPanel panel = new JPanel(new GridBagLayout());
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		DefaultTableModel petModel = new DefaultTableModel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JTable petTable;
		JScrollPane petPane;
		ImageIcon img;
		JButton returnButton = new JButton("Cancel");
		JButton adoptButton = new JButton("Adopt!");
		
		// JLabels
		JLabel welcomeMessage;
		
		public void createAndShowGUI() {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setContentPane(new JPanel() {
	            @Override
	            public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Image img = Toolkit.getDefaultToolkit().getImage("display2.jpg");
	                g.drawImage(img, 0, 250, null);
	            }
	        });
			
			
			img = new ImageIcon("dog-32-32.png");
			this.setIconImage(img.getImage());
			
			welcomeMessage = new JLabel("Please Adopt a Pet!");
			petModel.addColumn("ID");
			petModel.addColumn("Name");
			petModel.addColumn("Age");
			petModel.addColumn("Breed");
			petModel.addColumn("Sex");
			petModel.addColumn("Species");
			
			for(Pet p : store.petDAO.pets.values()) {
				petModel.addRow(new Object[] {p.getID(), p.getName(), p.getAge(), p.getBreed(), p.getSex().toString(), p.getSpecies().toString()});
			}
			
			petTable = new JTable(petModel);
			petPane = new JScrollPane(petTable);
			petPane.setPreferredSize(new Dimension(500, 250));
			
			panel.setLayout(layout);
			buttonPanel.setLayout(layout);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			panel.add(welcomeMessage, gbc);
			
			gbc.gridwidth = 1;
			buttonPanel.add(returnButton, gbc);
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			buttonPanel.add(adoptButton, gbc);
			
			adoptButton.addActionListener(this);
			returnButton.addActionListener(this);
			
			add(panel, BorderLayout.NORTH);
			add(petPane, BorderLayout.CENTER);
			add(buttonPanel, BorderLayout.SOUTH);
			
			this.setTitle("Adopt a Pet!");
			setSize(510,500);
			setLocationRelativeTo(null);
			setVisible(true);
			
		}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(returnButton)) {
			HomePage form = new HomePage(this.store);
			form.createAndShowGUI();
            this.dispose();
            }
		if(e.getSource().equals(adoptButton)) {
			if(petTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Please Select a Row in Table First!", "No Selection!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				// get petId to know which pet to grab
				int petId = Integer.parseInt(petTable.getValueAt(petTable.getSelectedRow(), 0).toString());
				int result = JOptionPane.showConfirmDialog(this, "Would You Like to Sign-In?", "Customer Login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					LoginFormCustomer customer = new LoginFormCustomer(this.store, petId);
					customer.createAndShowGUI();
					this.dispose();
				}
				else if(result == JOptionPane.NO_OPTION) {
					System.out.println("NON SIGN IN ADOPT FORM");
					store.signedInCustomer = null;
					RecieptForm form = new RecieptForm(this.store, petId);
					form.createAndShowGUI();
					this.dispose();
				}
				
			}
		}
		
	}
	

}
