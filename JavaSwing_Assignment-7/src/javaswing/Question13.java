package javaswing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Question13 {
	public static void main(String[] args) {
		// Create the frame
		JFrame frame = new JFrame("Simple Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);
		frame.setLayout(new BorderLayout());

		// Create the display panel and text field
		JPanel displayPanel = new JPanel();
		final JTextField display = new JTextField();
		display.setEditable(false);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setPreferredSize(new Dimension(250, 50));
		displayPanel.add(display);

		// Create the button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5x4 grid with gaps

		// Create buttons
		JButton[] numberButtons = new JButton[10];
		JButton addButton = new JButton("+");
		JButton subButton = new JButton("-");
		JButton mulButton = new JButton("*");
		JButton divButton = new JButton("/");
		JButton eqButton = new JButton("=");
		JButton clrButton = new JButton("C");

		// Initialize number buttons
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(new NumberButtonListener(display));
		}

		// Add buttons to panel
		for (JButton button : numberButtons) {
			buttonPanel.add(button);
		}

		buttonPanel.add(addButton);
		buttonPanel.add(subButton);
		buttonPanel.add(mulButton);
		buttonPanel.add(divButton);
		buttonPanel.add(clrButton);
		buttonPanel.add(new JButton()); // Empty button for layout
		buttonPanel.add(new JButton()); // Empty button for layout
		buttonPanel.add(eqButton);

		// Add panels to frame
		frame.add(displayPanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);

		// Display the frame
		frame.setVisible(true);

		// Action listeners for operators and actions
		addButton.addActionListener(new OperatorAction(display, "+"));
		subButton.addActionListener(new OperatorAction(display, "-"));
		mulButton.addActionListener(new OperatorAction(display, "*"));
		divButton.addActionListener(new OperatorAction(display, "/"));

		eqButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String result = String.valueOf(eval(display.getText()));
					display.setText(result);
				} catch (Exception ex) {
					display.setText("Error");
				}
			}
		});

		clrButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText("");
			}
		});
	}

	// Simple method to evaluate the expression
	private static double eval(String expression) {
		String[] tokens = expression.split(" ");
		if (tokens.length != 3) {
			throw new IllegalArgumentException("Invalid expression");
		}
		double num1 = Double.parseDouble(tokens[0]);
		double num2 = Double.parseDouble(tokens[2]);
		switch (tokens[1]) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			throw new IllegalArgumentException("Invalid operator");
		}
	}
}

// Helper class to handle number button clicks
class NumberButtonListener implements ActionListener {
	private final JTextField display;

	public NumberButtonListener(JTextField display) {
		this.display = display;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		display.setText(display.getText() + source.getText());
	}
}

// Helper class to handle operator button clicks
class OperatorAction implements ActionListener {
	private final JTextField display;
	private final String operator;

	public OperatorAction(JTextField display, String operator) {
		this.display = display;
		this.operator = operator;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		display.setText(display.getText() + " " + operator + " ");
	}
}
