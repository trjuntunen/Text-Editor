import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Driver {

	public static void main(String[] args) {

		/* Initialize the components necessary. */
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		/* Set the line wrap style of the text area. */
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		/* Add the scroll pane containing the text area to the frame
           and set the minimum frame size. */
		frame.add(scrollPane);
		frame.setMinimumSize(new Dimension(500, 500));

		/* Pack the components within the frame and show the frame. */
		frame.pack();
		frame.setVisible(true);

	}

}