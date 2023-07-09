/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-PRO
 */
public class Users {

    private int UserID, Phone, Manager_id, Department_ID, Job_id;
    private Date Dob;
    private String FullName, Email, Password, Role, Status, Gender, Address, job, department;

    public Users() {
    }
    
    public Users(int UserID, int Phone, int Manager_id, Date Dob, String FullName, String Email, String Password, String Role, String Status, String Gender, String Address, String job, String department) {
        this.UserID = UserID;
        this.Phone = Phone;
        this.Manager_id = Manager_id;
        this.Dob = Dob;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Role = Role;
        this.Status = Status;
        this.Gender = Gender;
        this.Address = Address;
        this.job = job;
        this.department = department;
    }

    public Users(int UserID, int Phone, int DepartmentID, int Job_id,int Manager_id, String Dob, String FullName, String Email, String Password, String Role, String Status, String Gender, String Address) {
        this.UserID = UserID;
        this.Phone = Phone;
        this.Department_ID = DepartmentID;
        this.Job_id = Job_id;
        setDob(Dob);
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Role = Role;
        this.Status = Status;
        this.Gender = Gender;
        this.Address = Address;
         this.Manager_id = Manager_id;
    }

    
    public Users(int UserID, int Phone, int Manager_id, int DepartmentID, int Job_id, Date Dob, String FullName, String Email, String Password, String Role, String Status, String Gender, String Address, String job, String department) {
        this.UserID = UserID;
        this.Phone = Phone;
        this.Manager_id = Manager_id;
        this.Department_ID = DepartmentID;
        this.Job_id = Job_id;
        this.Dob = Dob;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Role = Role;
        this.Status = Status;
        this.Gender = Gender;
        this.Address = Address;
        this.job = job;
        this.department = department;
    }
    
    public Users(int UserID, int Phone, int Manager_id, int Department_ID, int Job_id, Date Dob, String FullName, String Email, String Password, String Role, String Status, String Gender, String Address) {
        this.UserID = UserID;
        this.Phone = Phone;
        this.Manager_id = Manager_id;
        this.Department_ID = Department_ID;
        this.Job_id = Job_id;
        this.Dob = Dob;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
        this.Role = Role;
        this.Status = Status;
        this.Gender = Gender;
        this.Address = Address;
    }
     public Users(Users u) {
        this(u.UserID, u.Phone, u.Manager_id, u.Department_ID, u.Job_id, u.Dob, u.FullName,u.Email,u.Password,u.Role,u.Status,u.Gender, u.Address);
    }
     public Users(int uid) {
        this(UsersDB.getID(uid));
    }
    public int getUserID() {
        return UserID;
    }
    
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    public int getPhone() {
        return Phone;
    }
    
    public void setPhone(int Phone) {
        this.Phone = Phone;
    }
    
    public int getManager_id() {
        return Manager_id;
    }
    
    public void setManager_id(int Manager_id) {
        this.Manager_id = Manager_id;
    }
    
    public int getDepartment_ID() {
        return Department_ID;
    }
    
    public void setDepartment_ID(int Department_ID) {
        this.Department_ID = Department_ID;
    }

    public int getJob_id() {
        return Job_id;
    }

    public void setJob_id(int Job_id) {
        this.Job_id = Job_id;
    }
 
    public String getDob() {
       SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-d");
        return sd.format(Dob);
    }
    
    public Date getDateOB() {
        return Dob;
    }
    public void setDob(String Dob) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.Dob = new java.sql.Date(sd.parse(Dob).getTime());
        } catch (Exception ex) {
            Logger.getLogger(UsersDB.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Invalid DOB");
        }
    }
    
    public String getFullName() {
        return FullName;
    }
    
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getRole() {
        return Role;
    }
    
    public void setRole(String Role) {
        this.Role = Role;
    }
    
    public String getStatus() {
        return Status;
    }
    
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String getGender() {
        return Gender;
    }
    
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
     public Users update() {
        return  UsersDB.update(this);
    }
   
}
