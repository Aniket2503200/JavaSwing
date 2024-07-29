package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Question27 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Simple Text Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		// Create the text area and add it to a scroll pane
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		// Create the menu bar
		JMenuBar menuBar = new JMenuBar();

		// Create "File" menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		// Create "Edit" menu
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);

		// Add "Cut", "Copy", and "Paste" items to the Edit menu
		JMenuItem cutMenuItem = new JMenuItem("Cut");
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);

		// Add "Search" item to the Edit menu
		JMenuItem searchMenuItem = new JMenuItem("Search");
		editMenu.add(searchMenuItem);

		// Set up cut, copy, and paste actions
		cutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});

		copyMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});

		pasteMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});

		// Set up search action
		searchMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchTerm = JOptionPane.showInputDialog(frame, "Enter text to search:");
				if (searchTerm != null && !searchTerm.isEmpty()) {
					String text = textArea.getText();
					int index = text.indexOf(searchTerm);
					if (index != -1) {
						textArea.select(index, index + searchTerm.length());
						textArea.requestFocus();
					} else {
						JOptionPane.showMessageDialog(frame, "Text not found.", "Search",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		// Add the scroll pane to the frame
		frame.setJMenuBar(menuBar);
		frame.add(scrollPane);

		frame.setVisible(true);
	}
}
