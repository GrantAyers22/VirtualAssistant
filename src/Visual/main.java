// Package
package Visual;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
// imports
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;


// Main class
public class main {
		
	// Main function
	public static void main(String[] args) {

		LittleGuy();
	
    } 
	public static void LittleGuy() {
		Movement m = new Movement(0, 0);
	}
	public static void List() {
		JFrame frame = new JFrame();
		frame.setSize(75, 165);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		// Create the list model
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		// adding elements
		listModel.addElement("Wander");
		listModel.addElement("Stay");
		listModel.addElement("Read Email");
		listModel.addElement("Be Cheeky");
		

		// creating list from list model
		JList<String> list = new JList<String>(listModel);
		
		// setting single selection
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel panel = new JPanel();
		panel.add(list);
		
		// Creating a button
		JButton enter = new JButton("ENTER");
		enter.setSize(50, 20);

		// Creating a button
		JButton close = new JButton("CLOSE");
		enter.setSize(50, 20);
		
		JPanel buttonpannel = new JPanel();
		buttonpannel.add(enter);
		buttonpannel.add(close);
		
		// adding the frame to the list and setting it visible
		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(boxLayout);
		frame.add(panel);
		frame.add(buttonpannel);
		frame.setVisible(true);
	}

}
