import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class register extends JFrame implements ActionListener {
	
			JFrame f;
			JLabel lbl1 ,firstname,lastname,email,username,password,mobileno;
			JTextField firstnamet,lastnamet,emailt,usernamet,passwordt,mobilenot;
			JButton btn;
			register(){
				f = new JFrame("Register");
				f.getContentPane();
				
				JPanel jp1 = new JPanel();
				JPanel jp2 = new JPanel();
				JPanel jp3 = new JPanel();
				
				jp1.setLayout(new BoxLayout(jp1,BoxLayout.Y_AXIS));
				jp2.setLayout(new BoxLayout(jp2,BoxLayout.Y_AXIS));
				jp3.setLayout(new BoxLayout(jp3,BoxLayout.X_AXIS));
				
				lbl1= new JLabel("Registration Form");
				
				firstname= new JLabel("First name : ");
				firstnamet= new JTextField(10);
				
				lastname= new JLabel("Last name : ");
				lastnamet= new JTextField(10);
				
				email= new JLabel("Email id : ");
				emailt= new JTextField(10);
				
				username= new JLabel("Username : ");
				usernamet= new JTextField(10);
				
				password= new JLabel("Password : ");
				passwordt= new JTextField(10);
				
				mobileno= new JLabel("Mobile no : ");
				mobilenot= new JTextField(10);
				
				btn = new JButton("Register");
				f.add(lbl1);
				f.add(jp1);
				f.add(jp2);
				f.add(jp3);
				
				jp1.add(firstname);jp1.add(lastname);jp1.add(email);jp1.add(username);jp1.add(password);jp1.add(mobileno);
				jp2.add(firstnamet);jp2.add(lastnamet);jp2.add(emailt);jp2.add(usernamet);jp2.add(passwordt);jp2.add(mobilenot);
				jp3.add(btn);
				f.setLayout(new FlowLayout());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(2000,2000);	
				f.setVisible(true);
			
			
				btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fname = firstnamet.getText();
					String lname = lastnamet.getText();
					String pwd = passwordt.getText();
					String mobile = mobilenot.getText();
					String uname = usernamet.getText();
					String emailid = emailt.getText();
					int len = mobile.length();
					
					String msg = " " + fname;
					msg += "\n";
					if(len!=10) {
					JOptionPane.showMessageDialog(btn,"Enter valid mobile no");	
					}
					try {
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "Rohini@341999");
						String q = "insert into account values('"+fname+"','"+lname+"','"+uname+"','"+emailid+"','"+pwd+"','"+mobile+"')";
						Statement st = con.createStatement();
						int x = st.executeUpdate(q);
						if(x==0) {
							JOptionPane.showMessageDialog(btn,"Already exists");
						}
						else {
							JOptionPane.showMessageDialog(btn,"Welcome , " +msg+ "Your account has been created successfully...");
						}
					
					}
					catch(SQLException e){
						e.printStackTrace();
					}
							
				}
			});
			
			
		}
		public static void main(String[] args) {
			new register();
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

}
