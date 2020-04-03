package com.awl.jspbook.ch12;

import java.sql.*;
import java.util.*;

public class AdHolder {
  private static int    ids[];
  private static String texts[];
  private static int    impressions[];
  private static int    counts[];
  private static int    keywords[][];

  public AdHolder() {
    try {
      Connection tmp = PersistentConnection.getConnection();

      Statement st   = tmp.createStatement();
      ResultSet rs   = st.executeQuery("SELECT * FROM ads");

      Vector idsV         = new Vector();
      Vector textsV       = new Vector();
      Vector impressionsV = new Vector();
      Vector countsV      = new Vector();

      while(rs.next()) {
	idsV.addElement(new Integer(rs.getInt("adid")));
	textsV.addElement(rs.getString("adbody"));
	impressionsV.addElement(new Integer(rs.getInt("impressions")));
	countsV.addElement(new Integer(rs.getInt("impressionssofar")));
      }
      rs.close();

      ids         = new int[idsV.size()];
      texts       = new String[idsV.size()];
      impressions = new int[idsV.size()];
      counts      = new int[idsV.size()];

      for(int i=0;i<idsV.size();i++) {
	ids[i]         = ((Integer) idsV.elementAt(i)).intValue();
	texts[i]       = (String) textsV.elementAt(i);
	impressions[i] = ((Integer) impressionsV.elementAt(i)).intValue();
	counts[i]      = ((Integer) countsV.elementAt(i)).intValue();
      }

      /* Now populate the keyword tables. */
      keywords = new int[ids.length+1][];    

      rs = st.executeQuery("select max(keywordid) from keywords");
      rs.next();
      int max = rs.getInt("max");
      rs.close();

      for(int i=0;i<ids.length+1;i++) {
	keywords[i] = new int[max+1];
	for(int j=0;j<max;j++) keywords[i][j] = 0;
      }


      rs = st.executeQuery("select * from adkeywords");
      while(rs.next()) {
	keywords[rs.getInt("adid")][rs.getInt("keywordid")] = 
	  rs.getInt("score");
      }

      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public static void adShown(int adid) {
    try {
      counts[adid]++;
    } catch (ArrayIndexOutOfBoundsException e) {
    }
  }

  public static String getAdText(int adid) {
    try {
      return texts[adid];
    } catch (ArrayIndexOutOfBoundsException e) {
    }

    return "default Ad";
  }

  public static int[][] getKeywords() {return keywords;}
}
