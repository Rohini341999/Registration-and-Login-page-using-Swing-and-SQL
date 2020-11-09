import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login extends JFrame implements ActionListener  {
	JFrame f;
	JLabel name,password;
	JTextField namet,passwordt;
	JButton login;
	login(){
		f = new JFrame("Login");
		f.getContentPane();
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new BoxLayout(jp1,BoxLayout.X_AXIS));
		jp2.setLayout(new BoxLayout(jp2,BoxLayout.X_AXIS));
		
		name= new JLabel("Username : ");
		namet= new JTextField(10);
		
		
		password= new JLabel("Password : ");
		passwordt= new JTextField(10);
		
		login= new JButton(" LOGIN ");
		f.add(jp1);
		f.add(jp2);
		f.add(jp3);
		jp1.add(name);jp1.add(namet);
		jp2.add(password);jp2.add(passwordt);
		jp3.add(login);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(700,250);	
		f.setVisible(true);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = name.getText();
				String pwd = password.getText();
				
				String msg = " " + uname;
				msg += "\n";
				try {
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Rohini@341999");
					PreparedStatement pt = con.prepareStatement("select username,password from account where username = ? and password = ?");
					pt.setString(1, uname);
					pt.setString(2, pwd);
					ResultSet rs = pt.executeQuery();
					if(rs.getMetaData() != null) {
						JOptionPane.showMessageDialog(login,"You logged in successfully");
					}
					else {
						JOptionPane.showMessageDialog(login,"Wrong Username or Password");
					}
					
				}
				catch(SQLException e){
					e.printStackTrace();
				}
						
			}
		});

		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
