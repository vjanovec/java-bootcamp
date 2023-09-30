/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vojtechjanovec.festival;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public final class sqldriver {

    private static sqldriver INSTANCE = null;
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    private String USER = "root";
    private String PASS = "root";
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
            this.conn = DriverManager.getConnection(DB_URL + db, USER, PASS);
        }
        return this.conn;

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
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }

        preparedStatement.close();
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

    public ResultSet querySelect (String query) throws SQLException {


        PreparedStatement ps = getConn().prepareStatement(query);

        // Execute SQL.
        ResultSet rs = ps.executeQuery(query);
        ps.close();
        // ERROR
        return null;
    }

    public int queryUpdateInsert (String query) throws SQLException {
        int count=0;

        PreparedStatement ps = getConn().prepareStatement(query);

        // Execute SQL.
        return count;

    }
}
/*
1) SQL driver - sigleton
2) metody: query
 PreparedStatement ps = getConn().prepareStatement(query);

3) otestovat:
insert - vložit hodnoty
select - vložilo se?
udpate
kontrolní select
delete
kontrolní select
*/
