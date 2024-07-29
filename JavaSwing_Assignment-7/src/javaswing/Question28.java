package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Question28 {
	private static final String URL = "jdbc:mysql://localhost:3306/Question28?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "oneplus11R";

	private static Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Database CRUD Example");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		DefaultTableModel model = new DefaultTableModel(new String[] { "ID", "Name", "Position" }, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		JButton loadButton = new JButton("Load Data");
		JButton addButton = new JButton("Add Record");
		JButton updateButton = new JButton("Update Record");
		JButton deleteButton = new JButton("Delete Record");

		// Load data from database
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = connect();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM employees1")) {
					model.setRowCount(0); // Clear existing data
					while (rs.next()) {
						model.addRow(new Object[] { rs.getInt("id"), rs.getString("name"), rs.getString("position") });
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		// Add record
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter name:");
				String position = JOptionPane.showInputDialog("Enter position:");
				try (Connection conn = connect();
						PreparedStatement pstmt = conn
								.prepareStatement("INSERT INTO employees1 (name, position) VALUES (?, ?)")) {
					pstmt.setString(1, name);
					pstmt.setString(2, position);
					pstmt.executeUpdate();
					loadButton.doClick(); // Reload data
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		// Update record
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					int id = (Integer) model.getValueAt(selectedRow, 0);
					String name = JOptionPane.showInputDialog("Enter new name:", model.getValueAt(selectedRow, 1));
					String position = JOptionPane.showInputDialog("Enter new position:",
							model.getValueAt(selectedRow, 2));
					try (Connection conn = connect();
							PreparedStatement pstmt = conn
									.prepareStatement("UPDATE employees1 SET name = ?, position = ? WHERE id = ?")) {
						pstmt.setString(1, name);
						pstmt.setString(2, position);
						pstmt.setInt(3, id);
						pstmt.executeUpdate();
						loadButton.doClick(); // Reload data
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Please select a record to update.");
				}
			}
		});

		// Delete record
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					int id = (Integer) model.getValueAt(selectedRow, 0);
					try (Connection conn = connect();
							PreparedStatement pstmt = conn.prepareStatement("DELETE FROM employees1 WHERE id = ?")) {
						pstmt.setInt(1, id);
						pstmt.executeUpdate();
						loadButton.doClick(); // Reload data
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Please select a record to delete.");
				}
			}
		});

		panel.add(loadButton);
		panel.add(addButton);
		panel.add(updateButton);
		panel.add(deleteButton);
		panel.add(scrollPane);

		frame.add(panel);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
