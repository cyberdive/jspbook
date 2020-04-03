package com.awl.jspbook.ch08;

import java.io.*;
import java.util.*;
import java.text.*;

public class SaveableBean implements Serializable {
  private Date createTime;
  private String message;

  public SaveableBean() {
    setDate(new Date());
  }

  public void setDate(Date createTime) {
    this.createTime = createTime;
  }

  public Date getDate() {return createTime;}

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {return message;}

  public static void main(String argv[]) 
    throws Exception
  {
    if (argv[0].equals("-create")) {
      SaveableBean sb = new SaveableBean();
      sb.setMessage(argv[2]);

      ObjectOutputStream out = new ObjectOutputStream(
				   new FileOutputStream(argv[1]));
      out.writeObject(sb);
      out.close();
      System.out.println("Bean created and saved!");
    } else if (argv[0].equals("-load")) {
      ObjectInputStream in = new ObjectInputStream(
				   new FileInputStream(argv[1]));
      SaveableBean sb = (SaveableBean) in.readObject();
      in.close();

      SimpleDateFormat sdf = 
	new SimpleDateFormat("hh:mm:ss dd/MM/yy");

      System.out.println("This bean was created at: " +
			 sdf.format(sb.getDate()));

      System.out.println("This bean says: " +
			 sb.getMessage());
    }
  }
}
