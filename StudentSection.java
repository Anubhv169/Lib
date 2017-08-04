import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class StudentSection
  extends JFrame
{
  public StudentSection(String title)
  {
    super(title);
    setSize(503, 284);
    setLocationRelativeTo(this);
    getContentPane().setLayout(new GridLayout(4, 4, 0, 0));
    
    JButton button = new JButton("View All The Books");
    button.setBackground(new Color(255, 255, 240));
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        GetValues1.getAllBook();
        
        JFrame obj = new JFrame();
        obj.setSize(700, 500);
        obj.setLocationRelativeTo(StudentSection.this.getParent());
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JTable table = new JTable(GetValues1.records, GetValues1.header);
        JScrollPane pane = new JScrollPane(table);
        obj.getContentPane().add(pane);
        obj.setVisible(true);
      }
    });
    getContentPane().add(button);
    
    JButton btnViewAllThe = new JButton("View All Student");
    btnViewAllThe.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
GetValues1.getAllInfo1();
            
            JFrame obj = new JFrame("All Users");
            obj.setSize(700, 500);
            obj.setLocationRelativeTo(StudentSection.this.getParent());
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            JTable table = new JTable(GetValues1.records, GetValues1.header);
            JScrollPane pane = new JScrollPane(table);
            obj.getContentPane().add(pane);
            obj.setVisible(true);
    	}
    });
    btnViewAllThe.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnViewAllThe);
    
    JButton btnChangeSelfPassword = new JButton("Change Self Password");
    btnChangeSelfPassword.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		ChangeSelfPass3 c = new ChangeSelfPass3("Change Self Password");
    		c.setVisible(true);
    		 StudentSection.this.dispose();
    	}
    });
    btnChangeSelfPassword.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnChangeSelfPassword);
    
    JButton btnViewNotice = new JButton("Required Book");
    btnViewNotice.setBackground(new Color(255, 255, 240));
    btnViewNotice.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0) {
    	  RequiredBook2 r = new RequiredBook2("Required Book");
  		r.setVisible(true);
  		 StudentSection.this.dispose();
      }
    });
    getContentPane().add(btnViewNotice);
  }
}
