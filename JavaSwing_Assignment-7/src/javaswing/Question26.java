package javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Question26 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Create the main frame
			JFrame frame = new JFrame("File Editor");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600, 400);
			frame.setLayout(new BorderLayout());

			// Create the text area and add it to a scroll pane
			JTextArea textArea = new JTextArea();
			JScrollPane scrollPane = new JScrollPane(textArea);
			frame.add(scrollPane, BorderLayout.CENTER);

			// Create the menu bar
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);

			// Create the File menu
			JMenu fileMenu = new JMenu("File");
			menuBar.add(fileMenu);

			// Create menu items
			JMenuItem openItem = new JMenuItem("Open");
			JMenuItem saveItem = new JMenuItem("Save");
			JMenuItem exitItem = new JMenuItem("Exit");

			fileMenu.add(openItem);
			fileMenu.add(saveItem);
			fileMenu.addSeparator();
			fileMenu.add(exitItem);

			// Action listener for Open menu item
			openItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					int returnValue = fileChooser.showOpenDialog(frame);
					if (returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						try (FileReader reader = new FileReader(selectedFile)) {
							textArea.read(reader, null);
						} catch (IOException ioException) {
							JOptionPane.showMessageDialog(frame, "Error opening file: " + ioException.getMessage(),
									"File Error", JOptionPane.ERROR_MESSAGE);
						}
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
						try (FileWriter writer = new FileWriter(selectedFile)) {
							textArea.write(writer);
						} catch (IOException ioException) {
							JOptionPane.showMessageDialog(frame, "Error saving file: " + ioException.getMessage(),
									"File Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

			// Action listener for Exit menu item
			exitItem.addActionListener(e -> frame.dispose());

			// Display the frame
			frame.setVisible(true);
		});
	}
}
