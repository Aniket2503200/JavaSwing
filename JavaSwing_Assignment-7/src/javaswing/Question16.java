package javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Question16 {
	public static void main(String[] args) {
		// Create the frame
		final JFrame frame = new JFrame("JTable Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLayout(new BorderLayout());

		// Create the table model with columns and initial data
		final DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "ID", "Name", "Age" }, 0);
		final JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		// Create buttons
		JButton addButton = new JButton("Add");
		JButton updateButton = new JButton("Update");
		JButton deleteButton = new JButton("Delete");

		// Create panel for buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);

		// Add components to the frame
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		// Action listener for add button
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(frame, "Enter ID:");
				String name = JOptionPane.showInputDialog(frame, "Enter Name:");
				String age = JOptionPane.showInputDialog(frame, "Enter Age:");

				if (id != null && name != null && age != null) {
					tableModel.addRow(new Object[] { id, name, age });
				}
			}
		});

		// Action listener for update button
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String id = JOptionPane.showInputDialog(frame, "Enter new ID:",
							tableModel.getValueAt(selectedRow, 0));
					String name = JOptionPane.showInputDialog(frame, "Enter new Name:",
							tableModel.getValueAt(selectedRow, 1));
					String age = JOptionPane.showInputDialog(frame, "Enter new Age:",
							tableModel.getValueAt(selectedRow, 2));

					if (id != null && name != null && age != null) {
						tableModel.setValueAt(id, selectedRow, 0);
						tableModel.setValueAt(name, selectedRow, 1);
						tableModel.setValueAt(age, selectedRow, 2);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No row selected for update.");
				}
			}
		});

		// Action listener for delete button
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					tableModel.removeRow(selectedRow);
				} else {
					JOptionPane.showMessageDialog(frame, "No row selected for deletion.");
				}
			}
		});

		// Display the frame
		frame.setVisible(true);
	}
}
