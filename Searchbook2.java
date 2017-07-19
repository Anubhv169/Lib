
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Searchbook2
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
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          Searchbook2 frame = new Searchbook2();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  public Searchbook2()
  {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 849, 686);
    setLocationRelativeTo(this);
    setResizable(false);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    
    JLabel lblNewLabel = new JLabel("New label");
    
    JLabel lblBookId = new JLabel("Book ID");
    
    this.textField = new JTextField();
    this.textField.addFocusListener(new FocusAdapter()
    {
      public void focusLost(FocusEvent arg0) {}
    });
    this.textField.setColumns(10);
    
    JLabel lblTitle = new JLabel("Title");
    
    JLabel lblAuthor = new JLabel("Author");
    
    JLabel lblCategory = new JLabel("Category");
    
    JLabel lblSubject = new JLabel("Subject");
    
    JLabel lblPublication = new JLabel("Publication");
    
    this.textField_1 = new JTextField();
    this.textField_1.setColumns(10);
    
    this.textField_6 = new JTextField();
    this.textField_6.setColumns(10);
    
    this.textField_7 = new JTextField();
    this.textField_7.setColumns(10);
    
    this.textField_8 = new JTextField();
    this.textField_8.setColumns(10);
    
    this.textField_9 = new JTextField();
    this.textField_9.setColumns(10);
    
    JLabel lblIsbn = new JLabel("ISBN");
    
    this.textField_2 = new JTextField();
    this.textField_2.setColumns(10);
    
    JLabel lblEddition = new JLabel("Eddition");
    
    JLabel lblPrice = new JLabel("Price");
    
    JLabel lblQuantity = new JLabel("Quantity");
    
    this.textField_3 = new JTextField();
    this.textField_3.setColumns(10);
    
    this.textField_4 = new JTextField();
    this.textField_4.setColumns(10);
    
    this.textField_5 = new JTextField();
    this.textField_5.setColumns(10);
    
    this.textField_6_1 = new JTextField();
    this.textField_6_1.setColumns(10);
    
    this.textField_7_1 = new JTextField();
    this.textField_7_1.setColumns(10);
    
    this.textField_8_1 = new JTextField();
    this.textField_8_1.setColumns(10);
    
    this.textField_9_1 = new JTextField();
    this.textField_9_1.setColumns(10);
    


    JButton btnNewButton = new JButton("SEARCH");
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String bid = Searchbook2.this.textField.getText();
        String query = "select * from book where id = ?";
        Connection con = DBInfo1.con;
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, bid);
          ResultSet res = ps.executeQuery();
          while (res.next())
          {
            Searchbook2.this.textField_1.setText(res.getString(2));
            Searchbook2.this.textField_6_1.setText(res.getString(3));
            Searchbook2.this.textField_7_1.setText(res.getString(4));
            Searchbook2.this.textField_8_1.setText(res.getString(5));
            Searchbook2.this.textField_9_1.setText(res.getString(6));
            Searchbook2.this.textField_2.setText(res.getString(7));
            Searchbook2.this.textField_3.setText(res.getString(8));
            Searchbook2.this.textField_4.setText(res.getString(9));
            Searchbook2.this.textField_5.setText(res.getString(10));
          }
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
      }
    });
    GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(gl_contentPane.createSequentialGroup()
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(gl_contentPane.createSequentialGroup()
      .addGap(178)
      .addComponent(lblNewLabel))
      .addGroup(gl_contentPane.createSequentialGroup()
      .addGap(117)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(lblBookId, -2, 80, -2)
      .addComponent(lblTitle, -2, 80, -2)
      .addComponent(lblAuthor, -2, 80, -2)
      .addComponent(lblCategory, -2, 80, -2)
      .addComponent(lblPublication, -2, 80, -2)
      .addComponent(lblSubject, -2, 80, -2)
      .addComponent(lblIsbn, -2, 80, -2)
      .addComponent(lblEddition, -2, 80, -2)
      .addComponent(lblPrice, -2, 80, -2)
      .addComponent(lblQuantity, -2, 80, -2))
      .addGap(28)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addComponent(this.textField_9_1, -2, 228, -2)
      .addComponent(this.textField_8_1, -2, 228, -2)
      .addComponent(this.textField_7_1, -2, 228, -2)
      .addComponent(this.textField_6_1, -2, 228, -2)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
      .addComponent(this.textField_5, -1, 228, 32767)
      .addComponent(this.textField_4, -1, 228, 32767)
      .addComponent(this.textField_3, -1, 228, 32767)
      .addComponent(this.textField_2, -1, 228, 32767)
      .addComponent(this.textField_1, -1, 228, 32767)
      .addComponent(this.textField, -1, 228, 32767)))))
      .addGroup(gl_contentPane.createSequentialGroup()
      .addGap(266)
      .addComponent(btnNewButton, -2, 161, -2)))
      .addContainerGap(380, 32767)));
    
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(gl_contentPane.createSequentialGroup()
      .addGap(48)
      .addComponent(lblNewLabel)
      .addGap(28)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblBookId)
      .addComponent(this.textField, -2, -1, -2))
      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(this.textField_1, -2, -1, -2)
      .addComponent(lblTitle))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblAuthor)
      .addComponent(this.textField_6_1, -2, -1, -2))
      .addGap(23)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblCategory)
      .addComponent(this.textField_7_1, -2, -1, -2))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblSubject)
      .addComponent(this.textField_8_1, -2, -1, -2))
      .addGap(20)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblPublication)
      .addComponent(this.textField_9_1, -2, -1, -2))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblIsbn)
      .addComponent(this.textField_2, -2, -1, -2))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblEddition)
      .addComponent(this.textField_3, -2, -1, -2))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblPrice)
      .addComponent(this.textField_4, -2, -1, -2))
      .addGap(18)
      .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(lblQuantity)
      .addComponent(this.textField_5, -2, -1, -2))
      .addGap(37)
      .addComponent(btnNewButton, -2, 29, -2)
      .addContainerGap(71, 32767)));
    
    this.contentPane.setLayout(gl_contentPane);
  }
}
