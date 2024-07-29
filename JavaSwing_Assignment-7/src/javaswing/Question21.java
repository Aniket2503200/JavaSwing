package javaswing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Question21 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Create the main frame
			JFrame frame = new JFrame("JSplitPane Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 600);

			// Create components for the left panel
			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new BorderLayout());
			JTextArea textArea = new JTextArea();
			textArea.setText("This is the left panel.\nYou can resize this pane.");
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			leftPanel.add(textArea, BorderLayout.CENTER);

			// Create components for the right panel
			JPanel rightPanel = new JPanel();
			rightPanel.setLayout(new FlowLayout());
			JTextField textField = new JTextField("This is the right panel.", 20);
			JButton button = new JButton("Click Me");
			rightPanel.add(textField);
			rightPanel.add(button);

			// Add an ActionListener to the button
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					textField.setText("Button Clicked!");
				}
			});

			// Create the split pane
			JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
			splitPane.setDividerLocation(400); // Set initial position of the divider
			splitPane.setResizeWeight(0.5); // Set resize weight to equally distribute space

			// Add the split pane to the frame
			frame.add(splitPane, BorderLayout.CENTER);

			// Display the frame
			frame.setVisible(true);
		});
	}
}
