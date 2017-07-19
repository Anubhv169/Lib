

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DemoOfJtable_DB
  extends JFrame
{
  JTable table;
  
  public DemoOfJtable_DB()
  {
    Vector<String> header = new Vector();
    Vector<Vector<String>> records = new Vector();
    
    setSize(800, 500);
    setLocationRelativeTo(this);
    setDefaultCloseOperation(3);
    
    Connection con = DBInfo1.con;
    String str = "select * from book";
    try
    {
      PreparedStatement ps = con.prepareStatement(str);
      ResultSet res = (ResultSet)ps.executeQuery();
      

      ResultSetMetaData rsmd = (ResultSetMetaData)res.getMetaData();
      int count = rsmd.getColumnCount();
      for (int i = 1; i <= count; i++) {
        header.add(rsmd.getColumnName(i));
      }
      while (res.next())
      {
        Vector<String> v = new Vector();
        for (int i = 1; i <= count; i++) {
          v.add(res.getString(i));
        }
        records.add(v);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    this.table = new JTable(records, header);
    
    JScrollPane pane = new JScrollPane(this.table);
    add(pane);
  }
  
  public static void main(String[] args)
  {
    DemoOfJtable_DB g = new DemoOfJtable_DB();
    g.setVisible(true);
  }
}

