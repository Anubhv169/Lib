import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class FacultySection
  extends JFrame
{
  public FacultySection(String title)
  {
    super(title);
    getContentPane().setBackground(Color.YELLOW);
    setSize(514, 239);
    setLocationRelativeTo(this);
    getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
    
    JButton btnViewAllBook = new JButton("View all book");
    btnViewAllBook.setBackground(new Color(255, 255, 240));
    btnViewAllBook.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        GetValues1.getAllBook();
        
        JFrame obj = new JFrame();
        obj.setSize(700, 500);
        obj.setLocationRelativeTo(FacultySection.this.getParent());
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JTable table = new JTable(GetValues1.records, GetValues1.header);
        JScrollPane pane = new JScrollPane(table);
        obj.getContentPane().add(pane);
        obj.setVisible(true);
      }
    });
    getContentPane().add(btnViewAllBook);
    
    JButton btnViewSelfAccount = new JButton("view all faculty ");
    btnViewSelfAccount.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
GetValues1.getAllInfo();
            
            JFrame obj = new JFrame("All Users");
            obj.setSize(700, 500);
            obj.setLocationRelativeTo(FacultySection.this.getParent());
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            JTable table = new JTable(GetValues1.records, GetValues1.header);
            JScrollPane pane = new JScrollPane(table);
            obj.getContentPane().add(pane);
            obj.setVisible(true);
    	}
    });
    btnViewSelfAccount.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnViewSelfAccount);
    
    JButton btnChangeSelfPassword = new JButton("change self password");
    btnChangeSelfPassword.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		ChangeSelfPass2 c = new ChangeSelfPass2("Change Self Password");
    		c.setVisible(true);
    		 FacultySection.this.dispose();
    	}
    });
    btnChangeSelfPassword.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnChangeSelfPassword);
    
    JButton btnAddANew = new JButton("Submit book");
    btnAddANew.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		SubmitBook2 i = new SubmitBook2("Submit Book");
    		i.setVisible(true);
    		FacultySection.this.dispose();
    	}
    });
    btnAddANew.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnAddANew);
    
    JButton btnNewButton = new JButton("view all registered Users");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
GetValues2.getAllBook();
            
            JFrame obj = new JFrame("All Users");
            obj.setSize(700, 500);
            obj.setLocationRelativeTo(FacultySection.this.getParent());
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            JTable table = new JTable(GetValues2.records, GetValues2.header);
            JScrollPane pane = new JScrollPane(table);
            obj.getContentPane().add(pane);
            obj.setVisible(true);
    	}
    });
    btnNewButton.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnNewButton);
    
    JButton btnRequiredBook = new JButton("Required Book");
    btnRequiredBook.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		RequiredBook r = new RequiredBook("Required Book");
    		r.setVisible(true);
    		FacultySection.this.dispose();
    	}
    });
    btnRequiredBook.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnRequiredBook);
  }
}
