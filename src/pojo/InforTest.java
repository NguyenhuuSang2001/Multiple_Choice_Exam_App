/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "infortest")
public class InforTest implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private int id;
    @Column(name = "UserID", nullable=false)
    private int userID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Topic")
    private String topic;
    @Column(name = "Publish")
    private boolean publish;
    @Column(name = "DateCreate")
    private LocalDate dateCreate;
    @ManyToOne(optional=false)
//    @JoinColumn(name = "UserID",insertable="false" updata="false")
     @JoinColumn(name = "UserID", insertable=false, updatable=false)
    private Users users;

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public boolean isPublish() {
        return publish;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
}
