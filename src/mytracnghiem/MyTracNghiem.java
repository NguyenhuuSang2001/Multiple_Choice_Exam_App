/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytracnghiem;

import java.util.List;
import model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.Users;

/**
 *
 * @author PC
 */
public class MyTracNghiem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // TODO code application logic here
            try(Session session = HibernateUtil.getSessionFactory().openSession()){ 
            Query<Users> query = session.createQuery("from Users");//là cái lớp
            List<Users> casts = query.list();
            casts.forEach(c->{
                System.out.println(c.getName());
            });}
            catch(Exception e){
                System.out.println(e.getMessage());
            }
         //là cái lớp
    }
}
