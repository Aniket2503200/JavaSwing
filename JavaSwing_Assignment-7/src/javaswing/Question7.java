package javaswing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Question7 {
	public static void main(String[] args) {
		// Create the main frame
		JFrame frame = new JFrame("Layout Managers Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		frame.setLayout(new GridLayout(4, 1)); // GridLayout to show all examples in one window

		// BorderLayout Example
		JPanel borderLayoutPanel = new JPanel(new BorderLayout());
		borderLayoutPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
		borderLayoutPanel.add(new JButton("North"), BorderLayout.NORTH);
		borderLayoutPanel.add(new JButton("South"), BorderLayout.SOUTH);
		borderLayoutPanel.add(new JButton("East"), BorderLayout.EAST);
		borderLayoutPanel.add(new JButton("West"), BorderLayout.WEST);
		borderLayoutPanel.add(new JButton("Center"), BorderLayout.CENTER);

		// FlowLayout Example
		JPanel flowLayoutPanel = new JPanel(new FlowLayout());
		flowLayoutPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
		flowLayoutPanel.add(new JButton("Button 1"));
		flowLayoutPanel.add(new JButton("Button 2"));
		flowLayoutPanel.add(new JButton("Button 3"));
		flowLayoutPanel.add(new JButton("Button 4"));
		flowLayoutPanel.add(new JButton("Button 5"));

		// GridLayout Example
		JPanel gridLayoutPanel = new JPanel(new GridLayout(2, 3));
		gridLayoutPanel.setBorder(BorderFactory.createTitledBorder("GridLayout"));
		gridLayoutPanel.add(new JButton("Button 1"));
		gridLayoutPanel.add(new JButton("Button 2"));
		gridLayoutPanel.add(new JButton("Button 3"));
		gridLayoutPanel.add(new JButton("Button 4"));
		gridLayoutPanel.add(new JButton("Button 5"));
		gridLayoutPanel.add(new JButton("Button 6"));

		// BoxLayout Example
		JPanel boxLayoutPanel = new JPanel();
		boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
		boxLayoutPanel.setBorder(BorderFactory.createTitledBorder("BoxLayout"));
		boxLayoutPanel.add(new JButton("Button 1"));
		boxLayoutPanel.add(new JButton("Button 2"));
		boxLayoutPanel.add(new JButton("Button 3"));
		boxLayoutPanel.add(new JButton("Button 4"));
		boxLayoutPanel.add(new JButton("Button 5"));

		// Add all layout panels to the main frame
		frame.add(borderLayoutPanel);
		frame.add(flowLayoutPanel);
		frame.add(gridLayoutPanel);
		frame.add(boxLayoutPanel);

		// Make the frame visible
		frame.setVisible(true);
	}
}
