package javaswing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Question20 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Create and set up the main frame
			JFrame frame = new JFrame("JTabbedPane Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 400);
			frame.setLayout(new BorderLayout());

			// Create the tabbed pane
			JTabbedPane tabbedPane = new JTabbedPane();

			// Add tabs to the tabbed pane
			tabbedPane.addTab("Text Area", createTextAreaPanel());
			tabbedPane.addTab("Buttons", createButtonPanel());
			tabbedPane.addTab("Form", createFormPanel());

			// Add the tabbed pane to the frame
			frame.add(tabbedPane, BorderLayout.CENTER);

			// Display the frame
			frame.setVisible(true);
		});
	}

	// Method to create the panel with a text area
	private static JPanel createTextAreaPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("This is the first tab", JLabel.CENTER);
		JTextArea textArea = new JTextArea("Some text in the first tab.");
		textArea.setEditable(false);
		panel.add(label, BorderLayout.NORTH);
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		return panel;
	}

	// Method to create the panel with buttons
	private static JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 1));
		panel.add(new JButton("Button 1"));
		panel.add(new JButton("Button 2"));
		panel.add(new JButton("Button 3"));
		return panel;
	}

	// Method to create the panel with a form
	private static JPanel createFormPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Enter your name:");
		JTextField textField = new JTextField(15);
		JButton submitButton = new JButton("Submit");
		panel.add(label);
		panel.add(textField);
		panel.add(submitButton);
		return panel;
	}
}
