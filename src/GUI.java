import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtSiteNumber;
	private JTextField txtLocation;
	private JTextField txtLatitude;
	private JTextField txtLongitude;
	private JComboBox<String> cmboMonth;
	private JComboBox<String> cmboDay;
	private JComboBox<Integer> cmboYear;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnEdit;
	private JMenuItem mntmUpload;
	private JMenuItem mntmView;
	private JMenuItem mntmExit;
	private CollectionSiteList CSL = new CollectionSiteList();


	public static void main(String[] args){
		loginGUI window = new loginGUI();
	}
	
	
	public GUI(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Collection Site Manager");
		setBounds(200, 300, 400, 400);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel numberPanel = new JPanel();
		getContentPane().add(numberPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Site Number:");
		numberPanel.add(lblNewLabel_1);
		
		txtSiteNumber = new JTextField();
		numberPanel.add(txtSiteNumber);
		txtSiteNumber.setColumns(10);
		
		JPanel midPanel = new JPanel();
		getContentPane().add(midPanel);
		midPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel namePanel = new JPanel();
		midPanel.add(namePanel);
		
		JLabel lblNewLabel = new JLabel("Name:");
		namePanel.add(lblNewLabel);
		
		txtName = new JTextField();
		namePanel.add(txtName);
		txtName.setColumns(10);
		
		JPanel locationPanel = new JPanel();
		midPanel.add(locationPanel);
		
		JLabel lblLocation = new JLabel("Location:");
		locationPanel.add(lblLocation);
		
		txtLocation = new JTextField();
		locationPanel.add(txtLocation);
		txtLocation.setColumns(10);
		
		JPanel coordinatesPanel = new JPanel();
		getContentPane().add(coordinatesPanel);
		coordinatesPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel latitudePanel = new JPanel();
		coordinatesPanel.add(latitudePanel);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		latitudePanel.add(lblLatitude);
		
		txtLatitude = new JTextField();
		latitudePanel.add(txtLatitude);
		txtLatitude.setColumns(10);
		
		JPanel longitudePanel = new JPanel();
		coordinatesPanel.add(longitudePanel);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		longitudePanel.add(lblLongitude);
		
		txtLongitude = new JTextField();
		longitudePanel.add(txtLongitude);
		txtLongitude.setColumns(10);
		
		JPanel DateAccessedPanel = new JPanel();
		getContentPane().add(DateAccessedPanel);
		DateAccessedPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel bannerPanel = new JPanel();
		DateAccessedPanel.add(bannerPanel, BorderLayout.NORTH);
		
		JLabel lblDateLastAccessed = new JLabel("Date Last Accessed:");
		bannerPanel.add(lblDateLastAccessed);
		
		JPanel datePanel = new JPanel();
		DateAccessedPanel.add(datePanel, BorderLayout.CENTER);
		
		JLabel lblMonth = new JLabel("Month:");
		datePanel.add(lblMonth);
		
		cmboMonth = new JComboBox<String>();
		for (int i=1; i<=12; i++){
			cmboMonth.addItem(String.format("%02d",i));
		}
		cmboMonth.setSelectedIndex(-1);
		datePanel.add(cmboMonth);
		
		JLabel lblDay = new JLabel("Day:");
		datePanel.add(lblDay);
		
		cmboDay = new JComboBox<String>();
		for (int i=1; i<=31; i++){
			cmboDay.addItem(String.format("%02d",i));
		}
		cmboDay.setSelectedIndex(-1);
		datePanel.add(cmboDay);
		
		JLabel lblYear = new JLabel("Year:");
		datePanel.add(lblYear);
		
		cmboYear = new JComboBox<Integer>();
		for (int i=1914; i<=2018; i++){
			cmboYear.addItem(i);
		}
		cmboYear.setSelectedIndex(-1);
		datePanel.add(cmboYear);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new EventHandler());
		buttonPanel.add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new EventHandler());
		buttonPanel.add(btnRemove);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new EventHandler());
		buttonPanel.add(btnEdit);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		mntmUpload = new JMenuItem("Upload");
		mntmUpload.setMnemonic('U');
		mntmUpload.setToolTipText("Upload an existing list of Collection Sites from a file.");
		mntmUpload.addActionListener(new EventHandler());
		mnFile.add(mntmUpload);
		
		mntmView = new JMenuItem("View");
		mntmView.setMnemonic('V');
		mntmView.setToolTipText("View complete list of Colletion Sites.");
		mntmView.addActionListener(new EventHandler());
		mnFile.add(mntmView);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic('E');
		mntmExit.setToolTipText("Exit and close the window.");
		mntmExit.addActionListener(new EventHandler());
		mnFile.add(mntmExit);
		
		setVisible(true);
	}
	
	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Add")){
				boolean test = true;
				if (Integer.parseInt(txtSiteNumber.getText()) < 0 || Integer.parseInt(txtSiteNumber.getText()) > 999){
					txtSiteNumber.setText("Out of range.");
					test = false;
				} else {
					if (CSL.exists(Integer.parseInt(txtSiteNumber.getText()))){
						txtSiteNumber.setText("Already exists.");
						test = false;
					} 
				}
				
				if (txtName.getText().length() > 25){
					txtName.setText("Name too long.");
					test = false;
				} else {
					if (CSL.exists(txtName.getText())){
						txtName.setText("Already exists.");
						test = false;
					}
				}
				
				if (txtLocation.getText().length() > 25){
					txtLocation.setText("Location too long.");
					test = false;
				}
				
				if (Integer.parseInt(txtLatitude.getText()) < -90 || Integer.parseInt(txtLatitude.getText()) > 90){
					txtLatitude.setText("Out of Range.");
					test = false;
				}
				
				if (Integer.parseInt(txtLongitude.getText()) < -180 || Integer.parseInt(txtLongitude.getText()) > 180){
					txtLongitude.setText("Out of Range.");
					test = false;
				}
				
				if (test){
					if (cmboDay.getSelectedIndex() == -1 || cmboMonth.getSelectedIndex() == -1 || cmboYear.getSelectedIndex() == -1){
						CSL.add(new CollectionSite(
								Integer.parseInt(txtSiteNumber.getText()), 
								txtName.getText(), 
								txtLocation.getText(), 
								Double.parseDouble(txtLatitude.getText()), 
								Double.parseDouble(txtLongitude.getText())));
					} else {
						String month =  (String) cmboMonth.getSelectedItem();
						String day =  (String) cmboDay.getSelectedItem();
						String year = (String) cmboYear.getSelectedItem();
						
						Date date = new Date(month, day, year);
						CSL.add(new CollectionSite(
								Integer.parseInt(txtSiteNumber.getText()), 
								txtName.getText(), 
								txtLocation.getText(), 
								Double.parseDouble(txtLatitude.getText()), 
								Double.parseDouble(txtLongitude.getText()),
								date.getDate()));
					}
					
					txtSiteNumber.setText("");
					txtName.setText("");
					txtLocation.setText("");
					txtLatitude.setText("");
					txtLongitude.setText("");
					cmboDay.setSelectedIndex(-1);
					cmboMonth.setSelectedIndex(-1);
					cmboYear.setSelectedIndex(-1);
				}
				
				
			} else if (e.getActionCommand().equals("Remove")){
				
			} else if (e.getActionCommand().equals("Edit")){
				
			} else if (e.getActionCommand().equals("Upload")){
				JFileChooser FC = new JFileChooser();
				FC.showOpenDialog(null);
				CollectionSiteReader CSR = new CollectionSiteReader();
				CSL = CSR.readDataFromCSV(FC.getName(FC.getSelectedFile()));
			} else if (e.getActionCommand().equals("View")){
				ListViewGUI LVG = new ListViewGUI(CSL);
			} else if (e.getActionCommand().equals("Exit")){
				dispose();
			}
			
		}
		
	}
}


