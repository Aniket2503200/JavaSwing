package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Question14 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("ComboBox Example");
		JPanel panel = new JPanel();

		String[] items = { "Item 1", "Item 2", "Item 3" };
		final JComboBox<String> comboBox = new JComboBox<>(items); // Make comboBox final
		final JTextArea textArea = new JTextArea(5, 20); // Make textArea final
		textArea.setEditable(false);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText((String) comboBox.getSelectedItem());
			}
		});

		panel.add(comboBox);
		panel.add(textArea);

		frame.add(panel);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
