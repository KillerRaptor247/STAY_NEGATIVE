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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Customer;
import dao.PetClinic;

public class DisplayCustForm extends Form implements ActionListener{

	DisplayCustForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	// declare JSwing components
		JPanel panel = new JPanel(new GridBagLayout());
		DefaultTableModel custModel = new DefaultTableModel(){
		    Class[] types = new Class [] {
		            //COL. TYPES ARE HERE!!!
		    		java.lang.Integer.class,java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
		            java.lang.String.class, java.lang.String.class, java.lang.String.class
		        };
		         
		        @Override
		        public Class getColumnClass(int columnIndex) {
		            return types [columnIndex];
		        }
		    };;
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JTable custTable;
		JPopupMenu popupMenu;
		JMenuItem deleteItem;
		JMenuItem editItem;
		JScrollPane custPane;
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
			
			welcomeMessage = new JLabel("Here Are Our Customers!");
			custModel.addColumn("Customer ID");
			custModel.addColumn("Name");
			custModel.addColumn("Address");
			custModel.addColumn("Age");
			custModel.addColumn("Username");
			custModel.addColumn("Password");
			custModel.addColumn("Email");
			// populate model based on customer
			for(Customer cus : store.customerDAO.customers.values()) {
				custModel.addRow(new Object[] {cus.getID(), cus.getName(), cus.getAddress(), cus.getAge(), cus.getUsername(), cus.getPassword(), cus.getEmail()} );
			}
			
			custTable = new JTable(custModel);
			popupMenu = new JPopupMenu();
			deleteItem = new JMenuItem("Delete");
			editItem = new JMenuItem("Edit");
			deleteItem.addActionListener(this);
			editItem.addActionListener(this);
			custPane = new JScrollPane(custTable);
			custPane.setPreferredSize(new Dimension(500, 250));
			
			popupMenu.add(deleteItem);
			popupMenu.add(editItem);
			
			custTable.setComponentPopupMenu(popupMenu);
			
			panel.setLayout(layout);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			panel.add(welcomeMessage, gbc);
			
			
			
			returnButton.addActionListener(this);
			
			add(panel, BorderLayout.CENTER);
			add(custPane, BorderLayout.SOUTH);
			add(returnButton, BorderLayout.PAGE_END);
			this.setTitle("Display Customers");
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
			}else {
				// ensure a row is selected
				if(custTable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(this, "Please Select a Row in Table First!", "No Selection!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JMenuItem menu = (JMenuItem) e.getSource();
					if (menu == deleteItem) {
					    int selectedRow = custTable.getSelectedRow();
					    this.store.customerDAO.removeCustomer(Integer.parseInt(custModel.getValueAt(selectedRow, 0).toString()));
					    custModel.removeRow(selectedRow);
					    JOptionPane.showMessageDialog(this, "Customer has been Removed!", "Customer Removal", JOptionPane.INFORMATION_MESSAGE);
			        } else if (menu == editItem) {
						int selectedRow = custTable.getSelectedRow();
						System.out.println(selectedRow);
						EditCustForm ed=new EditCustForm(this.store,selectedRow,custModel);
						ed.createAndShowGUI();
						custModel.fireTableDataChanged();
						this.dispose();
			        }
					
				}
				
			}
		}

		     
	

}
