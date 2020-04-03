package com.awl.jspbook.ch10;

import java.sql.*;
import java.util.*;

public class PageInfo {
  private int sectionId;
  private int articleId;
  private String sectionName;
  private String sectionDescription;

  public int getSectionId() {return sectionId;}

  public String getSectionName() {return sectionName;}
  public String getSectionDescription() {return sectionDescription;}

  public void setSectionId(int sectionId) {
    this.sectionId     = sectionId;
    sectionName        = SectionHolder.getName(sectionId);
    sectionDescription = SectionHolder.getDescription(sectionId);
  }

  public int getArticleId() {return articleId;}
  public String getArticleIdString() {return "" + articleId;}

  public void setArticleId(int articleId) {
    this.articleId = articleId;
  }
}
