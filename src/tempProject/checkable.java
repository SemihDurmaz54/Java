package tempProject;

import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class checkable {

	public static void main(final String args[]) {
		JFrame frame = new JFrame("MenuSample Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
		fileMenu.add(newMenuItem);

		JMenu findOptionsMenu = new JMenu("Options");
		Icon atIcon = new ImageIcon("at.gif");
		findOptionsMenu.setIcon(atIcon);
		findOptionsMenu.setMnemonic(KeyEvent.VK_O);
		fileMenu.add(findOptionsMenu);

		ButtonGroup directionGroup = new ButtonGroup();

		JRadioButtonMenuItem forwardMenuItem = new JRadioButtonMenuItem("Forward", true);
		forwardMenuItem.setMnemonic(KeyEvent.VK_F);
		findOptionsMenu.add(forwardMenuItem);
		directionGroup.add(forwardMenuItem);

		JRadioButtonMenuItem backwardMenuItem = new JRadioButtonMenuItem("Backward");
		backwardMenuItem.setMnemonic(KeyEvent.VK_B);
		findOptionsMenu.add(backwardMenuItem);
		directionGroup.add(backwardMenuItem);

		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}