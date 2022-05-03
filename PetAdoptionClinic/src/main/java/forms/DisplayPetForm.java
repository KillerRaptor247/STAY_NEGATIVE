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

public class DisplayPetForm extends Form implements ActionListener {
	
	DisplayPetForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	// declare JSwing components
	JPanel panel = new JPanel(new GridBagLayout());
	DefaultTableModel petModel = new DefaultTableModel();
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JTable petTable;
	JPopupMenu popupMenu;
	JMenuItem deleteItem;
	JMenuItem editItem;
	JScrollPane petPane;
	ImageIcon img;
	JButton returnButton = new JButton("Return");
	
	//JText and JLabels
	JLabel welcomeMessage;
	
	public void createAndShowGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		
		welcomeMessage = new JLabel("Here Are Our Pets!");
		petModel.addColumn("Id");
		petModel.addColumn("Name");
		petModel.addColumn("Age");
		petModel.addColumn("Breed");
		petModel.addColumn("Sex");
		petModel.addColumn("Species");
		
		for(Pet p : store.petDAO.pets.values()) {
			petModel.addRow(new Object[] {p.getID(), p.getName(), p.getAge(), p.getBreed(), p.getSex().toString(), p.getSpecies().toString()});
		}
		
		petTable = new JTable(petModel);
		popupMenu = new JPopupMenu();
		deleteItem = new JMenuItem("Delete");
		editItem = new JMenuItem("Edit");
		deleteItem.addActionListener(this);
		editItem.addActionListener(this);
		petPane = new JScrollPane(petTable);
		petPane.setPreferredSize(new Dimension(500, 250));
		
		popupMenu.add(deleteItem);
		popupMenu.add(editItem);
		
		petTable.setComponentPopupMenu(popupMenu);
		
		panel.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(welcomeMessage, gbc);
		
		
		returnButton.addActionListener(this);
		
		add(panel, BorderLayout.CENTER);
		add(petPane, BorderLayout.SOUTH);
		add(returnButton, BorderLayout.PAGE_END);
		this.setTitle("Display Pets!");
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
		else {
			if(petTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Please Select a Row in Table First!", "No Selection!", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JMenuItem menu = (JMenuItem) e.getSource();
				if (menu == deleteItem) {
				    int selectedRow = petTable.getSelectedRow();
				    this.store.petDAO.removePet(Integer.parseInt(petModel.getValueAt(selectedRow, 0).toString()));
				    petModel.removeRow(selectedRow);
				    JOptionPane.showMessageDialog(this, "Pet has been Removed!", "Pet Removal", JOptionPane.INFORMATION_MESSAGE);
		        } else if (menu == editItem) {
					int selectedRow = petTable.getSelectedRow();
					EditPetForm ed= new EditPetForm(this.store,selectedRow,petModel);
					ed.createAndShowGUI();
					petModel.fireTableDataChanged();
					this.dispose();
		        }
			}
			
		}
	}

}
