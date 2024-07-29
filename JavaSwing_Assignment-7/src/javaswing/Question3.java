package javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question3 {
	public static void main(String[] args) {
		// Create the frame
		JFrame frame = new JFrame("MVC Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		// Create the model
		final DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("Item 1");
		listModel.addElement("Item 2");

		// Create the view
		JList<String> listView = new JList<String>(listModel);
		JScrollPane scrollPane = new JScrollPane(listView);

		// Create the controller
		JPanel panel = new JPanel(new BorderLayout());
		final JTextField textField = new JTextField();
		JButton addButton = new JButton("Add");

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newItem = textField.getText();
				if (!newItem.isEmpty()) {
					listModel.addElement(newItem);
					textField.setText("");
				}
			}
		});

		// Add components to the panel
		panel.add(textField, BorderLayout.CENTER);
		panel.add(addButton, BorderLayout.EAST);

		// Add components to the frame
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}
}
