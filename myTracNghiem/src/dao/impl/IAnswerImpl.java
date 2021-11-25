/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IAnswer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Answer;
import pojo.InforTest;
import pojo.Question;
import responsity.ConnectionManager;

/**
 *
 * @author PC
 */
public class IAnswerImpl implements IAnswer{

    @Override
    public List<Answer> getListAnswerByQId(int quID) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<Answer> listAnswers = new ArrayList<>();
        ConnectionManager conn = new ConnectionManager();
            try (Connection connection = conn.getConnection()) {
                String sql = "SELECT * FROM `answer` WHERE QuestionID = "+quID+";";
                PreparedStatement ps = connection.prepareStatement(sql);
               

                ResultSet rs = ps.executeQuery();
                List<Answer> ts = new ArrayList<>();
                while (rs.next()) {
                  //  System.out.println(rs);
                   Answer in = new Answer(rs.getInt("ID"),
                   rs.getInt("QuestionID"),
                   rs.getString("Content"),  
                   rs.getBoolean("IsCorrect"));
                    ts.add(in);
                }
               
                return ts;
              
            } catch (SQLException ex) { 
            Logger.getLogger(IinfortestImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
}
