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
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Employee;
import dao.PetClinic;

public class DisplayEmpForm extends Form implements ActionListener{

	PetClinic pc;
	DisplayEmpForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	// declare JSwing components
		JPanel panel = new JPanel(new GridBagLayout());
		DefaultTableModel empModel = new DefaultTableModel(){
		    Class[] types = new Class [] {
		            //COL. TYPES ARE HERE!!!
		            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
		            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
		        };
		         
		        @Override
		        public Class getColumnClass(int columnIndex) {
		            return types [columnIndex];
		        }
		    };;
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JTable empTable;
		JPopupMenu popupMenu;
		JMenuItem deleteItem;
		JMenuItem editItem;
		JScrollPane empPane;
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
			
			welcomeMessage = new JLabel("Here Are Our Employees!");
			empModel.addColumn("Employee ID");
			empModel.addColumn("Name");
			empModel.addColumn("Address");
			empModel.addColumn("Age");
			empModel.addColumn("Username");
			empModel.addColumn("Password");
			empModel.addColumn("Email");
			empModel.addColumn("Is Manager");
			
			// populate model based on the employees size
			for (Employee emp : store.employeeDAO.employees.values()) {
				empModel.addRow(new Object[] {emp.getID(),emp.getName(), emp.getAddress(), emp.getAge(), emp.getUsername(), emp.getPassword(), emp.getEmail(), emp.isManager()} );
			}
			
			empTable = new JTable(empModel);
			popupMenu = new JPopupMenu();
			deleteItem = new JMenuItem("Delete");
			editItem = new JMenuItem("Edit");
			deleteItem.addActionListener(this);
			editItem.addActionListener(this);
			empPane = new JScrollPane(empTable);
			empPane.setPreferredSize(new Dimension(500, 250));
			
			popupMenu.add(deleteItem);
			popupMenu.add(editItem);
			
			empTable.setComponentPopupMenu(popupMenu);
			
			panel.setLayout(layout);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			panel.add(welcomeMessage, gbc);
			
			
			
			returnButton.addActionListener(this);
			
			add(panel, BorderLayout.CENTER);
			add(empPane, BorderLayout.SOUTH);
			add(returnButton, BorderLayout.PAGE_END);
			this.setTitle("Display Employees");
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
				JMenuItem menu = (JMenuItem) e.getSource();
				if (menu == deleteItem) {
				    int selectedRow = empTable.getSelectedRow();
				    empModel.removeRow(selectedRow);
				    this.store.employeeDAO.removeEmployee(Integer.parseInt(empModel.getValueAt(selectedRow, 0).toString()));
		        } else if (menu == editItem) {
					int selectedRow = empTable.getSelectedRow();
					System.out.println(selectedRow);
					EditEmpForm ed= new EditEmpForm(this.store,selectedRow,empModel);
					ed.createAndShowGUI();
					empModel.fireTableDataChanged();
					this.dispose();
		        }
				
			}
		}
			
	

}
