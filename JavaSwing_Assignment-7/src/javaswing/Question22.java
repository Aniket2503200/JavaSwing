package javaswing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Question22 {

	private static JButton startButton; // Store the reference to the button

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Create the main frame
			JFrame frame = new JFrame("JProgressBar Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 200);
			frame.setLayout(new BorderLayout());

			// Create a progress bar
			JProgressBar progressBar = new JProgressBar(0, 100);
			progressBar.setValue(0);
			progressBar.setStringPainted(true); // Show progress percentage
			progressBar.setBorder(BorderFactory.createTitledBorder("Task Progress"));

			// Create a button to start the task
			startButton = new JButton("Start Task");
			startButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					startButton.setEnabled(false); // Disable the button during the task
					new TaskThread(progressBar).start(); // Start the long-running task
				}
			});

			// Add components to the frame
			frame.add(progressBar, BorderLayout.CENTER);
			frame.add(startButton, BorderLayout.SOUTH);

			// Display the frame
			frame.setVisible(true);
		});
	}

	// Inner class for the task thread
	static class TaskThread extends Thread {
		private final JProgressBar progressBar;

		public TaskThread(JProgressBar progressBar) {
			this.progressBar = progressBar;
		}

		@Override
		public void run() {
			int progress = 0;
			while (progress <= 100) {
				try {
					Thread.sleep(100); // Simulate long-running task
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				final int currentProgress = progress; // Capture the current progress for use in SwingUtilities
				SwingUtilities.invokeLater(() -> progressBar.setValue(currentProgress));
				progress += 1; // Update progress
			}

			// Enable the button again after task completion
			SwingUtilities.invokeLater(() -> startButton.setEnabled(true));
		}
	}
}
