/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS-PRO
 */
public class Project {
    private String  title, author, category, description,status;
    private int pid,pubYear, quantity, availQtt;

    public Project() {
    }

    public Project(String title, String author, String category, String description, int pid, int pubYear, int quantity, int availQtt, String status) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.pid = pid;
        this.pubYear = pubYear;
        this.quantity = quantity;
        this.availQtt = availQtt;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailQtt() {
        return availQtt;
    }

    public void setAvailQtt(int availQtt) {
        this.availQtt = availQtt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
