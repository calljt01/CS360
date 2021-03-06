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
	private JTextArea txtArea;
	private CollectionSiteList CSL;

	
	public ListViewGUI(CollectionSiteList CSL){
		this.CSL = CSL;
		
		setTitle("List View");
		setBounds(200, 200, 400, 400);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtArea);
		getContentPane().add(scrollPane);
		
		JScrollBar scroll = new JScrollBar();
		scrollPane.add(scroll);
		
		CSL.sort();
		txtArea.setText(CSL.toString());
		
	}
	
	public void repaint(){
		CSL.sort();
		txtArea.setText(CSL.toString());
	}
	
}
