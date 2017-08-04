
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class SearchBookBy
  extends JFrame
{
  private JPanel contentPane;
  
  
  
  public SearchBookBy(String str)
  {
	  super(str);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 572, 364);
    setLocationRelativeTo(this);
    this.contentPane = new JPanel();
    contentPane.setBackground(new Color(255, 255, 240));
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    
    JLabel label = new JLabel("");
    
    JLabel lblNewLabel = new JLabel("New label");
    
    JLabel lblSearchBookBy = new JLabel("Search Book By");
    
    String[] value = { "select", "Author", "subject", "category", "publication", "All" };
    final JComboBox comboBox = new JComboBox(value);
    comboBox.setBackground(Color.WHITE);
    


    JButton btnNewButton = new JButton("Click To Search");
    btnNewButton.setBackground(Color.WHITE);
    btnNewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        String str = (String)comboBox.getSelectedItem();
        System.out.println(str);
        if (str.equalsIgnoreCase("select"))
        {
          JOptionPane.showMessageDialog(SearchBookBy.this.getParent(), "Select any option", "Error", 0);
        }
        else if (str.equalsIgnoreCase("all"))
        {
          GetValues1.getAllBook();
          
          JFrame obj = new JFrame();
          obj.setSize(700, 500);
          obj.setLocationRelativeTo(SearchBookBy.this.getParent());
          obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
          JTable table = new JTable(GetValues1.records, GetValues1.header);
          JScrollPane pane = new JScrollPane(table);
          obj.getContentPane().add(pane);
          obj.setVisible(true);
        }
        else
        {
          String value = JOptionPane.showInputDialog("Enter" + str + "name");
          System.out.println(value);
          
          GetValues1.getBook(str, value);
          
          JFrame obj = new JFrame();
          obj.setSize(700, 500);
          obj.setLocationRelativeTo(SearchBookBy.this.getParent());
          obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
          JTable table = new JTable(GetValues1.records, GetValues1.header);
          JScrollPane pane = new JScrollPane(table);
          obj.getContentPane().add(pane);
          obj.setVisible(true);
        }
      }
    });
    
    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		 AdminSection a = new AdminSection("Admin Section");
             a.setVisible(true);
            dispose();
    	}
    });
    btnBack.setBackground(Color.WHITE);
    GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
    gl_contentPane.setHorizontalGroup(
    	gl_contentPane.createParallelGroup(Alignment.TRAILING)
    		.addComponent(label, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)
    		.addComponent(lblNewLabel)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
    			.addGap(60)
    			.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
    			.addGap(172))
    		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
    			.addGap(87)
    			.addComponent(lblSearchBookBy)
    			.addGap(77)
    			.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
    			.addContainerGap(132, Short.MAX_VALUE))
    );
    gl_contentPane.setVerticalGroup(
    	gl_contentPane.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_contentPane.createSequentialGroup()
    			.addComponent(label)
    			.addGap(35)
    			.addComponent(lblNewLabel)
    			.addGap(38)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(lblSearchBookBy)
    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
    			.addGap(139)
    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
    				.addComponent(btnBack)
    				.addComponent(btnNewButton))
    			.addGap(38))
    );
    
    this.contentPane.setLayout(gl_contentPane);
  }
}
