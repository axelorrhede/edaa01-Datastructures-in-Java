package textproc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BookReaderController {

	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		// pane är en behållarkomponent till vilken de övriga komponenterna (listvy,
		// knappar etc.) ska läggas till.

		// Sätta in scrollbara listan
		SortedListModel<Map.Entry<String, Integer>> sList = new SortedListModel<Entry<String, Integer>>(
				counter.getWordList());
		JList<Map.Entry<String, Integer>> list = new JList<Entry<String, Integer>>(sList);
		JScrollPane sPane = new JScrollPane(list);
		pane.add(sPane);

		// Lägga till knapparna nedtill
		JPanel jPanel = new JPanel();
		JButton abc = new JButton("Alphabetic");
		list.setSelectionBackground(Color.red);
		abc.addActionListener(event -> {
			sList.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
		});
		jPanel.add(abc);
		JButton fre = new JButton("Frequency");
		fre.addActionListener(event -> {
			sList.sort((e1, e2) -> e2.getValue() - e1.getValue());
		});
		jPanel.add(fre);
		pane.add(jPanel, BorderLayout.SOUTH);

		// Lägga till sökruta
		JPanel jPanel2 = new JPanel();
		JTextField jText = new JTextField();
		jText.setPreferredSize(new Dimension(200, 20));
		JButton sok = new JButton("Find");
		sok.addActionListener(event -> {
			String s = jText.getText().toLowerCase().trim();
			int i = correctIndex(s, sList);
			if (i == -1) {
				JOptionPane.showMessageDialog(null, "Sorry, I was not able to find that word");
			} else {
				list.ensureIndexIsVisible(i);
				list.setSelectedIndex(i);
			}
		});

		// Söka med enter
		/*
		 * jText.addActionListener(new java.awt.event.ActionListener() { // hjälp public
		 * void actionPerformed(ActionEvent e) { String s =
		 * jText.getText().toLowerCase().trim(); int i = correctIndex(s, sList); if (i
		 * == -1) { JOptionPane.showMessageDialog(null,
		 * "Sorry, I was not able to find that word"); } else {
		 * list.ensureIndexIsVisible(i); list.setSelectedIndex(i); } } });
		 */

		jText.addActionListener(event -> {
			sok.doClick();
		});

		jPanel2.add(jText);
		jPanel2.add(sok);
		pane.add(jPanel2, BorderLayout.NORTH);

		frame.pack();
		frame.setVisible(true);

	}

	private int correctIndex(String s, SortedListModel<Map.Entry<String, Integer>> list) {
		for (int i = 0; i < list.getSize(); i++) {
			if (list.getElementAt(i).getKey().equals(s)) {
				return i;
			}
		}
		return -1;
	}
}
