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

import classes.Pet;
import classes.Reciept;
import dao.PetClinic;

public class DisplayRecieptForm extends Form implements ActionListener {

	// Declare JSwing components
	JPanel panel = new JPanel(new GridBagLayout());
	DefaultTableModel recieptModel = new DefaultTableModel();
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JTable recieptTable;
	JScrollPane recieptPane;
	ImageIcon img;
	JButton returnButton = new JButton("Return");
	JButton viewButton = new JButton("View Reciept");

	// JText and JLabels
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

		welcomeMessage = new JLabel("Reciept Inventory");

		recieptModel.addColumn("Recipt ID");
		recieptModel.addColumn("Pet Id");
		recieptModel.addColumn("Pet Name");
		recieptModel.addColumn("Customer Id");
		recieptModel.addColumn("Customer Name");
		recieptModel.addColumn("Employee ID");
		recieptModel.addColumn("Employee Name");
		recieptModel.addColumn("Adoption Date");

		for (Reciept r : store.reciepts) {
			if(r.getSale().getCustomer() != null) {
				recieptModel.addRow(new Object[] { r.getID(), r.getSale().getPetID(), r.getSale().getPetName(),
						r.getSale().getCustomer().getID(), r.getSale().getCustomer().getName(),
						r.getSale().getEmployee().getID(), r.getSale().getEmployee().getName(),
						r.getSale().getDateAdopted() });	
			}
			else {
				recieptModel.addRow(new Object[] { r.getID(), r.getSale().getPetID(), r.getSale().getPetName(),
						"N\\A", "Guest",
						r.getSale().getEmployee().getID(), r.getSale().getEmployee().getName(),
						r.getSale().getDateAdopted() });	
			}
		}

		recieptTable = new JTable(recieptModel);
		recieptPane = new JScrollPane(recieptTable);
		recieptPane.setPreferredSize(new Dimension(500, 250));

		panel.setLayout(layout);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(welcomeMessage, gbc);

		returnButton.addActionListener(this);
		viewButton.addActionListener(this);

		add(panel, BorderLayout.CENTER);
		add(recieptPane, BorderLayout.SOUTH);
		add(returnButton, BorderLayout.PAGE_END);
		add(viewButton, BorderLayout.PAGE_END);
		this.setTitle("Display Reciepts!");
		setSize(510, 500);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	DisplayRecieptForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(returnButton)) {
			HomePage form = new HomePage(this.store);
			form.createAndShowGUI();
			this.dispose();
		} else {
			if (recieptTable.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Please Select a Row in Table First!", "No Selection!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (e.getSource().equals(viewButton)) {
					int selectedRow = recieptTable.getSelectedRow();
					RecieptForm form = new RecieptForm(this.store,selectedRow, recieptModel);
					form.createAndShowGUI();
					this.dispose();
				}

			}

		}

	}
}
