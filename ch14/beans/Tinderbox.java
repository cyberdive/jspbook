package com.awl.jspbook.ch14;

import java.io.*;

public class Tinderbox implements Serializable {
  private String bgColor    = "#000000";
  private String textColor  = "#ff0000";
  private String name       = "Tinderbox";
  private int year          = 1986;
  private String artist     = "Siouxsie and the Banshees";
  private String tracks[]   = {
    "Candyman",
    "The Sweetest Chill",
    "This Unrest",
    "Cities In Dust",
    "Cannons",
    "Partys Fall",
    "92 Degrees",
    "Lands End",
    "The Quarterdrawing Of The Dog",
    "An Execution",
    "Lullaby",
    "Umbrella",
    "Cities In Dust (Extended Version)"};

  public String getBgColor() {return bgColor;}
  public void setBgColor(String bgColor) {this.bgColor = bgColor;}

  public String getTextColor() {return textColor;}
  public void setTextColor(String textColor) {this.textColor = textColor;}


  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int getYear() {return year;}
  public void setYear(int year) {this.year = year;}

  public String getArtist() {return artist;}
  public void setArtist(String artist) {this.artist = artist;}

  public String[] getTracks() {return tracks;}
  public void setTracks(String tracks[]) {this.tracks = tracks;}

  public static void main(String argv[]) throws Exception {
    Tinderbox a = new Tinderbox();
    a.setBgColor(argv[1]);
    a.setTextColor(argv[2]);
    a.setName(argv[3]);
    a.setYear(Integer.parseInt(argv[4]));
    a.setArtist(argv[5]);

    String tmp[] = new String[argv.length-6];
    for(int i=6;i<argv.length;i++) tmp[i-6] = argv[i];

    a.setTracks(tmp);
    ObjectOutputStream o = new ObjectOutputStream(
			       new FileOutputStream(argv[0]));
    o.writeObject(a);
    o.close();
  }
}
