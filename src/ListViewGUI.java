import javax.swing.JFrame;
import javax.swing.JScrollBar;

import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ListViewGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ListViewGUI(CollectionSiteList CSL){
		setTitle("List View");
		setVisible(true);
		setBounds(200, 200, 400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea txtArea = new JTextArea();
		txtArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtArea);
		getContentPane().add(scrollPane);
		
		JScrollBar scroll = new JScrollBar();
		scrollPane.add(scroll);
		
		CSL.sort();
		txtArea.setText(CSL.toString());
		
	}
	
}
