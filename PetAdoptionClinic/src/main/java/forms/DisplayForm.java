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

import dao.PetClinic;

public class DisplayForm extends Form implements ActionListener {
	
	DisplayForm(PetClinic pc) {
		super(pc);
		// TODO Auto-generated constructor stub
	}

	// declare JSwing components
	JPanel panel = new JPanel(new GridBagLayout());
	DefaultTableModel petModel = new DefaultTableModel();
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JTable petTable;
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
		petModel.addColumn("Name");
		petModel.addColumn("Age");
		petModel.addColumn("Birthday");
		petModel.addColumn("Color");
		petModel.addColumn("Weight");
		petModel.addRow(new Object[] {"Boo-Boo","1 (Integer Please)", "2020.6.20", "Gold", "11 (lb Please)"} );
		
		petTable = new JTable(petModel);
		petPane = new JScrollPane(petTable);
		petPane.setPreferredSize(new Dimension(500, 250));
		
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
            this.dispose();
	}
	}

}
