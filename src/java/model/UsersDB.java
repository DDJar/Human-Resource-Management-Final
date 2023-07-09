/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

/**
 *
 * @author ASUS-PRO
 */
public class UsersDB {

    public static Users addNew(Users u) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "Insert into Users(FullName,Dob,Gender,Phone,Job_id,Address,Email,Password,Status,Role,Manager_id,DepartmentID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getFullName());
            stmt.setDate(2, u.getDateOB());
            stmt.setString(3, u.getGender());
            stmt.setInt(4, u.getPhone());
            stmt.setInt(5, u.getJob_id());
            stmt.setString(6, u.getAddress());
            stmt.setString(7, u.getEmail());
            stmt.setString(8, u.getPassword());
            stmt.setString(9, u.getStatus());
            stmt.setString(10, u.getRole());
            stmt.setInt(11, u.getManager_id());
            stmt.setInt(12, u.getDepartment_ID());
            stmt.executeUpdate();
            con.close();
            return u;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static Users checkLogin(String email, String pass) {
        Users list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select Users.UserID,Users.Dob,Users.FullName,Users.Gender,Users.Phone,Users.Address,Users.Job_id,"
                    + "Users.Email,Users.Password,Users.Status,Users.Role,Users.Manager_id, "
                    + "Users.DepartmentID,Job.Job_title AS Job,department.Name AS Department\n"
                    + "FROM Users \n"
                    + "INNER JOIN department\n"
                    + "ON Users.DepartmentID = department.id \n"
                    + "INNER JOIN Job\n"
                    + "ON Job.Job_id = Users.Job_id where Users.Email=? and Users.Password=?\n"
                    + "order by UserID ");
            stmt.setString(1, email);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                Date dob = rs.getDate(2);
                String name = rs.getString(3);
                String gender = rs.getString(4);
                int phone = rs.getInt(5);
                String address = rs.getString(6);
                int jobid = rs.getInt(7);
                String mail = rs.getString(8);
                String pw = rs.getString(9);
                String status = rs.getString(10);
                String role = rs.getString(11);
                int maid = rs.getInt(12);
                int depid = rs.getInt(13);
                String job = rs.getString(14);
                String dename = rs.getString(15);
                list = new Users(bid, phone, maid, depid, jobid, dob, name, email, pass, role, status, gender, address, job, dename);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static Users getID(int uid) {
        Users list = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select UserID,FullName,Dob,"
                    + "Gender,Phone,Job_id,Address,Email,Password,"
                    + "Status,Role,Manager_id,DepartmentID from Users where UserID=? ");
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                Date dob = rs.getDate(3);
                String name = rs.getString(2);
                String gender = rs.getString(4);
                int phone = rs.getInt(5);
                String address = rs.getString(7);
                String mail = rs.getString(8);
                String pw = rs.getString(9);
                String status = rs.getString(10);
                String role = rs.getString(11);
                int maid = rs.getInt(12);
                int jobid = rs.getInt(6);
                int did = rs.getInt(13);
                list = new Users(bid, phone, maid, did, jobid, dob, name, mail, pw, role, status, gender, address);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static boolean checkEmail(String email) {
        Users list = null;
        int affected_rows = 0;
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select UserID,FullName,Dob,"
                    + "Gender,Phone,Job_id,Address,Email,Password,"
                    + "Status,Role,Manager_id,DepartmentID from Users where Email=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                Date dob = rs.getDate(3);
                String name = rs.getString(2);
                String gender = rs.getString(4);
                int phone = rs.getInt(5);
                String address = rs.getString(7);
                String mail = rs.getString(8);
                String pw = rs.getString(9);
                String status = rs.getString(10);
                String role = rs.getString(11);
                int maid = rs.getInt(12);
                int jobid = rs.getInt(6);
                int did = rs.getInt(13);
                list = new Users(bid, phone, maid, did, jobid, dob, name, mail, pw, role, status, gender, address);
                affected_rows++;
            }
            con.close();
            if (affected_rows == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static ArrayList<Users> getIDJ(int jid) {
       ArrayList<Users> list = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select UserID,FullName,Dob,"
                    + "Gender,Phone,Job_id,Address,Email,Password,"
                    + "Status,Role,Manager_id,DepartmentID from Users where Job_id=?");
            stmt.setInt(1, jid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                Date dob = rs.getDate(3);
                String name = rs.getString(2);
                String gender = rs.getString(4);
                int phone = rs.getInt(5);
                String address = rs.getString(7);
                String mail = rs.getString(8);
                String pw = rs.getString(9);
                String status = rs.getString(10);
                String role = rs.getString(11);
                int maid = rs.getInt(12);
                int jobid = rs.getInt(6);
                int did = rs.getInt(13);
                list.add(new Users(bid, phone, maid, did, jobid, dob, name, mail, pw, role, status, gender, address));
            }
            con.close();
              return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static ArrayList<Users> getIDDep(int did) {
        ArrayList<Users> list = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select UserID,FullName,Dob,"
                    + "Gender,Phone,Job_id,Address,Email,Password,"
                    + "Status,Role,Manager_id,DepartmentID from Users where DepartmentID=?");
            stmt.setInt(1, did);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                Date dob = rs.getDate(3);
                String name = rs.getString(2);
                String gender = rs.getString(4);
                int phone = rs.getInt(5);
                String address = rs.getString(7);
                String mail = rs.getString(8);
                String pw = rs.getString(9);
                String status = rs.getString(10);
                String role = rs.getString(11);
                int maid = rs.getInt(12);
                int jid = rs.getInt(6);
                int did1 = rs.getInt(13);
                list.add(new Users(bid, phone, maid, did1, jid, dob, name, mail, pw, role, status, gender, address));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

    public ArrayList<Users> viewAllUser(int offet) {
        String sql = "Select Users.UserID , Users.FullName,Users.Dob ,Job.Job_title AS Job,"
                + " Users.Email,Users.Phone\n"
                + ",Users.Password,Users.Status,Users.Manager_id,Users.Gender,"
                + "Users.Address,department.Name AS Department, Users.Role\n"
                + "FROM Users \n"
                + "INNER JOIN department\n"
                + "ON Users.DepartmentID = department.id\n"
                + "INNER JOIN Job\n"
                + "ON Job.Job_id = Users.Job_id where Users.Status='H' OR Users.Status='L'\n"
                + "order by UserID \n"
                + "OFFSET  ? ROWS FETCH NEXT 5 ROWS ONLY;";
        ArrayList<Users> list = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (offet - 1) * 5);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                String name = rs.getString(2);
                Date dob = rs.getDate(3);
                String job = rs.getString(4);
                String mail = rs.getString(5);
                int phone = rs.getInt(6);
                String pw = rs.getString(7);
                String status = rs.getString(8);
                int maid = rs.getInt(9);
                String gender = rs.getString(10);
                String address = rs.getString(11);
                String depname = rs.getString(12);
                String role = rs.getString(13);
                list.add(new Users(bid, phone, maid, dob, name, mail, pw, role, status, gender, address, job, depname));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Users> viewAllHistory(String sta, int offet) {
        String sql = "Select Users.UserID , Users.FullName,Users.Dob ,Job.Job_title AS Job,"
                + " Users.Email,Users.Phone\n"
                + ",Users.Password,Users.Status,Users.Manager_id,Users.Gender,"
                + "Users.Address,department.Name AS Department, Users.Role\n"
                + "FROM Users \n"
                + "INNER JOIN department\n"
                + "ON Users.DepartmentID = department.id\n"
                + "INNER JOIN Job\n"
                + "ON Job.Job_id = Users.Job_id where Users.Status=? \n"
                + "order by UserID \n"
                + "OFFSET  ? ROWS FETCH NEXT 5 ROWS ONLY;";
        ArrayList<Users> list = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sta);
            stmt.setInt(2, (offet - 1) * 5);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                String name = rs.getString(2);
                Date dob = rs.getDate(3);
                String job = rs.getString(4);
                String mail = rs.getString(5);
                int phone = rs.getInt(6);
                String pw = rs.getString(7);
                String status = rs.getString(8);
                int maid = rs.getInt(9);
                String gender = rs.getString(10);
                String address = rs.getString(11);
                String depname = rs.getString(12);
                String role = rs.getString(13);
                list.add(new Users(bid, phone, maid, dob, name, mail, pw, role, status, gender, address, job, depname));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ArrayList<Users> listAllUser() {
        String sql = "Select Users.UserID , Users.FullName,Users.Dob ,"
                + "Job.Job_title AS Job, Users.Email,Users.Phone\n"
                + ",Users.Password,Users.Status,Users.Manager_id,Users.Gender,"
                + "Users.Address,department.Name AS Department, Users.Role\n"
                + "FROM Users\n"
                + "INNER JOIN department\n"
                + "ON Users.DepartmentID = department.id\n"
                + "INNER JOIN Job\n"
                + "ON Job.Job_id = Users.Job_id\n"
                + "order by UserID";
        ArrayList<Users> list = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                String name = rs.getString(2);
                Date dob = rs.getDate(3);
                String job = rs.getString(4);
                String mail = rs.getString(5);
                int phone = rs.getInt(6);
                String pw = rs.getString(7);
                String status = rs.getString(8);
                int maid = rs.getInt(9);
                String gender = rs.getString(10);
                String address = rs.getString(11);
                String depname = rs.getString(12);
                String role = rs.getString(13);
                list.add(new Users(bid, phone, maid, dob, name, mail, pw, role, status, gender, address, job, depname));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static ArrayList<Users> getAllUser() {
        ArrayList<Users> list = new ArrayList<Users>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select UserID,FullName,Dob,"
                    + "Gender,Phone,Job_id,Address,Email,Password,"
                    + "Status,Role,Manager_id,DepartmentID from Users");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt("UserID");
                Date dob = rs.getDate("Dob");
                String name = rs.getString("FullName");
                String gender = rs.getString("Gender");
                int phone = rs.getInt("Phone");
                String address = rs.getString("Address");
                String mail = rs.getString("Email");
                String pw = rs.getString("Password");
                String status = rs.getString("Status");
                String role = rs.getString("Role");
                int maid = rs.getInt("Manager_id");
                int jobid = rs.getInt("Job_id");
                int depid = rs.getInt("DepartmentID");
                list.add(new Users(bid, phone, maid, depid, jobid, dob, name, mail, pw, role, status, gender, address));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static Users update(Users u) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Users set FullName=?,Dob=?,Gender=?,Phone=?,Job_id=?,Address=?,"
                    + "Email=?,Password=?,Status=?,Role=?,Manager_id=?,DepartmentID=? where UserID=?");
            stmt.setString(1, u.getFullName());
            stmt.setDate(2, u.getDateOB());
            stmt.setString(3, u.getGender());
            stmt.setInt(4, u.getPhone());
            stmt.setInt(5, u.getJob_id());
            stmt.setString(6, u.getAddress());
            stmt.setString(7, u.getEmail());
            stmt.setString(8, u.getPassword());
            stmt.setString(9, u.getStatus());
            stmt.setString(10, u.getRole());
            stmt.setInt(11, u.getManager_id());
            stmt.setInt(12, u.getDepartment_ID());
            stmt.setInt(13, u.getUserID());
            int rs = stmt.executeUpdate();
            con.close();
            return u;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void updatePass(String name, String email, String pass) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Users set Password=? where FullName=? and Email=? ");
            stmt.setString(1, pass);
            stmt.setString(2, name);
            stmt.setString(3, email);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void updateStatus(int id, String status) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Users set Status=? where UserID=? ");
            stmt.setString(1, status);
            stmt.setInt(2, id);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from Users where Status='H' OR Status='L'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public int getTotalHistoey(String status, String status1) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from Users where Status=? OR Status=?");
            stmt.setString(1, status);
            stmt.setString(2, status1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public static <T> ArrayList<T> search(ArrayList<T> list, Predicate<T> p) {
        ArrayList<T> result = new ArrayList<>();
        for (T b : list) {
            if (p.test(b)) {
                result.add(b);
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
    private static char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static String generateManagerID() {
        String randomStrValue = "";
        int LENGTH = 5;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
