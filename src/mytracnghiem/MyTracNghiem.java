/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytracnghiem;

import Respository.UserRepository;
import Respository.impl.UserRepositoryImpl;
import com.laptrinhjavaweb.dao.IUserDAO;
import dao.IAnswer;
import dao.IHistory;
import dao.IInfortest;
import dao.IQuestion;
import dao.ItestDetail;
import dao.impl.IAnswerImpl;
import dao.impl.IHistoryImpl;
import dao.impl.IQuestionImpl;
import dao.impl.IinfortestImpl;
import dao.impl.ItestDetailImpl;
import dao.impl.UserDao;
import pojo.Users;
import responsity.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.eclipse.persistence.jpa.jpql.tools.model.IPropertyChangeEvent;
import pojo.Answer;
import pojo.History;
import pojo.InforTest;
import pojo.Question;
import pojo.TestDetail;


/**
 *
 * @author PC
 */
public class MyTracNghiem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IQuestion iq = new IQuestionImpl();
       // Optional<Question> p = iq.getQuestionById(1);
      //  System.out.println(p.get());
       /* IHistory i = new IHistoryImpl();
        List<History> l = i.getHistoryByUserId(1);
        for(History a:l){
            System.out.println(a.getId());
        }*/
       //IInfortest i = new IinfortestImpl();
     /*  InforTest p =new InforTest();
       p = i.getInforTestByTestID(1);
        System.out.println(p.getName()+" "+p.getId()+" "+p.getTopic()+" "+p.getUserID()+" "+p.getDateCreate());
*/
    // int k = i.saveInforTest(4, "Tiếng Nhật kt", "Tiếng Nhật", true);
      //  System.out.println(k);
    /*  List<Question> listQ = iq.getListByUserIDAndTopic(1, "Toan");
      for(Question Q:listQ){
          System.out.println(Q.getContent());
      }*/
    int k =iq.saveQuestion(3,"Toán", "3+4");
        System.out.println(k);
}
}
