/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import Respository.QuestionRepository;
import Respository.impl.QuestionRepositoryImpl;
import dao.IQuestion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Answer;
import pojo.Question;
import responsity.ConnectionManager;

/**
 *
 * @author PC
 */
public class IQuestionImpl implements IQuestion{

    @Override
    public Optional<Question> getQuestionById(int questionId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        QuestionRepository qu = new QuestionRepositoryImpl();
        Optional<Question> q = qu.findById(questionId);
        return q;
    }

    public List<Question> getListByUserIDAndTopic(int userID, String topic) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<Question> listQuestions = new ArrayList<>();
        ConnectionManager conn = new ConnectionManager();
            try (Connection connection = conn.getConnection()) {
                String sql = "SELECT * FROM `question` WHERE UserID = "+userID+" and Topic = '"+topic+"';";
                PreparedStatement ps = connection.prepareStatement(sql);
               

                ResultSet rs = ps.executeQuery();
                List<Question> ts = new ArrayList<>();
                while (rs.next()) {
                  //  System.out.println(rs);
                   Question in = new Question(rs.getInt("ID"),
                   rs.getInt("UserID"),
                   rs.getString("Topic"),  
                   rs.getString("Content"));
                    ts.add(in);
                }
               
                return ts;
              
            } catch (SQLException ex) { 
            Logger.getLogger(IinfortestImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
}
