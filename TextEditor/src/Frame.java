import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class to manage the GUI window.
 * @author tjuntunen
 *
 */
public class Frame {

	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private TextLineNumber lineNumber;

	public Frame() {
		frame = new JFrame();
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		lineNumber = new TextLineNumber(textArea, 0);
	}

	/**
	 * Sets up the style of the frame and its components.
	 */
	public void setup() {
		setupTextArea();
		setupScrollPane();
		setupFrame();
	}

	/**
	 * Displays the frame.
	 */
	public void show() {
		frame.setVisible(true);
	}

	/**
	 * Sets up the scroll pane with the line numbers.
	 */
	private void setupScrollPane() {
		scrollPane.setRowHeaderView(lineNumber);
	}

	/**
	 * Sets up the frame functionality and style.
	 */
	private void setupFrame() {
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(scrollPane);
		frame.setMinimumSize(new Dimension(600, 400));
		frame.pack();
	}

	/**
	 * Sets the text area to have line-wrap.
	 */
	private void setupTextArea() {
		textArea.setBorder(BorderFactory.createCompoundBorder(textArea.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
	}

}
