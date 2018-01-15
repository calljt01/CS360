import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class loginGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JLabel lblError;
	private JPasswordField txtPassword;
	
	public loginGUI(){
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		setBounds(200, 300, 300, 175);
		
		JPanel userNamePanel = new JPanel();
		getContentPane().add(userNamePanel);
		
		JLabel lblUsername = new JLabel("Username:");
		userNamePanel.add(lblUsername);
		
		txtUsername = new JTextField();
		userNamePanel.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setColumns(10);
		
		JPanel passwordPanel = new JPanel();
		getContentPane().add(passwordPanel);
		
		JLabel lblPassword = new JLabel("Password:");
		passwordPanel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		passwordPanel.add(txtPassword);
		
		JPanel submitPanel = new JPanel();
		getContentPane().add(submitPanel);
		
		JButton btnLogin = new JButton("Login");
		submitPanel.add(btnLogin);
		
		JPanel errorPanel = new JPanel();
		getContentPane().add(errorPanel);
		
		lblError = new JLabel("");
		errorPanel.add(lblError);
		lblError.setForeground(Color.RED);
		btnLogin.addActionListener(new EventHandler());
		
		setVisible(true);
	}
	
	private class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (txtUsername.getText().equals("siteadmin") && txtPassword.getPassword().equals("sitepwd123")){
				GUI gui = new GUI();
				dispose();
			} else {
				lblError.setText("Wrong Username or Password. Please try again.");
				txtUsername.setText("");
				txtPassword.setText("");
			}
		}
	}
	
	
}