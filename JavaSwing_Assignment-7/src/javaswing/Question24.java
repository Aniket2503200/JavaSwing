package javaswing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Question24 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				// Create the main frame
				JFrame frame = new JFrame("Look and Feel Example");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(400, 200);
				frame.setLayout(new BorderLayout());

				// Create a panel for buttons
				JPanel panel = new JPanel(new GridLayout(4, 1));

				// Create buttons for different look and feels
				JButton metalButton = new JButton("Metal Look and Feel");
				JButton nimbusButton = new JButton("Nimbus Look and Feel");
				JButton windowsButton = new JButton("Windows Look and Feel");
				JButton motifButton = new JButton("Motif Look and Feel");

				// Add action listeners to buttons
				metalButton.addActionListener(
						e -> setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName(), frame));
				nimbusButton.addActionListener(e -> setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel", frame));
				windowsButton.addActionListener(
						e -> setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", frame));
				motifButton.addActionListener(
						e -> setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel", frame));

				// Add buttons to panel
				panel.add(metalButton);
				panel.add(nimbusButton);
				panel.add(windowsButton);
				panel.add(motifButton);

				// Create a label
				JLabel label = new JLabel("Click a button to change the look and feel.", JLabel.CENTER);

				// Add components to the frame
				frame.add(label, BorderLayout.CENTER);
				frame.add(panel, BorderLayout.SOUTH);

				// Display the frame
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Method to set the look and feel
	private static void setLookAndFeel(String lookAndFeel, JFrame frame) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
			// Update all Swing components to use the new look and feel
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
