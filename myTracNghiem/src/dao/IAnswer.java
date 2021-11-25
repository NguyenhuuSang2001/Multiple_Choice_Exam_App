/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import pojo.Answer;

/**
 *
 * @author PC
 */
public interface IAnswer {
    List<Answer> getListAnswerByQId(int quID);
}
