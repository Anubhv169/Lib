
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class Registration2
  extends JFrame
{
  private JPanel contentPane;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JPasswordField passwordField;
  private JPasswordField passwordField_1;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          Registration2 frame = new Registration2("Registration");
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public Registration2(String str)
  {
	  super(str);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 647, 481);
    this.contentPane = new JPanel();
    this.contentPane.setBackground(new Color(255, 255, 240));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    
    setContentPane(this.contentPane);
    setLocationRelativeTo(this);
    
    JLabel lblEnterName = new JLabel("Enter name");
    lblEnterName.setName("");
    
    this.textField = new JTextField();
    this.textField.setBackground(Color.WHITE);
    this.textField.setColumns(10);
    
    JLabel lblEnterEmailAddress = new JLabel("Enter contact");
    lblEnterEmailAddress.setName("");
    
    this.textField_1 = new JTextField();
    this.textField_1.setBackground(Color.WHITE);
    this.textField_1.setColumns(10);
    
    JLabel lblEnterEmail = new JLabel("Enter email");
    lblEnterEmail.setName("");
    
    this.textField_2 = new JTextField();
    this.textField_2.setBackground(Color.WHITE);
    this.textField_2.setColumns(10);
    
    JLabel lblEnterUsertype = new JLabel("Enter Usertype");
    lblEnterUsertype.setName("");
    
    JLabel lblEnterPassword = new JLabel("Enter Password");
    lblEnterPassword.setName("");
    
    this.passwordField = new JPasswordField();
    this.passwordField.setBackground(Color.WHITE);
    
    JLabel lblRetypePassword = new JLabel("Retype Password");
    lblRetypePassword.setName("");
    
    this.passwordField_1 = new JPasswordField();
    this.passwordField_1.setBackground(Color.WHITE);
    
    JComboBox comboBox = new JComboBox();
    comboBox.setBackground(Color.WHITE);
 comboBox.insertItemAt("select", 0);
 comboBox.insertItemAt("Admin", 1);
    comboBox.insertItemAt("Faculty", 2);
    comboBox.insertItemAt("Student", 3);
    comboBox.setSelectedIndex(0);
    
    JButton btnNewButton = new JButton("SAVE");
    btnNewButton.setBackground(Color.WHITE);
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String name = Registration2.this.textField.getText();
        String contact = Registration2.this.textField_1.getText();
        String email = Registration2.this.textField_2.getText();
        String uname = (String)comboBox.getSelectedItem();
        String pass = String.copyValueOf(Registration2.this.passwordField.getPassword());
        String repass = String.copyValueOf(Registration2.this.passwordField_1.getPassword());
        if ((name.length() == 0) || (contact.length() == 0) || (email.length() == 0) || (uname.length() == 0) || (pass.length() == 0) || (repass.length() == 0))
        {
          JOptionPane.showMessageDialog(Registration2.this.getParent(), "pls fill all the entries", "error", 0);
        }
        else if (!pass.equals(repass))
        {
          JOptionPane.showMessageDialog(Registration2.this.getParent(), "password and repassword are same");
          Registration2.this.textField.setText(null);
          Registration2.this.textField_1.setText(null);
          Registration2.this.textField_2.setText(null);
          comboBox.setSelectedIndex(0);
          Registration2.this.passwordField.setText(null);
          Registration2.this.passwordField_1.setText(null);
        }
        else
        {
          String query = "insert into registration values(?,?,?,?,?)";
          Connection con = DBInfo1.con;
          int flag = 0;
          try
          {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, contact);
            ps.setString(3, email);
            ps.setString(4, uname);
            ps.setString(5,pass);
            flag = ps.executeUpdate();
          }
          catch (Exception e1)
          {
            e1.printStackTrace();
          }
          String query1 = "insert into login values(?,?,?)";
          Connection con1 = DBInfo1.con;
          int flag1 = 0;
          try
          {
            PreparedStatement ps = con.prepareStatement(query1);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, uname);
            
            flag1 = ps.executeUpdate();
          }
          catch (Exception e1)
          {
            e1.printStackTrace();
          }
          if ((flag != 0) && (flag1 != 0))
          {
            JOptionPane.showMessageDialog(Registration2.this.getParent(), "Record inserted");
            Registration2.this.textField.setText(null);
            Registration2.this.textField_1.setText(null);
            Registration2.this.textField_2.setText(null);
            comboBox.setSelectedIndex(0);
            Registration2.this.passwordField.setText(null);
            Registration2.this.passwordField_1.setText(null);
          }
          else
          {
            JOptionPane.showMessageDialog(Registration2.this.getParent(), "registration failed");
          }
        }
      }
    });
    JButton btnReset = new JButton("RESET");
    btnReset.setBackground(Color.WHITE);
    btnReset.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Registration2.this.textField.setText(null);
        Registration2.this.textField_1.setText(null);
        Registration2.this.textField_2.setText(null);
        comboBox.setSelectedIndex(0);
        Registration2.this.passwordField.setText(null);
        Registration2.this.passwordField_1.setText(null);
      }
    });
    JButton btnLoginNow = new JButton("BACK");
    btnLoginNow.setBackground(Color.WHITE);
    btnLoginNow.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Registration2.this.dispose();
        AdminSection a = new AdminSection("Admin Section");
        a.setVisible(true);
      }
    });
    
    
    GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
    gl_contentPane.setHorizontalGroup(
    	gl_contentPane.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(113)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    				.addComponent(lblEnterName, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblRetypePassword, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterUsertype, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterEmail, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterEmailAddress, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
    				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    				.addGroup(gl_contentPane.createSequentialGroup()
    					.addGap(52)
    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
    						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
    						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
    						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
    						.addComponent(passwordField)
    						.addComponent(passwordField_1)
    						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    				.addGroup(gl_contentPane.createSequentialGroup()
    					.addGap(28)
    					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
    					.addGap(36)
    					.addComponent(btnLoginNow)))
    			.addContainerGap(123, Short.MAX_VALUE))
    );
    gl_contentPane.setVerticalGroup(
    	gl_contentPane.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(84)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
    			.addGap(15)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
    				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterEmailAddress, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
    			.addPreferredGap(ComponentPlacement.UNRELATED)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
    			.addGap(17)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblEnterUsertype, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
    				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblRetypePassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
    				.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(33)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
    				.addComponent(btnLoginNow, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    			.addContainerGap(39, Short.MAX_VALUE))
    );
    
    this.contentPane.setLayout(gl_contentPane);
  }
}

