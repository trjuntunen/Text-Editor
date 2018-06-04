import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class to manage the GUI window.
 * @author tjuntunen
 *
 */
public class Frame {

	/**
	 * All of the components within the main JFrame.
	 */
	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private TextLineNumber lineNumber;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem saveAsItem;
	private JMenuItem saveToDesktopItem;
	private EventManager event;
	private ImageIcon icon;
	
	public Frame() {
		frame = new JFrame("TopEdit");
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		lineNumber = new TextLineNumber(textArea, 0);
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		saveAsItem = new JMenuItem("Size");
		saveToDesktopItem = new JMenuItem();
		event = new EventManager();
		icon = new ImageIcon("D:\\java-oxygen\\text-editor\\Text-Editor\\TextEditor\\images\\toptexticon.png");
	}

	/**
	 * Sets up the style of the frame and its components.
	 */
	public void setup() {
		setupTextArea();
		setupScrollPane();
		setupMenuBar();
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
		frame.setIconImage(icon.getImage());
		frame.setMinimumSize(new Dimension(600, 400));
		frame.pack();
	}

	/**
	 * Sets the text area to have line-wrap.
	 */
	private void setupTextArea() {
		textArea.setBorder(BorderFactory.createCompoundBorder(textArea.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		textArea.setFont(textArea.getFont().deriveFont(14f));
		Font font = new Font("Consolas", Font.PLAIN, 14);
		textArea.setFont(font);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		event.addDocumentListenerToTextArea(textArea);
	}

	/**
	 * Sets up the menu bar for drop down menu options.
	 */
	private void setupMenuBar() {
		/* Create 'save file as' MenuItem. */
		saveAsItem = menu.add("Save file as");
		event.addEventToFileSaveMenuItem(saveAsItem, textArea);
		
		/* Create 'save to desktop' MenuItem */
		saveToDesktopItem = menu.add("Save to desktop");
		event.addEventToSaveToDesktop(saveToDesktopItem, textArea);
		
		/* Add the menu to the menuBar and then add it to the frame. */
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}

}
