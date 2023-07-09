/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ASUS-PRO
 */
public class Log {

    private int logID, pID, userID;
    private LocalDate bDate, mrDate;
    private String description, status;

    public Log() {
    }

    public Log(int logID, int pID, int userID, LocalDate bDate, LocalDate mrDate, String description, String status) {
        this.logID = logID;
        this.pID = pID;
        this.userID = userID;
        this.bDate = bDate;
        this.mrDate = mrDate;
        this.description = description;
        this.status = status;
    }

    public Log(int pID, int userID, String description, int day, String status) {
        this.pID = pID;
        this.userID = userID;
        bDate = LocalDate.now();
        mrDate = bDate.plusDays(day);
        this.description = description;
        this.status = status;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public LocalDate getMrDate() {
        return mrDate;
    }

    public void setMrDate(LocalDate mrDate) {
        this.mrDate = mrDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
