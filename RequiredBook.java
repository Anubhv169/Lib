import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class RequiredBook extends JFrame {
	private final JLabel lblNewLabel = new JLabel("New label");
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public RequiredBook(String str) {
		super(str);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(new Color(255, 255, 240));
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		
		JLabel lblEnterPassword = new JLabel("Usertype");
		
		JLabel lblContact = new JLabel("Contact");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblBookName = new JLabel("Book Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
	    comboBox.insertItemAt("select", 0);
	    comboBox.insertItemAt("Admin", 1);
	       comboBox.insertItemAt("Faculty", 2);
	       comboBox.insertItemAt("Student", 3);
	       comboBox.setSelectedIndex(0);
	       
		JLabel lblBookAuthor = new JLabel("Book Author");
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = RequiredBook.this.textField.getText();
		        String bname = RequiredBook.this.textField_4.getText();
		        String bauthor = RequiredBook.this.textField_5.getText();
		        String contact = RequiredBook.this.textField_2.getText();
		        String email = RequiredBook.this.textField_3.getText();
		        String utype = (String)comboBox.getSelectedItem();
		        if ((name.length() == 0) || (bname.length() == 0) || (contact.length() == 0) || (email.length() == 0) || (utype.length() == 0)||(bauthor.length() == 0))
		        {
		          JOptionPane.showMessageDialog(RequiredBook.this.getParent(), "pls fill all the entries", "error", 0);
		          textField.setText(null);
		    		 textField_4.setText(null);
		    		 textField_2.setText(null);
		    		 textField_3.setText(null);
		    		 comboBox.setSelectedIndex(0);
		    		 textField_5.setText(null);
		        }
		        else
		        {
		        	String query1 = "insert into requiredbook values(?,?,?,?,?,?)";
      	          Connection con1 = DBInfo1.con;
      	          int flag1 = 0;
      	          try
      	          {
      	            PreparedStatement ps1 = con1.prepareStatement(query1);
      	            ps1.setString(5,bname);
      	            ps1.setString(1, name);
      	            ps1.setString(3, contact);
      	            ps1.setString(4, email);
      	           ps1.setString(2, utype);
      	         ps1.setString(6,bauthor);
      	           
      	            flag1 = ps1.executeUpdate();
      	            
      	            
      	          }
      	          catch (Exception e1)
      	          {
      	            e1.printStackTrace();
      	          }
      	          
      	          if(flag1 ==1)
      	          {
      	        	JOptionPane.showMessageDialog(RequiredBook.this.getParent(), "Book Saved");
      	        	textField.setText(null);
		    		 textField_4.setText(null);
		    		 textField_2.setText(null);
		    		 textField_3.setText(null);
		    		 comboBox.setSelectedIndex(0);
		    		 textField_5.setText(null);
      	          }
      	          else
      	          {
      	        	JOptionPane.showMessageDialog(RequiredBook.this.getParent(), "Book not Saved Check the details again", "error", 0);
      	        	textField.setText(null);
		    		 textField_4.setText(null);
		    		 textField_2.setText(null);
		    		 textField_3.setText(null);
		    		 comboBox.setSelectedIndex(0);
		    		 textField_5.setText(null);
      	          }
      	          
		        }
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 255, 224));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 textField.setText(null);
	    		 textField_4.setText(null);
	    		 textField_2.setText(null);
	    		 textField_3.setText(null);
	    		 comboBox.setSelectedIndex(0);
	    		 textField_5.setText(null);
				
			}
			
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 224));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultySection a = new FacultySection("Faculty Section");
	             a.setVisible(true);
	          
	           RequiredBook.this.dispose();
			}
		});
		
		
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		JTextArea textArea_2 = new JTextArea();
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookAuthor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, 0, 181, Short.MAX_VALUE)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
					.addGap(87))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContact)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookAuthor)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnReset)
						.addComponent(btnBack))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);
		
	    setDefaultCloseOperation(3);
	    setBounds(100, 100, 506, 414);
	    setLocationRelativeTo(this);
	}

	
}
