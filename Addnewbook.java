
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Addnewbook
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
  
  
  
  public String _getID()
  {
    String bid = " ";
    for (int i = 0; i < 7; i++) {
      bid = bid + ((int)(Math.random() * 9.0D) + 1);
    }
    return bid;
  }
  
  public Addnewbook(String str)
  {
	  super(str);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 628, 650);
    setLocationRelativeTo(this);
    setResizable(false);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBackground(new Color(255, 255, 240));
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("Add New");
    menuBar.add(mnNewMenu);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("author");
    mntmNewMenuItem.setBackground(Color.WHITE);
    mntmNewMenuItem.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String str = e.getActionCommand();
        
        String value = JOptionPane.showInputDialog(Addnewbook.this.getParent(), "enter " + str + "name");
        
        String aid = " ";
        for (int i = 0; i < 4; i++) {
          aid = aid + ((int)(Math.random() * 9.0D) + 1);
        }
        Connection con = DBInfo1.con;
        int flag = 0;
        String query = "insert into author(id,name) values(?,?)";
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, aid);
          ps.setString(2, value.toUpperCase());
          


          flag = ps.executeUpdate();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        if (flag == 1) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "added successfully");
        }
        if (flag == 0) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "value not inserted ");
        }
        Addnewbook frame = new Addnewbook("Add New Book");
        frame.setVisible(true);
        Addnewbook.this.dispose();
        dispose();
      }
    });
    mnNewMenu.add(mntmNewMenuItem);
    mnNewMenu.addSeparator();
    
    JMenuItem mntmCategory = new JMenuItem("category");
    mntmCategory.setBackground(Color.WHITE);
    mntmCategory.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String str = e.getActionCommand();
        
        String value = JOptionPane.showInputDialog(Addnewbook.this.getParent(), "enter" + str + "name");
        
        String cid = " ";
        for (int i = 0; i < 4; i++) {
          cid = cid + ((int)(Math.random() * 9.0D) + 1);
        }
        Connection con = DBInfo1.con;
        int flag = 0;
        String query = "insert into category(id,name) values(?,?)";
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, cid);
          ps.setString(2, value.toUpperCase());
          
          flag = ps.executeUpdate();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        if (flag == 1) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "added successfully");
        }
        if (flag == 0) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "value not inserted ");
        }
        Addnewbook frame = new Addnewbook("Add New Book");
        frame.setVisible(true);
        dispose();
      }
    });
    mnNewMenu.add(mntmCategory);
    mnNewMenu.addSeparator();
    
    JMenuItem mntmSubject = new JMenuItem("subject");
    mntmSubject.setBackground(Color.WHITE);
    mntmSubject.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String str = e.getActionCommand();
        
        String value = JOptionPane.showInputDialog(Addnewbook.this.getParent(), "enter" + str + "name");
        
        String sid = " ";
        for (int i = 0; i < 4; i++) {
          sid = sid + ((int)(Math.random() * 9.0D) + 1);
        }
        Connection con = DBInfo1.con;
        int flag = 0;
        String query = "insert into subject(id,name) values(?,?)";
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, sid);
          ps.setString(2, value.toUpperCase());
          
          flag = ps.executeUpdate();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        if (flag == 1) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "added successfully");
        }
        if (flag == 0) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "value not inserted ");
        }
        Addnewbook frame = new Addnewbook("Add New Book");
        frame.setVisible(true);
        dispose();
      }
    });
    mnNewMenu.add(mntmSubject);
    mnNewMenu.addSeparator();
    
    JMenuItem mntmPublication = new JMenuItem("publication");
    mntmPublication.setBackground(Color.WHITE);
    mntmPublication.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String str = e.getActionCommand();
        
        String value = JOptionPane.showInputDialog(Addnewbook.this.getParent(), "enter" + str + "name");
        
        String pid = " ";
        for (int i = 0; i < 4; i++) {
          pid = pid + ((int)(Math.random() * 9.0D) + 1);
        }
        Connection con = DBInfo1.con;
        int flag = 0;
        String query = "insert into publication(id,name) values(?,?)";
        try
        {
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1, pid);
          ps.setString(2, value.toUpperCase());
          
          flag = ps.executeUpdate();
        }
        catch (Exception e1)
        {
          e1.printStackTrace();
        }
        if (flag == 1) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "added successfully");
        }
        if (flag == 0) {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), str + "value not inserted ");
        }
        Addnewbook frame = new Addnewbook("Add New Book");
        frame.setVisible(true);
        dispose();
      }
    });
    mnNewMenu.add(mntmPublication);
    mnNewMenu.addSeparator();
    this.contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 240));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    
    JLabel lblBookId = new JLabel("Book ID");
    
    this.textField = new JTextField(_getID());
    textField.setBackground(Color.WHITE);
    this.textField.setEditable(false);
    this.textField.setColumns(10);
    
    JLabel lblTitle = new JLabel("Title");
    
    JLabel lblAuthor = new JLabel("Author");
    
    JLabel lblCategory = new JLabel("Category");
    
    JLabel lblSubject = new JLabel("Subject");
    
    JLabel lblPublication = new JLabel("Publication");
    
    this.textField_1 = new JTextField();
    textField_1.setBackground(Color.WHITE);
    this.textField_1.setColumns(10);
    
    final JComboBox comboBox = new JComboBox(GetValues.getAuthor());
    comboBox.setBackground(Color.WHITE);
    comboBox.insertItemAt("Select", 0);
    comboBox.setSelectedIndex(0);
    
    final JComboBox comboBox_1 = new JComboBox(GetValues.getCategory());
    comboBox_1.setBackground(Color.WHITE);
    comboBox_1.insertItemAt("Select", 0);
    comboBox_1.setSelectedIndex(0);
    
    final JComboBox comboBox_2 = new JComboBox(GetValues.getSubject());
    comboBox_2.setBackground(Color.WHITE);
    comboBox_2.insertItemAt("Select", 0);
    comboBox_2.setSelectedIndex(0);
    
    final JComboBox comboBox_3 = new JComboBox(GetValues.getPublication());
    comboBox_3.setBackground(Color.WHITE);
    comboBox_3.insertItemAt("Select", 0);
    comboBox_3.setSelectedIndex(0);
    
    JLabel lblIsbn = new JLabel("ISBN");
    
    this.textField_2 = new JTextField();
    textField_2.setBackground(Color.WHITE);
    this.textField_2.setColumns(10);
    
    JLabel lblEddition = new JLabel("Eddition");
    
    JLabel lblPrice = new JLabel("Price");
    
    JLabel lblQuantity = new JLabel("Quantity");
    
    this.textField_3 = new JTextField();
    textField_3.setBackground(Color.WHITE);
    this.textField_3.setColumns(10);
    
    this.textField_4 = new JTextField();
    textField_4.setBackground(Color.WHITE);
    this.textField_4.setColumns(10);
    
    this.textField_5 = new JTextField();
    textField_5.setBackground(Color.WHITE);
    this.textField_5.setColumns(10);
    
    JButton btnNewButton = new JButton("SAVE");
    btnNewButton.setBackground(Color.WHITE);
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String id = Addnewbook.this.textField.getText();
        String title = Addnewbook.this.textField_1.getText();
        String author = (String)comboBox.getSelectedItem();
        String category = (String)comboBox_1.getSelectedItem();
        String subject = (String)comboBox_2.getSelectedItem();
        String publication = (String)comboBox_3.getSelectedItem();
        String isbn = Addnewbook.this.textField_2.getText();
        String eddition = Addnewbook.this.textField_3.getText();
        String price = Addnewbook.this.textField_4.getText();
        String quantity = Addnewbook.this.textField_5.getText();
        String issued = Addnewbook.this.textField_6.getText();
        
        if ((id.length() == 0) || (title.length() == 0) || (author.length() == 0) || (subject.length() == 0) || (publication.length() == 0) || (category.length() == 0) || (isbn.length() == 0) || (eddition.length() == 0) || (price.length() == 0) || (quantity.length() == 0) || (issued.length() == 0))
        {
          JOptionPane.showMessageDialog(Addnewbook.this.getParent(), "pls fill all the entries", "error", 0);
          Addnewbook.this.textField.setText(null);
          Addnewbook.this.textField.setText(Addnewbook.this._getID());
          Addnewbook.this.textField_1.setText(null);
          Addnewbook.this.textField_2.setText(null);
          Addnewbook.this.textField_3.setText(null);
          Addnewbook.this.textField_4.setText(null);
          Addnewbook.this.textField_5.setText(null);
          Addnewbook.this.textField_6.setText(null);
          comboBox.setSelectedIndex(0);
          comboBox_1.setSelectedIndex(0);
          comboBox_2.setSelectedIndex(0);
          comboBox_3.setSelectedIndex(0);
        }
        else
        {
          String query = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
          
          Connection con = DBInfo1.con;
          int flag = 0;
          try
          {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, category);
            ps.setString(5, subject);
            ps.setString(6, publication);
            ps.setString(7, isbn);
            ps.setString(8, eddition);
            ps.setString(9, price);
            ps.setString(10, quantity);
            ps.setString(11, issued);
            
            flag = ps.executeUpdate();
          }
          catch (Exception e1)
          {
            e1.printStackTrace();
          }
          if (flag == 1)
          {
            JOptionPane.showMessageDialog(Addnewbook.this.getParent(), "book added", "success", 1);
            Addnewbook.this.textField.setText(null);
            Addnewbook.this.textField.setText(Addnewbook.this._getID());
            Addnewbook.this.textField_1.setText(null);
            Addnewbook.this.textField_2.setText(null);
            Addnewbook.this.textField_3.setText(null);
            Addnewbook.this.textField_4.setText(null);
            Addnewbook.this.textField_5.setText(null);
            Addnewbook.this.textField_6.setText(null);
            comboBox.setSelectedIndex(0);
            comboBox_1.setSelectedIndex(0);
            comboBox_2.setSelectedIndex(0);
            comboBox_3.setSelectedIndex(0);
            JOptionPane.showMessageDialog(Addnewbook.this.getParent(), "add another book");
          }
          if (flag == 0) {
            JOptionPane.showMessageDialog(Addnewbook.this.getParent(), "book not added", "error", 1);
          }
          if ((id.length() == 0) || (title.length() == 0) || (author.length() == 0) || (subject.length() == 0) || (publication.length() == 0) || (category.length() == 0) || (isbn.length() == 0) || (eddition.length() == 0) || (price.length() == 0) || (quantity.length() == 0) || (issued.length() == 0))
          {
            JOptionPane.showMessageDialog(Addnewbook.this.getParent(), "pls fill all the entries", "error", 0);
            Addnewbook.this.textField.setText(null);
            Addnewbook.this.textField.setText(Addnewbook.this._getID());
            Addnewbook.this.textField_1.setText(null);
            Addnewbook.this.textField_2.setText(null);
            Addnewbook.this.textField_3.setText(null);
            Addnewbook.this.textField_4.setText(null);
            Addnewbook.this.textField_5.setText(null);
            Addnewbook.this.textField_6.setText(null);
            comboBox.setSelectedIndex(0);
            comboBox_1.setSelectedIndex(0);
            comboBox_2.setSelectedIndex(0);
            comboBox_3.setSelectedIndex(0);
          }
        }
      }
    });
    JButton btnReset = new JButton("RESET");
    btnReset.setBackground(Color.WHITE);
    btnReset.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e5)
      {
        Addnewbook.this.textField.setText(null);
        Addnewbook.this.textField.setText(Addnewbook.this._getID());
        Addnewbook.this.textField_1.setText(null);
        Addnewbook.this.textField_2.setText(null);
        Addnewbook.this.textField_3.setText(null);
        Addnewbook.this.textField_4.setText(null);
        Addnewbook.this.textField_5.setText(null);
        Addnewbook.this.textField_6.setText(null);
        comboBox.setSelectedIndex(0);
        comboBox_1.setSelectedIndex(0);
        comboBox_2.setSelectedIndex(0);
        comboBox_3.setSelectedIndex(0);
      }
    });
    
    JLabel lblIssued = new JLabel("Issued");
    
    textField_6 = new JTextField();
    textField_6.setBackground(Color.WHITE);
    textField_6.setColumns(10);
    
    JButton btnBack = new JButton("BACK");
    btnBack.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		AdminSection a = new AdminSection("Admin Section");
            a.setVisible(true);
           dispose();
    	}
    });
    btnBack.setBackground(Color.WHITE);
    GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
    gl_contentPane.setHorizontalGroup(
    	gl_contentPane.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(115)
    			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
    			.addGap(65)
    			.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
    			.addGap(54)
    			.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
    			.addGap(208))
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addGap(84)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    				.addComponent(lblBookId, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblIssued, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblEddition, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblPublication, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblSubject, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
    			.addGap(95)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
    				.addGroup(gl_contentPane.createSequentialGroup()
    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
    						.addComponent(textField_5, Alignment.LEADING)
    						.addComponent(textField_4, Alignment.LEADING)
    						.addComponent(textField_3, Alignment.LEADING)
    						.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
    						.addComponent(textField_6))
    					.addContainerGap())
    				.addGroup(gl_contentPane.createSequentialGroup()
    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
    						.addComponent(textField, Alignment.LEADING)
    						.addComponent(comboBox_3, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(comboBox_2, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    						.addComponent(textField_1, Alignment.LEADING, 236, 236, Short.MAX_VALUE))
    					.addContainerGap(231, Short.MAX_VALUE))))
    );
    gl_contentPane.setVerticalGroup(
    	gl_contentPane.createParallelGroup(Alignment.TRAILING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addContainerGap(33, Short.MAX_VALUE)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblBookId)
    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblTitle)
    				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblAuthor)
    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
    			.addGap(23)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblCategory)
    				.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
    			.addGap(18)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblSubject)
    				.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
    			.addGap(20)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblPublication)
    				.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
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
    				.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    			.addGap(33)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
    				.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
    				.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
    			.addGap(55))
    );
    
    this.contentPane.setLayout(gl_contentPane);
  }
}

