
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;

public class AdminSection
  extends JFrame
{
  public AdminSection(String title)
  {
    super(title);
    setSize(522, 266);
    setLocationRelativeTo(this);
    setResizable(false);
    getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
    
    JButton button = new JButton("Add new book");
    button.setBackground(new Color(255, 255, 240));
    button.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Addnewbook a = new Addnewbook("Add New Book");
        a.setVisible(true);
        AdminSection.this.dispose();
      }
    });
    getContentPane().add(button);
    
    JButton btnAddNewBook = new JButton("Update/Delete Book");
    btnAddNewBook.setBackground(new Color(255, 255, 240));
    btnAddNewBook.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        Searchbook a = new Searchbook("Update/Delete Book");
        a.setVisible(true);
        AdminSection.this.dispose();
      }
    });
    getContentPane().add(btnAddNewBook);
    
    JButton btnAddNewUser = new JButton("Search Book By");
    btnAddNewUser.setBackground(new Color(255, 255, 240));
    btnAddNewUser.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        SearchBookBy a = new SearchBookBy("Search Book By");
        a.setVisible(true);
        AdminSection.this.dispose();
      }
    });
    getContentPane().add(btnAddNewUser);
    
    JButton btnChangeSelfPassword = new JButton("Add New User");
    btnChangeSelfPassword.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Registration2 b = new Registration2("Registration");
            b.setVisible(true);
            AdminSection.this.dispose();
    	}
    });
    btnChangeSelfPassword.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnChangeSelfPassword);
    
    JButton btnIssueBook = new JButton("Change Self Password");
    btnIssueBook.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		ChangeSelfPass c = new ChangeSelfPass("Change Self Password");
    		c.setVisible(true);
    		 AdminSection.this.dispose();
    	}
    });
    btnIssueBook.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnIssueBook);
    
    JButton btnSubmitBook = new JButton("Issue Book");
    btnSubmitBook.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		IssueBook i = new IssueBook("Issue Book");
    		i.setVisible(true);
    		 AdminSection.this.dispose();
    	}
    });
    btnSubmitBook.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnSubmitBook);
    
    JButton btnAddNewNotice = new JButton("Submit Book");
    btnAddNewNotice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		SubmitBook i = new SubmitBook("Submit Book");
    		i.setVisible(true);
    		 AdminSection.this.dispose();
    	}
    });
    btnAddNewNotice.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnAddNewNotice);
    
    JButton btnAddNewNotice_1 = new JButton("View All The Books");
    btnAddNewNotice_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		GetValues1.getAllBook();
            
            JFrame obj = new JFrame("All Books");
            obj.setSize(700, 500);
            obj.setLocationRelativeTo(AdminSection.this.getParent());
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            JTable table = new JTable(GetValues1.records, GetValues1.header);
            JScrollPane pane = new JScrollPane(table);
            obj.getContentPane().add(pane);
            obj.setVisible(true);
           
    	}
    });
    btnAddNewNotice_1.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnAddNewNotice_1);
    
    JButton btnUpdatedeleteNotice = new JButton("View All The Registered Users");
    btnUpdatedeleteNotice.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		GetValues2.getAllBook();
            
            JFrame obj = new JFrame("All Users");
            obj.setSize(700, 500);
            obj.setLocationRelativeTo(AdminSection.this.getParent());
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            JTable table = new JTable(GetValues2.records, GetValues2.header);
            JScrollPane pane = new JScrollPane(table);
            obj.getContentPane().add(pane);
            obj.setVisible(true);
            
    	}
    });
    btnUpdatedeleteNotice.setBackground(new Color(255, 255, 240));
    getContentPane().add(btnUpdatedeleteNotice);
  }
}

