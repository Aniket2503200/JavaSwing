package javaswing;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Question15 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JList Example");
		JPanel panel = new JPanel();

		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("Item 1");
		listModel.addElement("Item 2");
		listModel.addElement("Item 3");

		final JList<String> list = new JList<>(listModel); // Make list final
		final JLabel detailsLabel = new JLabel("Select an item"); // Make detailsLabel final

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					detailsLabel.setText("Selected: " + list.getSelectedValue());
				}
			}
		});

		panel.add(list);
		panel.add(detailsLabel);

		frame.add(panel);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
