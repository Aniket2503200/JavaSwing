package javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Question18 {

	private static JFrame frame; // Declare JFrame as a static field

	public static void main(String[] args) {
		// Initialize the frame
		frame = new JFrame("Swing MenuBar Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLayout(new BorderLayout());

		// Create the menu bar
		JMenuBar menuBar = new JMenuBar();

		// Create the File menu
		JMenu fileMenu = new JMenu("File");

		// Create menu items
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");

		// Add menu items to the File menu
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator(); // Add a separator
		fileMenu.add(exitItem);

		// Add the File menu to the menu bar
		menuBar.add(fileMenu);

		// Set the menu bar on the frame
		frame.setJMenuBar(menuBar);

		// Action listener for Open menu item
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(frame);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					JOptionPane.showMessageDialog(frame, "Opened file: " + selectedFile.getAbsolutePath());
				}
			}
		});

		// Action listener for Save menu item
		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showSaveDialog(frame);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					JOptionPane.showMessageDialog(frame, "Saved file: " + selectedFile.getAbsolutePath());
				}
			}
		});

		// Action listener for Exit menu item
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		// Display the frame
		frame.setVisible(true);
	}
}
