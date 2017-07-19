import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangeSelfPass2 extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	public ChangeSelfPass2(String str) {
		super(str);
		getContentPane().setBackground(new Color(255, 255, 240));
	    setDefaultCloseOperation(3);
	    setBounds(100, 100, 531, 413);
	    setLocationRelativeTo(this);
	    //setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel lblEnterContact = new JLabel("Contact");
		lblEnterContact.setForeground(Color.BLACK);
		
		JLabel lblEnterEmail = new JLabel("Current Password");
		lblEnterEmail.setForeground(Color.BLACK);
		
		JLabel lblEnter = new JLabel("New Pass");
		lblEnter.setForeground(Color.BLACK);
		
		JLabel lblConfirmnewpass = new JLabel("Confirm New Pass");
		lblConfirmnewpass.setForeground(Color.BLACK);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = ChangeSelfPass2.this.textField.getText();
		        String contact = ChangeSelfPass2.this.textField_1.getText();
		        String pass = String.copyValueOf(ChangeSelfPass2.this.passwordField.getPassword());
		        String newpass = String.copyValueOf(ChangeSelfPass2.this.passwordField_1.getPassword());
		        String newrepass = String.copyValueOf(ChangeSelfPass2.this.passwordField_2.getPassword());
		        if ((name.length() == 0) || (contact.length() == 0) || (contact.length() == 0) || (pass.length() == 0) || (newpass.length() == 0) || (newrepass.length() == 0))
		        {
		          JOptionPane.showMessageDialog(ChangeSelfPass2.this.getParent(), "pls fill all the entries", "error", 0);
		        }
		        else if (!newpass.equals(newrepass))
		        {
		          JOptionPane.showMessageDialog(ChangeSelfPass2.this.getParent(), "new password and Confirm password should be same");
		          ChangeSelfPass2.this.textField.setText(null);
		          ChangeSelfPass2.this.textField_1.setText(null);
		          ChangeSelfPass2.this.passwordField.setText(null);
		          ChangeSelfPass2.this.passwordField_1.setText(null);
		          ChangeSelfPass2.this.passwordField_2.setText(null);
		        }
		        else
		        {
		        	String query = "update registration set pass=? where name=? and contact=?";
		            Connection con = DBInfo1.con;
		            int flag = 0;
		            try
		            {
		              PreparedStatement ps = con.prepareStatement(query);
		              ps.setString(1, newpass);
		              ps.setString(2, name);
		              ps.setString(3, contact);
		             
		              flag = ps.executeUpdate();
		            }
		            catch (Exception e1)
		            {
		              e1.printStackTrace();
		            }
		            String query1 = "update login set password=? where username=? and usertype=?";
		            Connection con1 = DBInfo1.con;
		            int flag1 = 0;
		            try
		            {
		              PreparedStatement ps = con.prepareStatement(query1);
		              ps.setString(1, newpass);
		              ps.setString(2, name);
		              ps.setString(3, "faculty");
		             
		              
		              flag1 = ps.executeUpdate();
		            }
		            catch (Exception e1)
		            {
		              e1.printStackTrace();
		            }
		            if ((flag != 0) && (flag1 != 0))
		            {
		              JOptionPane.showMessageDialog(ChangeSelfPass2.this.getParent(), "Password Changed");
		              ChangeSelfPass2.this.textField.setText(null);
			          ChangeSelfPass2.this.textField_1.setText(null);
			          ChangeSelfPass2.this.passwordField.setText(null);
			          ChangeSelfPass2.this.passwordField_1.setText(null);
			          ChangeSelfPass2.this.passwordField_2.setText(null);
		            }
		            else
		            {
		              JOptionPane.showMessageDialog(ChangeSelfPass2.this.getParent(), "There are some error");
		              ChangeSelfPass2.this.textField.setText(null);
			          ChangeSelfPass2.this.textField_1.setText(null);
			          ChangeSelfPass2.this.passwordField.setText(null);
			          ChangeSelfPass2.this.passwordField_1.setText(null);
			          ChangeSelfPass2.this.passwordField_2.setText(null);
		            }
		        }
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
				passwordField_2.setText(null);
			}
		});
		btnReset.setBackground(Color.WHITE);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 FacultySection a = new FacultySection("Faculty Section");
	             a.setVisible(true);
	           ChangeSelfPass2.this.dispose();
			}
		});
		btnBack.setBackground(Color.WHITE);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(Color.WHITE);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterContact, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterEmail, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnter, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmnewpass, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
								.addComponent(passwordField)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterContact)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterEmail)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnter)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmnewpass)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnReset)
						.addComponent(btnBack))
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);
	}

	
}
