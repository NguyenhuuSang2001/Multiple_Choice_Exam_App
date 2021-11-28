/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Answer;
import pojo.History;
import responsity.ConnectionManager;
import java.util.Date;

/**
 *
 * @author PC
 */
public class IHistoryImpl implements IHistory{

    @Override
    public List<History> getHistoryByUserId(int userID) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           List<History> listHistorys= new ArrayList<>();
        ConnectionManager conn = new ConnectionManager();
            try (Connection connection = conn.getConnection()) {
                String sql = "SELECT * FROM `history` WHERE UserID = "+userID+";";
                PreparedStatement ps = connection.prepareStatement(sql);
               

                ResultSet rs = ps.executeQuery();
                List<History> ts = new ArrayList<>();
                while (rs.next()) {
                  //  System.out.println(rs);
                   History in = new History(rs.getInt("ID"),
                   rs.getInt("UserID"),
                   rs.getInt("TestID"), (Date) rs.getObject("DateFinish"),  
                   rs.getFloat("Point"));
                    ts.add(in);
                }
               
                return ts;
              
            } catch (SQLException ex) { 
            Logger.getLogger(IinfortestImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public boolean deleteByUserID(int userId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ConnectionManager conn = new ConnectionManager();
            try (Connection connection = conn.getConnection()) {
                String sql = "DELETE FROM `history` WHERE UserID = "+userId+";";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.execute();
                return true;
              
            } catch (SQLException ex) { 
            Logger.getLogger(IinfortestImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
}
