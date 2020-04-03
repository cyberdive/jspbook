package com.awl.jspbook.ch11;

import java.sql.*;

public class PersistentConnection {
  private static Connection theConnection;
  private static String url;
  private static boolean valid = false;

  public static Connection getConnection() {return theConnection;}

  private static String dbUserName;
  public String getDbUserName() {return dbUserName;}
  public void setDbUserName(String name) {dbUserName = name;}

  private static String dbPassword;
  public String getDbPassword() {return dbPassword;} 
  public void setDbPassword(String password) {dbPassword = password;}

  public void setDbClass(String dbClass) {
    try {
      Class.forName(dbClass);
    } catch (Exception e) {
      System.err.println("Error loading class");
      e.printStackTrace(System.err);
    }
  }

  public void setUrl(String url) {
    try {
      this.url      = url;
      theConnection = DriverManager.getConnection (url,dbUserName,dbPassword);
      valid         = true;
    } catch (Exception e) {
      System.err.println("Error setting DBUrl");
      e.printStackTrace(System.err);
    }
  }

  public void shutDown() {
    try {
      theConnection.close();
    } catch (Exception e) {}
  }

  public static void reset() {
    try {
      theConnection.close();
      theConnection = DriverManager.getConnection (url,dbUserName,dbPassword);
      valid         = true;
    } catch (Exception e) {
      System.err.println("Unable to reset connection");
      e.printStackTrace();
    }
  }

  public boolean isValid() {return valid;}
}
