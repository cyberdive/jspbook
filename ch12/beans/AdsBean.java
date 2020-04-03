package com.awl.jspbook.ch12;

import java.sql.*;
import java.text.*;

public class AdsBean {
    private String orderBy  = "";
    private Statement st    = null;
    private ResultSet rs;

    private int adid;
    private boolean adidSet;

    public int getAdid() {
        if(rs == null) return 0;
        try {
            return rs.getInt("adid");
        } catch (Exception e) {
        }
        return 0;
    }

    public void setAdid(int adid) {
        this.adid = adid;
        this.adidSet = true;
    }

    private int impressions;
    private boolean impressionsSet;

    public int getImpressions() {
        if(rs == null) return 0;
        try {
            return rs.getInt("impressions");
        } catch (Exception e) {
        }
        return 0;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
        this.impressionsSet = true;
    }

    private int impressionssofar;
    private boolean impressionssofarSet;

    public int getImpressionssofar() {
        if(rs == null) return 0;
        try {
            return rs.getInt("impressionssofar");
        } catch (Exception e) {
        }
        return 0;
    }

    public void setImpressionssofar(int impressionssofar) {
        this.impressionssofar = impressionssofar;
        this.impressionssofarSet = true;
    }

    private String adbody;
    private boolean adbodySet;

    public String getAdbody() {
        if(rs == null) return null;
        try {
            return rs.getString("adbody");
        } catch (Exception e) {
        }
        return null;
    }

    public void setAdbody(String adbody) {
        this.adbody = adbody;
        this.adbodySet = true;
    }

    public void select() {
        try {
            if (rs != null) {rs.close(); rs = null;}
            if (st != null) {st.close(); st = null;}
            Connection tmp = PersistentConnection.getConnection();
            st = tmp.createStatement();
            String query = "SELECT * FROM ads";
            String where = buildWhere();
            rs = st.executeQuery(query + where + " " + orderBy);
            if(rs != null) rs.next();
            adidSet = false;
            impressionsSet = false;
            impressionssofarSet = false;
            adbodySet = false;
        } catch (Exception e) {
        }
    }

    private String buildWhere() {
        StringBuffer where = new StringBuffer(40);
        boolean nonEmpty   = false;

        if(adidSet) {
            if(nonEmpty) where.append(" AND ");
            where.append("adid=");
            where.append(adid);
            nonEmpty = true;
        }
        if(impressionsSet) {
            if(nonEmpty) where.append(" AND ");
            where.append("impressions=");
            where.append(impressions);
            nonEmpty = true;
        }
        if(impressionssofarSet) {
            if(nonEmpty) where.append(" AND ");
            where.append("impressionssofar=");
            where.append(impressionssofar);
            nonEmpty = true;
        }
        if(adbodySet) {
            if(nonEmpty) where.append(" AND ");
            where.append("adbody=");
            where.append("'");
            where.append(adbody);
            where.append("'");
            nonEmpty = true;
        }
        return where.toString();
    }

    private int keyweight[] = new int[0];
    public void setKeyweight(int k[]) {keyweight = k;}

    public void insert() {
        try {
            if (rs != null) {rs.close(); rs = null;}
            if (st != null) {st.close(); st = null;}
            Connection tmp = PersistentConnection.getConnection();
            st = tmp.createStatement();

            StringBuffer query = new StringBuffer(100);
            query.append("INSERT INTO ads(impressions,impressionssofar,adbody) VALUES(");
            query.append(impressions);
            query.append(',');
            query.append(impressionssofar);
            query.append(',');
            query.append("'");
            query.append(adbody);
            query.append("'");
            query.append(")");

            st.execute(query.toString());


	    /* Also save the keywords info */
	    rs = st.executeQuery("select max(adid) from ads");
	    rs.next();
	    int id = rs.getInt("max");

	    for(int i=0;i<keyweight.length;i++) {
	      st.executeUpdate("insert into adkeywords values(" + 
			       id + "," + i + "," + keyweight[i] + ")");
	    }
        } catch (Exception e) {
	  System.err.println("Unable top create ad");
	  e.printStackTrace(System.err);
        }
    }

    public boolean next() {
        if(rs == null) return false;
        try {
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    public void cleanup() {
      try {
	if (rs != null) rs.close();
	if (st != null) st.close();
      } catch (Exception e) {
      }
    }
}
