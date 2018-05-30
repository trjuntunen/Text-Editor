import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Driver {

	public static void main(String[] args) {

		/* Initialize the necessary components. */
		JFrame frame = new JFrame();
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		/* Set the line wrap style of the text area. */
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
//		textArea.setBorder(BorderFactory.createCompoundBorder(
//				textArea.getBorder(), 
//		        BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// i wanna set the color of the side panel to clear with just the line numbers.
		// how tf do you see the numbers. use the font changing func? 
		
		/* Add the scroll pane containing the text area to the frame
        and set the minimum frame size. */
		frame.add(scrollPane);
		frame.setMinimumSize(new Dimension(500, 500));
		
		JTextPane textPane = new JTextPane();
		TextLineNumber tln = new TextLineNumber(textPane);
		scrollPane.setRowHeaderView(tln);
		
		/* Pack the components within the frame and show the frame. */
		frame.pack();
		frame.setVisible(true);

	}

}