import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Driver {
	
	public static void main(String[] args) {
		
		// Initialize the components necessary.
        JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea();
        
        // Set the style and size of the text area.
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(500, 500));
        
        // Add the text area to the frame.
        frame.add(textArea);
        
        // Set the size of the frame.
        frame.setPreferredSize(new Dimension(500, 500));
        
        // Pack the components within the frame and show the frame.
        frame.pack();
        frame.setVisible(true);
		
	}
	
}