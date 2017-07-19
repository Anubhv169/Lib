
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Searchbook
  extends JFrame
{
  private JPanel contentPane;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;
  private JTextField textField_5;
  private JTextField textField_6;
  private JTextField textField_6_1;
  private JTextField textField_7;
  private JTextField textField_7_1;
  private JTextField textField_8;
  private JTextField textField_8_1;
  private JTextField textField_9;
  private JTextField textField_9_1;
  private JTextField textField_10;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          Searchbook frame = new Searchbook("Update/Delete Book");
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public Searchbook(String str)
  {
	  super(str);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 849, 637);
    setLocationRelativeTo(this);
    //setResizable(false);
    this.contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 240));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    
    JLabel lblBookId = new JLabel("Book ID");
    
    this.textField = new JTextField();
    textField.setForeground(Color.BLACK);
    textField.setBackground(Color.WHITE);
    this.textField.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent arg0)
      {
        String bid = Searchbook.this.textField.getText();
        String query = "select * from book where id = ?";
        Connection con = DBInfo1.con;
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, bid);
          ResultSet res = ps.executeQuery();
          while (res.next())
          {
            Searchbook.this.textField_1.setText(res.getString(2));
            Searchbook.this.textField_2.setText(res.getString(7));
            Searchbook.this.textField_3.setText(res.getString(8));
            Searchbook.this.textField_4.setText(res.getString(9));
            Searchbook.this.textField_5.setText(res.getString(10));
            Searchbook.this.textField_6_1.setText(res.getString(3));
            Searchbook.this.textField_7_1.setText(res.getString(4));
            Searchbook.this.textField_8_1.setText(res.getString(5));
            Searchbook.this.textField_9_1.setText(res.getString(6));
            Searchbook.this.textField_9_1.setText(res.getString(11));
           
          }
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    this.textField.setColumns(10);
    
    JLabel lblTitle = new JLabel("Title");
    
    JLabel lblAuthor = new JLabel("Author");
    
    JLabel lblCategory = new JLabel("Category");
    
    JLabel lblSubject = new JLabel("Subject");
    
    JLabel lblPublication = new JLabel("Publication");
    
    this.textField_1 = new JTextField();
    textField_1.setForeground(Color.BLACK);
    textField_1.setBackground(Color.WHITE);
    this.textField_1.setColumns(10);
    
    this.textField_6 = new JTextField();
    this.textField_6.setColumns(10);
    
    this.textField_6_1 = new JTextField();
    textField_6_1.setForeground(Color.BLACK);
    textField_6_1.setBackground(Color.WHITE);
    this.textField_6_1.setColumns(10);
    
    this.textField_7_1 = new JTextField();
    textField_7_1.setForeground(Color.BLACK);
    textField_7_1.setBackground(Color.WHITE);
    this.textField_7_1.setColumns(10);
    
    this.textField_8_1 = new JTextField();
    textField_8_1.setForeground(Color.BLACK);
    textField_8_1.setBackground(Color.WHITE);
    this.textField_8_1.setColumns(10);
    
    this.textField_9_1 = new JTextField();
    textField_9_1.setForeground(Color.BLACK);
    textField_9_1.setBackground(Color.WHITE);
    this.textField_9_1.setColumns(10);
    
    final JComboBox comboBox = new JComboBox(GetValues.getAuthor());
    comboBox.setForeground(Color.BLACK);
    comboBox.setBackground(Color.WHITE);
    comboBox.insertItemAt("select", 0);
    comboBox.setSelectedIndex(0);
    
    comboBox.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent arg0)
      {
        String str = (String)comboBox.getSelectedItem();
        Searchbook.this.textField_6_1.setText(str);
      }
    });
    this.textField_7 = new JTextField();
    this.textField_7.setColumns(10);
    
    final JComboBox comboBox_1 = new JComboBox(GetValues.getCategory());
    comboBox_1.setForeground(Color.BLACK);
    comboBox_1.setBackground(Color.WHITE);
    comboBox_1.insertItemAt("select", 0);
    comboBox_1.setSelectedIndex(0);
    comboBox_1.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent arg0)
      {
        String str = (String)comboBox_1.getSelectedItem();
        Searchbook.this.textField_7_1.setText(str);
      }
    });
    this.textField_8 = new JTextField();
    this.textField_8.setColumns(10);
    
    final JComboBox comboBox_2 = new JComboBox(GetValues.getSubject());
    comboBox_2.setForeground(Color.BLACK);
    comboBox_2.setBackground(Color.WHITE);
    comboBox_2.insertItemAt("select", 0);
    comboBox_2.setSelectedIndex(0);
    comboBox_2.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        String str = (String)comboBox_2.getSelectedItem();
        Searchbook.this.textField_8_1.setText(str);
      }
    });
    this.textField_9 = new JTextField();
    this.textField_9.setColumns(10);
    
    final JComboBox comboBox_3 = new JComboBox(GetValues.getPublication());
    comboBox_3.setForeground(Color.BLACK);
    comboBox_3.setBackground(Color.WHITE);
    comboBox_3.insertItemAt("select", 0);
    comboBox_3.setSelectedIndex(0);
    comboBox_3.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        String str = (String)comboBox_3.getSelectedItem();
        Searchbook.this.textField_9_1.setText(str);
      }
    });
    JLabel lblIsbn = new JLabel("ISBN");
    
    this.textField_2 = new JTextField();
    textField_2.setForeground(Color.BLACK);
    textField_2.setBackground(Color.WHITE);
    this.textField_2.setColumns(10);
    
    JLabel lblEddition = new JLabel("Eddition");
    
    JLabel lblPrice = new JLabel("Price");
    
    JLabel lblQuantity = new JLabel("Quantity");
    
    this.textField_3 = new JTextField();
    textField_3.setForeground(Color.BLACK);
    textField_3.setBackground(Color.WHITE);
    this.textField_3.setColumns(10);
    
    this.textField_4 = new JTextField();
    textField_4.setForeground(Color.BLACK);
    textField_4.setBackground(Color.WHITE);
    this.textField_4.setColumns(10);
    
    this.textField_5 = new JTextField();
    textField_5.setForeground(Color.BLACK);
    textField_5.setBackground(Color.WHITE);
    this.textField_5.setColumns(10);
    
    JButton btnReset = new JButton("DELETE");
    btnReset.setForeground(Color.BLACK);
    btnReset.setBackground(Color.WHITE);
    btnReset.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e5)
      {
    	  String id = Searchbook.this.textField.getText();
          String name = Searchbook.this.textField_1.getText();
          String author = Searchbook.this.textField_6_1.getText();
          String category = Searchbook.this.textField_7_1.getText();
          String subject = Searchbook.this.textField_8_1.getText();
          String publication = Searchbook.this.textField_9_1.getText();
          String isbn = Searchbook.this.textField_2.getText();
          String eddition = Searchbook.this.textField_3.getText();
          String price = Searchbook.this.textField_4.getText();
          String quantity = Searchbook.this.textField_5.getText();
          String issued = Searchbook.this.textField_10.getText();
    	  
          if ((id.length() == 0) || (name.length() == 0) || (author.length() == 0) || (subject.length() == 0) || (publication.length() == 0) || (category.length() == 0) || (isbn.length() == 0) || (eddition.length() == 0) || (price.length() == 0) || (quantity.length() == 0) || (issued.length() == 0))
          {
          	JOptionPane.showMessageDialog(Searchbook.this.getParent(), "pls fill all the entries", "error", 0);

              Searchbook.this.textField.setText(null);
              
              Searchbook.this.textField_1.setText(null);
              Searchbook.this.textField_2.setText(null);
              Searchbook.this.textField_3.setText(null);
              Searchbook.this.textField_4.setText(null);
              Searchbook.this.textField_5.setText(null);
              Searchbook.this.textField_6_1.setText(null);
              Searchbook.this.textField_7_1.setText(null);
              Searchbook.this.textField_8_1.setText(null);
              Searchbook.this.textField_9_1.setText(null);
              Searchbook.this.textField_6.setText(null);
              Searchbook.this.textField_7.setText(null);
              Searchbook.this.textField_8.setText(null);
              Searchbook.this.textField_9.setText(null);
              Searchbook.this.textField_10.setText(null);
          	
          }
          else
          {
      
        
        String query = "delete from book where id =? ";
        Connection con = DBInfo1.con;
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          
          ps.setString(1, id);
          ps.executeUpdate();
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        JOptionPane.showMessageDialog(Searchbook.this.getParent(), "Book Deleted");
        Searchbook.this.textField.setText(null);
        
        Searchbook.this.textField_1.setText(null);
        Searchbook.this.textField_2.setText(null);
        Searchbook.this.textField_3.setText(null);
        Searchbook.this.textField_4.setText(null);
        Searchbook.this.textField_5.setText(null);
        Searchbook.this.textField_6_1.setText(null);
        Searchbook.this.textField_7_1.setText(null);
        Searchbook.this.textField_8_1.setText(null);
        Searchbook.this.textField_9_1.setText(null);
        Searchbook.this.textField_10.setText(null);
        comboBox.setSelectedIndex(0);
        comboBox_1.setSelectedIndex(0);
        comboBox_2.setSelectedIndex(0);
        comboBox_3.setSelectedIndex(0);
      }}
    });
    JButton btnUpdate = new JButton("UPDATE");
    btnUpdate.setBackground(Color.WHITE);
    btnUpdate.setForeground(Color.BLACK);
    btnUpdate.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String id = Searchbook.this.textField.getText();
        String name = Searchbook.this.textField_1.getText();
        String author = Searchbook.this.textField_6_1.getText();
        String category = Searchbook.this.textField_7_1.getText();
        String subject = Searchbook.this.textField_8_1.getText();
        String publication = Searchbook.this.textField_9_1.getText();
        String isbn = Searchbook.this.textField_2.getText();
        String eddition = Searchbook.this.textField_3.getText();
        String price = Searchbook.this.textField_4.getText();
        String quantity = Searchbook.this.textField_5.getText();
        String issued = Searchbook.this.textField_10.getText();
        
        if ((id.length() == 0) || (name.length() == 0) || (author.length() == 0) || (subject.length() == 0) || (publication.length() == 0) || (category.length() == 0) || (isbn.length() == 0) || (eddition.length() == 0) || (price.length() == 0) || (quantity.length() == 0) || (issued.length() == 0))
        {
        	JOptionPane.showMessageDialog(Searchbook.this.getParent(), "pls fill all the entries", "error", 0);

            Searchbook.this.textField.setText(null);
            
            Searchbook.this.textField_1.setText(null);
            Searchbook.this.textField_2.setText(null);
            Searchbook.this.textField_3.setText(null);
            Searchbook.this.textField_4.setText(null);
            Searchbook.this.textField_5.setText(null);
            Searchbook.this.textField_6_1.setText(null);
            Searchbook.this.textField_7_1.setText(null);
            Searchbook.this.textField_8_1.setText(null);
            Searchbook.this.textField_9_1.setText(null);
            Searchbook.this.textField_6.setText(null);
            Searchbook.this.textField_7.setText(null);
            Searchbook.this.textField_8.setText(null);
            Searchbook.this.textField_9.setText(null);
            Searchbook.this.textField_10.setText(null);
        	
        }
        else
        {
        String query = "update book set title=?,author=?,category=?,subject=?,publication=?,isbn=?,eddition=?,price=?,quantity=?,issued=? where id =?";
        
        
        Connection con = DBInfo1.con;
        int flag = 0;
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          

          ps.setString(1, name);
          ps.setString(2, author);
          ps.setString(3, category);
          ps.setString(4, subject);
          ps.setString(5, publication);
          ps.setString(6, isbn);
          ps.setString(7, eddition);
          ps.setString(8, price);
          ps.setString(9, quantity);
          ps.setString(10, issued);
          ps.setString(11, id);
          
          flag = ps.executeUpdate();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        if (flag == 1)
        {
          JOptionPane.showMessageDialog(Searchbook.this.getParent(), "book updated", "success", 1);
          
          Searchbook.this.textField.setText(null);
          
          Searchbook.this.textField_1.setText(null);
          Searchbook.this.textField_2.setText(null);
          Searchbook.this.textField_3.setText(null);
          Searchbook.this.textField_4.setText(null);
          Searchbook.this.textField_5.setText(null);
          Searchbook.this.textField_6_1.setText(null);
          Searchbook.this.textField_7_1.setText(null);
          Searchbook.this.textField_8_1.setText(null);
          Searchbook.this.textField_9_1.setText(null);
          Searchbook.this.textField_6.setText(null);
          Searchbook.this.textField_7.setText(null);
          Searchbook.this.textField_8.setText(null);
          Searchbook.this.textField_9.setText(null);
          Searchbook.this.textField_10.setText(null);
        }
        if (flag == 0) {
          JOptionPane.showMessageDialog(Searchbook.this.getParent(), "book not updated", "error", 0);
 Searchbook.this.textField.setText(null);
          
          Searchbook.this.textField_1.setText(null);
          Searchbook.this.textField_2.setText(null);
          Searchbook.this.textField_3.setText(null);
          Searchbook.this.textField_4.setText(null);
          Searchbook.this.textField_5.setText(null);
          Searchbook.this.textField_6_1.setText(null);
          Searchbook.this.textField_7_1.setText(null);
          Searchbook.this.textField_8_1.setText(null);
          Searchbook.this.textField_9_1.setText(null);
          Searchbook.this.textField_6.setText(null);
          Searchbook.this.textField_7.setText(null);
          Searchbook.this.textField_8.setText(null);
          Searchbook.this.textField_9.setText(null);
          Searchbook.this.textField_10.setText(null);
        }
      }}
    });
    
    JButton btnBack = new JButton("BACK");
    btnBack.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		 AdminSection a = new AdminSection("Admin Section");
             a.setVisible(true);
            dispose();
    	}
    });
    btnBack.setForeground(Color.BLACK);
    btnBack.setBackground(Color.WHITE);
    
    JLabel lblIssued = new JLabel("Issued");
    
    textField_10 = new JTextField();
    textField_10.setForeground(Color.BLACK);
    textField_10.setColumns(10);
    textField_10.setBackground(Color.WHITE);
    GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
    gl_contentPane.setHorizontalGroup(
    	gl_contentPane.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(143)
    			.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
    			.addGap(70)
    			.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    			.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
    			.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
    			.addGap(71))
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(117)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblPublication, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEddition, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblIssued, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblBookId, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
    			.addGap(28)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    				.addGroup(gl_contentPane.createSequentialGroup()
    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    						.addComponent(textField_9_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
    						.addComponent(textField_8_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
    						.addComponent(textField_7_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
    						.addComponent(textField_6_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
    						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
    							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
    							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
    							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
    							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
    							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
    							.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
    					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
    						.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(comboBox, 0, 218, Short.MAX_VALUE)))
    				.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
    			.addContainerGap())
    );
    gl_contentPane.setVerticalGroup(
    	gl_contentPane.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(92)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblBookId)
    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(19)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblTitle))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblAuthor)
    				.addComponent(textField_6_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
    			.addGap(23)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblCategory)
    				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
    				.addComponent(textField_7_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblSubject)
    				.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
    				.addComponent(textField_8_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(20)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblPublication)
    				.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
    				.addComponent(textField_9_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblIsbn)
    				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblEddition)
    				.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblPrice)
    				.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblQuantity)
    				.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblIssued)
    				.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(15)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
    				.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
    				.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
    			.addGap(26))
    );
    
    this.contentPane.setLayout(gl_contentPane);
  }
}
