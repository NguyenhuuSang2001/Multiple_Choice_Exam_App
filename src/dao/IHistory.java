/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import pojo.History;

/**
 *
 * @author PC
 */
public interface IHistory {
    List<History> getHistoryByUserId(int userID);
    boolean deleteByUserID(int userId);
    boolean saveHistory(int userId,int testId,int point);
}
