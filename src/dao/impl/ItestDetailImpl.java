/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.ItestDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.InforTest;
import pojo.TestDetail;
import responsity.ConnectionManager;

/**
 *
 * @author PC
 */
public class ItestDetailImpl implements ItestDetail{


    public List<TestDetail> getByTestId(int testId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          List<TestDetail> listTestDetail = new ArrayList<>();
        ConnectionManager conn = new ConnectionManager();
            try (Connection connection = conn.getConnection()) {
                String sql = "SELECT * FROM `testdetail` WHERE TestID = "+testId+";";
                PreparedStatement ps = connection.prepareStatement(sql);
               

                ResultSet rs = ps.executeQuery();
                List<TestDetail> ts = new ArrayList<>();
                while (rs.next()) {
                  //  System.out.println(rs);
                   TestDetail in = new TestDetail(rs.getInt("TestID"),
                   rs.getInt("QuestionID"));
                    ts.add(in);
                }
               
                return ts;
              
            } catch (SQLException ex) { 
            Logger.getLogger(IinfortestImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
}
