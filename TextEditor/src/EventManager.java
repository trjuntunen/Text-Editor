import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Segment;

/**
 * Class to manage all the event listeners for every button within the program.
 * @author Teddy Juntunen
 *
 */
public class EventManager {

	/**
	 * Adds the action listener to the "save file" menu item from
	 * the MenuBar drop down menu.
	 * @param saveItem
	 * The MenuItem in which to add an action listener to.
	 * @param textArea
	 * The text area whose text is to be saved to a file when the MenuItem is clicked.
	 */
	public void addEventToFileSaveMenuItem(JMenuItem saveItem, JTextArea textArea) {

		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = JOptionPane.showInputDialog("Enter the location to save the file.");

				if(path != null) {
					String currentText = textArea.getText();
					try(FileWriter writer = new FileWriter(new File(path))) {
						writer.write(currentText);
						JOptionPane.showMessageDialog(textArea, "File saved to " + path);
					} catch (IOException event) {
						event.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Adds the action listener to the "save to desktop" menu item from the MenuBar
	 * drop down menu.
	 * @param saveToDesktopItem
	 * Menu Item button from the MenuBar drop down menu.
	 * @param textArea
	 * The text area whose text is to be saved to a file when the MenuItem is clicked.
	 */
	public void addEventToSaveToDesktop(JMenuItem saveToDesktopItem, JTextArea textArea) {
		saveToDesktopItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "C:\\Users\\epbba\\Desktop\\Driver.java";

				if(path != null) {
					String currentText = textArea.getText();
					try(FileWriter writer = new FileWriter(new File(path))) {
						writer.write(currentText);
						JOptionPane.showMessageDialog(textArea, "File saved to " + path);
					} catch (IOException event) {
						event.printStackTrace();
					}
				}
			}
		});
	}

	/**
	 * Function that adds a document listener to the text area
	 * for auto complete functionality with brackets.
	 * @param textArea
	 * The text area to add the document listener to.
	 */
	public void addDocumentListenerToTextArea(JTextArea textArea) {
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				Runnable curlyBracketAutoComplete = new Runnable() {
					@Override
					public void run() {
						Document doc = textArea.getDocument();
						try {
							String lastCharAsString = doc.getText(doc.getLength() - 1, 1);
							if(lastCharAsString.equals("{")) {
								textArea.append("\n\n" + "}");
								textArea.setCaretPosition(textArea.getDocument().getLength());
							}
						} catch (BadLocationException e) {
							e.printStackTrace();
						}
					}
				};
				SwingUtilities.invokeLater(curlyBracketAutoComplete);
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {}

		});

	}

}