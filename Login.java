
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Login
  extends JFrame
{
  private JTextField textField;
  private JPasswordField passwordField;
  
  public Login(String title)
  {
    super(title);
    setSize(539, 250);
    setLocationRelativeTo(this);
    setDefaultCloseOperation(3);
    
    getContentPane().setBackground(new Color(255, 255, 240));
    
    JLabel lblEnterUsername = new JLabel("Enter username");
    
    JLabel lblEnterPassword = new JLabel("Enter password");
    
    this.textField = new JTextField();
    this.textField.setBackground(Color.WHITE);
    this.textField.setColumns(10);
    
    this.passwordField = new JPasswordField();
    this.passwordField.setBackground(Color.WHITE);
    
    JButton btnLoginNow = new JButton("Login Now");
    btnLoginNow.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String s1 = Login.this.textField.getText();
        char[] ch = Login.this.passwordField.getPassword();
        String s2 = String.copyValueOf(ch);
        
        Connection con = DBInfo1.con;
        String query = "select * from login where username =? and password =?";
        
        String usertype = "  ";
        int flag = 0;
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, s1);
          ps.setString(2, s2);
          ResultSet res = ps.executeQuery();
          if (res.next())
          {
            flag = 1;
            usertype = res.getString(3);
          }
          if ((flag == 1) && (usertype.equalsIgnoreCase("admin")))
          {
            AdminSection a = new AdminSection("Admin Section");
            a.setVisible(true);
            Login.this.dispose();
          }
          if ((flag == 1) && (usertype.equalsIgnoreCase("student")))
          {
            StudentSection a = new StudentSection("student Section");
            a.setVisible(true);
            Login.this.dispose();
          }
          if ((flag == 1) && (usertype.equalsIgnoreCase("faculty")))
          {
            FacultySection a = new FacultySection("Faculty Section");
            a.setVisible(true);
            Login.this.dispose();
          }
          if (flag == 0)
          {
            JOptionPane.showMessageDialog(Login.this.getParent(), "wrong username or password", "error", 0);
            Login.this.textField.setText(null);
            Login.this.passwordField.setText(null);
          }
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    btnLoginNow.setBackground(Color.WHITE);
    
    JButton btnReset = new JButton("Reset");
    btnReset.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Login.this.textField.setText(null);
        Login.this.passwordField.setText(null);
      }
    });
    btnReset.setBackground(Color.WHITE);
    
    JButton btnRegistration = new JButton("Register");
    btnRegistration.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Registration b = new Registration("Registration");
        b.setVisible(true);
        Login.this.dispose();
      }
    });
    btnRegistration.setBackground(Color.WHITE);
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    				.addGroup(groupLayout.createSequentialGroup()
    					.addGap(32)
    					.addComponent(lblEnterUsername, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
    				.addGroup(groupLayout.createSequentialGroup()
    					.addGap(50)
    					.addComponent(btnLoginNow)))
    			.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
    				.addGroup(groupLayout.createSequentialGroup()
    					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    					.addPreferredGap(ComponentPlacement.UNRELATED)
    					.addComponent(lblEnterPassword, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
    					.addPreferredGap(ComponentPlacement.RELATED))
    				.addGroup(groupLayout.createSequentialGroup()
    					.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
    					.addGap(66)))
    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    				.addComponent(btnRegistration, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
    				.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
    			.addContainerGap())
    );
    groupLayout.setVerticalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGap(49)
    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterPassword)
    				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEnterUsername))
    			.addGap(52)
    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    				.addComponent(btnRegistration)
    				.addComponent(btnLoginNow)
    				.addComponent(btnReset))
    			.addContainerGap(55, Short.MAX_VALUE))
    );
    
    getContentPane().setLayout(groupLayout);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Admin");
    menuBar.add(mntmNewMenuItem);
    
    JMenuItem mntmFaculty = new JMenuItem("Faculty");
    menuBar.add(mntmFaculty);
    
    JMenuItem mntmStudent = new JMenuItem("Student");
    menuBar.add(mntmStudent);
  }
  
  public static void main(String[] args)
  {
    Login l = new Login("Login Page");
    l.setVisible(true);
  }
}

