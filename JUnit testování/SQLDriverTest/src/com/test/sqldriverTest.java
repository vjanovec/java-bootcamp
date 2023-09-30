package com.test;

import com.vojtechjanovec.sqldriver;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;

public class sqldriverTest {

    sqldriver DB;
    PreparedStatement ps;

    @Before
    public void setUp() throws Exception {
         DB = sqldriver.getInstance();
         String query = "CREATE SCHEMA test; USE test;";
         ps = DB.prepareStatement(query);
         DB.
         ResultSet rs = ps.executeQuery(query);
    }

    @org.junit.Test
    public void getInstance() {
        try {
            assertNotNull(sqldriver.getInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @org.junit.Test
    public void update() {

    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void insert() {
    }

    @org.junit.Test
    public void singleSelect() {
    }

    @org.junit.Test
    public void singleSelect1() {
    }

    @org.junit.Test
    public void singleSelectAll() {
    }

    @org.junit.Test
    public void singleSelect2() {
    }

    @org.junit.Test
    public void singleSelect3() {
    }

    @org.junit.Test
    public void escapeString() {
    }

    @org.junit.Test
    public void singleSelectQ() {
    }

    @org.junit.Test
    public void singleSelectQ1() {
    }

    @org.junit.Test
    public void querySelect() {
    }
}