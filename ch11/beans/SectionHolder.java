package com.awl.jspbook.ch11;

import java.sql.*;
import java.util.*;

public class SectionHolder {
  private static String names[];
  private static int    ids[];
  private static String descriptions[];

  public static String[] getNames() {return names;}
  public static String[] descriptions() {return descriptions;}
  public static int[] getIds() {return ids;}

  public static String getName(int id) {
    for(int i=0;i<ids.length;i++)
      if(ids[i] == id) return names[i];
    return null;
  }

  public static String getDescription(int id) {
    for(int i=0;i<ids.length;i++)
      if(ids[i] == id) return descriptions[i];
    return null;
  }

  public SectionHolder() {
    try {
      Connection tmp = PersistentConnection.getConnection();

      Statement st   = tmp.createStatement();
      ResultSet rs   = st.executeQuery("SELECT * FROM Sections");

      Vector namesV = new Vector();
      Vector idsV   = new Vector();
      Vector descV  = new Vector();

      while(rs.next()) {
	namesV.addElement(rs.getString("name"));
	descV.addElement(rs.getString("description"));
	idsV.addElement(new Integer(rs.getInt("sectionId")));
      }
      rs.close();
      st.close();

      names = new String[namesV.size()];
      descriptions = new String[namesV.size()];
      ids   = new int[namesV.size()];
    
      for(int i=0;i<namesV.size();i++) {
	names[i]        = (String) namesV.elementAt(i);
	descriptions[i] = (String) descV.elementAt(i);
	ids[i]          = ((Integer) idsV.elementAt(i)).intValue();
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
}
