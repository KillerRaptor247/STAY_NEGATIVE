package forms;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.plaf.metal.OceanTheme;

import dao.PetClinic;

abstract class Form extends JFrame {
	
	protected PetClinic store;
	
	
	
	Form(PetClinic pc){
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        ImageIcon img = new ImageIcon("dog-32-32.png");
        this.setIconImage(img.getImage());
		store = pc;
	}
}
