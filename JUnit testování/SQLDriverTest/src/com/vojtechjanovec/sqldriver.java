/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vojtechjanovec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class sqldriver {

    private static sqldriver INSTANCE = null;
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    private String USER = "root";
    private String PASS = "1111";
    private String db = "";
    private Connection conn = null;
    private Statement stmt = null;

    private sqldriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public static sqldriver getInstance() throws ClassNotFoundException {
        if (INSTANCE == null) {
            synchronized (sqldriver.class) {
                if (INSTANCE == null) {
                    INSTANCE = new sqldriver();
                }
            }
        }

        return INSTANCE;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    private Connection getConn() throws SQLException {

        if (this.conn == null) {
            //https://stackoverflow.com/questions/3275524/java-mysql-utf8-problem
            this.conn = DriverManager.getConnection(DB_URL + db + "?useUnicode=true&characterEncoding=utf-8", USER, PASS);
        }
        return this.conn;

    }

    public int update(String table, ArrayList<ArrayList<String>> params, String where) throws SQLException {

        if (table == null) {
            return 0;
        }

        if (params == null) {
            return 0;
        }

        int i = 0;
        String sql = "UPDATE " + this.escapeString(table, false) + " SET ";

        for (ArrayList<String> s : params) {
            i++;
            sql += s.get(0) + "= ?, ";

        }
        sql = sql.substring(0, sql.length() - 1);
        if (where != null) {
            sql += " where " + where;
        }
        PreparedStatement preparedStatement = getConn().prepareStatement(sql);
        i = 1;
        for (ArrayList<String> s : params) {

            preparedStatement.setString(i, s.get(1));
            i++;

        }

        return preparedStatement.executeUpdate();

    }

    public void delete(String table, String where) throws SQLException {
        if (where != null) {
            return;
        }
        String query = ("DELETE FROM " + this.escapeString(table, false) + " where " + where);

        PreparedStatement ps = getConn().prepareStatement(query);

        // Execute SQL.
        ResultSet rs = ps.executeQuery(query);
        ps.close();
    }

    private int insertExecute(String table, ArrayList<ArrayList<String>> params) throws SQLException {
        int i = 0;
        String sql = "INSERT INTO " + table + " (";

        for (ArrayList<String> s : params) {
            i++;
            sql += s.get(0) + ",";

        }
        sql = sql.substring(0, sql.length() - 1) + ") values(";

        for (int x = 0; x < i; x++) {
            sql += "?,";
        }
        sql = sql.substring(0, sql.length() - 1) + ")";
        PreparedStatement preparedStatement = getConn().prepareStatement(sql);
        i = 1;
        for (ArrayList<String> s : params) {

            preparedStatement.setString(i, s.get(1));
            i++;

        }
        //https://stackoverflow.com/questions/5513180/java-preparedstatement-retrieving-last-inserted-id    
        preparedStatement.executeUpdate();
        int id = 0;
        /*
         ResultSet rs = preparedStatement.getGeneratedKeys();
         if (rs.next()) {
         id = rs.getInt(1);
         }

         preparedStatement.close();*/
        return id;
    }

    public int insert(String table, ArrayList<ArrayList<String>> params) {

        try {

            return this.insertExecute(table, params);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<ArrayList<Object>> singleSelect(String table, ArrayList<String> columns, String where,
            String groupby, ArrayList<ArrayList<String>> order, ArrayList<Integer> limit) throws SQLException {
        ArrayList<ArrayList<Object>> res = new ArrayList<>();  
        String sql = "SELECT ";

        if (columns == null) {
            sql += " * ";
        } else {
            for (String s : columns) {

                sql += s + ",";

            }
            sql = sql.substring(0, sql.length() - 1);
        }
        sql += "FROM " + this.escapeString(table, false);
        if (groupby != null) {
            sql += " GROUP BY " + groupby;
        }
        if (order != null) {
            sql += " ORDER BY ";
        
            for (ArrayList<String> s : order) {

                sql += s.get(0) + " " + s.get(1);

            }
        }

        if (limit != null) {
            sql += " limit " + limit.get(0) + ", " + limit.get(1);
        }
             PreparedStatement ps = getConn().prepareStatement(sql);

        // Execute SQL.
        ResultSet rs = ps.executeQuery(sql);

        int cc = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            ArrayList<Object> tmp = new ArrayList<>();
            for (int i = 1; i <= cc; i++) {
                tmp.add(rs.getObject(i));
            }
            res.add(tmp);
            tmp = null;
        }

        return res;
    }

    public ArrayList<ArrayList<Object>> singleSelect(String table, ArrayList<String> columns, String where) throws SQLException {

        
        return this.singleSelect(table, columns, where, null, null, new ArrayList(0));
    }
    
    public ArrayList<ArrayList<Object>> singleSelectAll(String table, String where) throws SQLException {

        
        return this.singleSelect(table, null, where, null, null, null);
    }

    public ArrayList<ArrayList<Object>> singleSelect(String table, ArrayList<String> columns) throws SQLException {
        return this.singleSelect(table, columns, null, null, null, new ArrayList(0));
    }

    public ArrayList<ArrayList<Object>> singleSelect(String table) throws SQLException, SQLException, SQLException {

        ArrayList<String> s = new ArrayList<String>();
        s.add(" * ");
        return this.singleSelect(table, s, null, null, null, new ArrayList(0));

    }

    public String escapeString(String x, boolean escapeDoubleQuotes) {
        StringBuilder sBuilder = new StringBuilder(x.length() * 11 / 10);

        int stringLength = x.length();

        for (int i = 0; i < stringLength; ++i) {
            char c = x.charAt(i);

            switch (c) {
                case 0: /* Must be escaped for 'mysql' */

                    sBuilder.append('\\');
                    sBuilder.append('0');

                    break;

                case '\n': /* Must be escaped for logs */

                    sBuilder.append('\\');
                    sBuilder.append('n');

                    break;

                case '\r':
                    sBuilder.append('\\');
                    sBuilder.append('r');

                    break;

                case '\\':
                    sBuilder.append('\\');
                    sBuilder.append('\\');

                    break;

                case '\'':
                    sBuilder.append('\\');
                    sBuilder.append('\'');

                    break;

                case '"': /* Better safe than sorry */

                    if (escapeDoubleQuotes) {
                        sBuilder.append('\\');
                    }

                    sBuilder.append('"');

                    break;

                case '\032': /* This gives problems on Win32 */

                    sBuilder.append('\\');
                    sBuilder.append('Z');

                    break;

                case '\u00a5':
                case '\u20a9':
                // escape characters interpreted as backslash by mysql
                // fall through

                default:
                    sBuilder.append(c);
            }
        }

        return sBuilder.toString();
    }

    public ArrayList<ArrayList<Object>> singleSelectQ(String table) throws SQLException {
        ArrayList<ArrayList<Object>> res = new ArrayList<>();
        String query = ("SELECT * FROM " + this.escapeString(table, false));

        PreparedStatement ps = getConn().prepareStatement(query);

        // Execute SQL.
        ResultSet rs = ps.executeQuery(query);

        int cc = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            ArrayList<Object> tmp = new ArrayList<>();
            for (int i = 1; i <= cc; i++) {
                tmp.add(rs.getObject(i));
            }
            res.add(tmp);
            tmp = null;
        }

        return res;

    }
    
    public ArrayList<ArrayList<Object>> singleSelectQ(String table,String where) throws SQLException {
        ArrayList<ArrayList<Object>> res = new ArrayList<>();
        String query = "SELECT * FROM " + this.escapeString(table, false)+" where "+where;

        PreparedStatement ps = getConn().prepareStatement(query);

        // Execute SQL.
        ResultSet rs = ps.executeQuery(query);

        int cc = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            ArrayList<Object> tmp = new ArrayList<>();
            for (int i = 1; i <= cc; i++) {
                tmp.add(rs.getObject(i));
            }
            res.add(tmp);
            tmp = null;
        }

        return res;

    }

    public ResultSet querySelect (String query) throws SQLException {
    

        PreparedStatement ps = getConn().prepareStatement(query);
        
        // Execute SQL.
        ResultSet rs = ps.executeQuery(query);
        ps.close();

        // ERROR
        return null;
    }
}
