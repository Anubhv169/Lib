

import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GetValues2
{
  public static Vector<String> header;
  public static Vector<Vector<String>> records;
  
  public static void getBook(String str, String value)
  {
    header = new Vector();
    records = new Vector();
    
    String query = "select * from registration where " + str + "=?";
    Connection con = DBInfo1.con;
    try
    {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, value);
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
  }
  
  public static void getAllBook()
  {
    header = new Vector();
    records = new Vector();
    
    String query = "select name,contact,email,uname from registration";
    Connection con = DBInfo1.con;
    try
    {
      PreparedStatement ps = con.prepareStatement(query);
      
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
  }
  
  public static void getAllInfo()
  {
    header = new Vector();
    records = new Vector();
    
    String query = "select name,contact,email from registration where uname=?";
    Connection con = DBInfo1.con;
    try
    {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, "faculty");
      
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
  }
}
