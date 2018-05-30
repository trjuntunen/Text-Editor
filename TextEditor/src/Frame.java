import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Class to manage the GUI window.
 * @author tjuntunen
 *
 */
public class Frame {

	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	private TextLineNumber lineNumber;
	
	public Frame() {
		frame = new JFrame();
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		textPane = new JTextPane();
		lineNumber = new TextLineNumber(textPane);
	}
	
	/**
	 * Sets up the style of the frame and its components.
	 */
	public void setup() {
		setTextAreaLineWrap();
		scrollPane.setRowHeaderView(lineNumber);
		setupFrame();
	}
	
	/**
	 * Packs the frame and shows it.
	 */
	public void show() {
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Sets the text area to have line-wrap.
	 */
	private void setTextAreaLineWrap() {
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
	}
	
	/**
	 * Sets up the frame by adding components and adjusting size limits.
	 */
	private void setupFrame() {
		frame.add(scrollPane);
		frame.setMinimumSize(new Dimension(600, 400));
	}
	
}
