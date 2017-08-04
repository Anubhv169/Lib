import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SubmitBook2 extends JFrame {
	private final JLabel lblNewLabel = new JLabel("Submit Book");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public SubmitBook2(String str) {
		super(str);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(new Color(255, 255, 240));
		
	    setDefaultCloseOperation(3);
	    setBounds(100, 100, 506, 416);
	    setLocationRelativeTo(this);
	    
	    JLabel lblNewLabel_1 = new JLabel("Book Id");
	    lblNewLabel_1.setForeground(Color.BLACK);
	    lblNewLabel_1.setBackground(Color.WHITE);
	    
	    JLabel lblName = new JLabel("Name");
	    lblName.setForeground(Color.BLACK);
	    lblName.setBackground(Color.WHITE);
	    
	    JLabel lblOntact = new JLabel("Contact");
	    lblOntact.setForeground(Color.BLACK);
	    
	    JLabel lblEmail = new JLabel("Email");
	    lblEmail.setForeground(Color.BLACK);
	    
	    JLabel lblUsertype = new JLabel("UserType");
	    lblUsertype.setForeground(Color.BLACK);
	    
	    textField = new JTextField();
	    textField.setForeground(Color.BLACK);
	    textField.setBackground(Color.WHITE);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBackground(Color.WHITE);
	    comboBox.insertItemAt("select", 0);
	    comboBox.insertItemAt("Admin", 1);
	       comboBox.insertItemAt("Faculty", 2);
	       comboBox.insertItemAt("Student", 3);
	       comboBox.setSelectedIndex(0);
	    
	    JButton btnNewButton = new JButton("RETURN");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String bookid = SubmitBook2.this.textField.getText();
		        String name = SubmitBook2.this.textField_1.getText();
		        String contact = SubmitBook2.this.textField_2.getText();
		        String email = SubmitBook2.this.textField_3.getText();
		        String utype = (String)comboBox.getSelectedItem();
		        if ((name.length() == 0) || (bookid.length() == 0) || (contact.length() == 0) || (email.length() == 0) || (utype.length() == 0))
		        {
		          JOptionPane.showMessageDialog(SubmitBook2.this.getParent(), "pls fill all the entries", "error", 0);
		          textField.setText(null);
		    		 textField_1.setText(null);
		    		 textField_2.setText(null);
		    		 textField_3.setText(null);
		    		 comboBox.setSelectedIndex(0);
		        }
		        else
		        {
		        	String query = "select * from registration where name=? && contact=? && email=? && uname=?";
		        	 Connection con = DBInfo1.con;
		        	 int flag=0;
		        	 try
		        	 {
		        		 PreparedStatement ps = con.prepareStatement(query);
		        		 ps.setString(1, name);
		        		 ps.setString(2, contact);
		        		 ps.setString(3, email);
		        		 ps.setString(4, utype);
		        		 ResultSet res = ps.executeQuery();
		                 if (res.next())
		                 {
		                	 flag=1;
		                 }
		        	 }
		                 catch(Exception e1)
			        	 {
			        		 e1.printStackTrace();
			        	 }
		                 if(flag==0)
		                 {
		                	 JOptionPane.showMessageDialog(SubmitBook2.this.getParent(), "Not a registered User", "error", 0);
		        			 textField.setText(null);
		    	    		 textField_1.setText(null);
		    	    		 textField_2.setText(null); 
		    	    		 textField_3.setText(null);
		    	    		 comboBox.setSelectedIndex(0);
		                 }
		        	
		        		 else
		        		 {
		        			  String query1 = "delete from issuebook where bookid=? && name=? && contact=? && utype=?";
		        	          Connection con1 = DBInfo1.con;
		        	          int flag1 = 0;
		        	          try
		        	          {
		        	            PreparedStatement ps1 = con1.prepareStatement(query1);
		        	            ps1.setString(1,bookid);
		        	            ps1.setString(2, name);
		        	            ps1.setString(3, contact);
		        	            
		        	           ps1.setString(4, utype);
		        	           
		        	            flag1 = ps1.executeUpdate();
		        	            
		        	            
		        	          }
		        	          catch (Exception e1)
		        	          {
		        	            e1.printStackTrace();
		        	          }
		        	          if(flag1==1)
		        	            {
		        	            	 JOptionPane.showMessageDialog(SubmitBook2.this.getParent(), "Book Submitted");
				        			 textField.setText(null);
				    	    		 textField_1.setText(null);
				    	    		 textField_2.setText(null);
				    	    		 textField_3.setText(null);
				    	    		 comboBox.setSelectedIndex(0);
		        	            }
		        	            else
		        	            {
		        	            	 JOptionPane.showMessageDialog(SubmitBook2.this.getParent(), "Book not Returned Check the details again", "error", 0);
				        			 textField.setText(null);
				    	    		 textField_1.setText(null);
				    	    		 textField_2.setText(null);
				    	    		 textField_3.setText(null);
				    	    		 comboBox.setSelectedIndex(0);
		        	            }
		        	   
		        	          int status=0;
			        	      	int quantity=0,issued=0;
			        	      	try{
			        	      	Connection con3 = DBInfo1.con;
			        	      		
			        	      		PreparedStatement ps1=con.prepareStatement("select quantity,issued from book where id=?");
			        	      		ps1.setString(1,bookid);
			        	      		ResultSet rs=ps1.executeQuery();
			        	      		if(rs.next()){
			        	      			quantity=rs.getInt("quantity");
			        	      			issued=rs.getInt("issued");
			        	      		}
			        	      		
			        	      		if(quantity>0){
			        	      		PreparedStatement ps2=con.prepareStatement("update book set quantity=?,issued=? where id=?");
			        	      		ps2.setInt(1,quantity+1);
			        	      		ps2.setInt(2,issued-1);
			        	      		ps2.setString(3,bookid);
			        	      		
			        	      		status=ps2.executeUpdate();
			        	      		}
			        	      
			        	      	}catch(Exception e1){System.out.println(e1);}
		        		 }
		        		
		        	 
		        	
		        }
		        
	    	}
	    });
	    btnNewButton.setBackground(Color.WHITE);
	    
	    JButton btnUpdate = new JButton("RESET");
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 textField.setText(null);
	    		 textField_1.setText(null);
	    		 textField_2.setText(null);
	    		 textField_3.setText(null);
	    		 comboBox.setSelectedIndex(0);
	    	}
	    });
	    btnUpdate.setBackground(Color.WHITE);
	    
	    JButton btnBack = new JButton("BACK");
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		FacultySection a = new FacultySection("Faculty Section");
	             a.setVisible(true);
	          
	           SubmitBook2.this.dispose();
	    	}
	    });
	    btnBack.setBackground(Color.WHITE);
	    
	   
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(83)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblOntact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblUsertype, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(btnNewButton))
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(42)
	    							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
	    								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
	    								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
	    								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
	    								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(17)
	    							.addComponent(btnUpdate)
	    							.addGap(44)
	    							.addComponent(btnBack)))
	    					.addGap(10)))
	    			.addContainerGap(77, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
	    			.addGap(63)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblOntact, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblUsertype, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(btnNewButton)
	    				.addComponent(btnUpdate)
	    				.addComponent(btnBack))
	    			.addGap(32))
	    );
	    getContentPane().setLayout(groupLayout);
	    //setResizable(false);
	}

	
}
