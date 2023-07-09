/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Project;

/**
 *
 * @author ASUS-PRO
 */
public class ProjectDB {

    public static Project addNew(Project u) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "Insert into Project(Title,Author,Category,Description,PubYear,Quantity,AvailQtt,Status)  values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getTitle());
            stmt.setString(2, u.getAuthor());
            stmt.setString(3, u.getCategory());
            stmt.setString(4, u.getDescription());
            stmt.setInt(5, u.getPubYear());
            stmt.setInt(6, u.getQuantity());
            stmt.setInt(7, u.getAvailQtt());
            stmt.setString(8, u.getStatus());
            stmt.executeUpdate();
            con.close();
            return u;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static Project getID(int pid) {
        Project u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "select ProjectID,Title,Author,Category,Description,PubYear,Quantity,AvailQtt,Status from Project where ProjectID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int pid1 = rs.getInt(1);
                String tt = rs.getString(2);
                String at = rs.getString(3);
                String cat = rs.getString(4);
                String des = rs.getString(5);
                int py = rs.getInt(6);
                int qua = rs.getInt(7);
                int aqua = rs.getInt(8);
                String st = rs.getString(9);
                u = new Project(tt, at, cat, des, pid1, py, qua, aqua, st);
            }
            con.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static int getAvailQtt(int pid) {
        int availty=0;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "select AvailQtt from Project where ProjectID=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                availty = rs.getInt(1);
            }
            con.close();
            return availty;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Project> getAllProject() {
        ArrayList<Project> list = new ArrayList<Project>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select ProjectID,Title,Author,Category,Description,PubYear,Quantity,AvailQtt,Status from Project");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                String tt = rs.getString(2);
                String at = rs.getString(3);
                String cat = rs.getString(4);
                String des = rs.getString(5);
                int py = rs.getInt(6);
                int qua = rs.getInt(7);
                int aqua = rs.getInt(8);
                String st = rs.getString(9);
                list.add(new Project(tt, at, cat, des, pid, py, qua, aqua, st));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }

    }

    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from Project");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public ArrayList<Project> viewAllProject(int offet) {
        String sql = "select ProjectID,Title,Author,Category,Description,PubYear,Quantity,AvailQtt,Status from Project \n"
                + "order by ProjectID \n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        ArrayList<Project> list = new ArrayList<Project>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (offet - 1) * 5);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                String tt = rs.getString(2);
                String at = rs.getString(3);
                String cat = rs.getString(4);
                String des = rs.getString(5);
                int py = rs.getInt(6);
                int qua = rs.getInt(7);
                int aqua = rs.getInt(8);
                String st = rs.getString(9);
                list.add(new Project(tt, at, cat, des, pid, py, qua, aqua, st));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ArrayList<Project> delete(int id) {
        ArrayList<Project> list = getAllProject();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Delete Project where ProjectID=?");
            stmt.setInt(1, id);
            int rc = stmt.executeUpdate();
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void updateAvailyty(int pid) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Project set AvailQtt=AvailQtt-1,Status='L' where ProjectID=?");
            stmt.setInt(1, pid);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void updateAvail(int pid) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Project set AvailQtt=AvailQtt+1 where ProjectID=?");
            stmt.setInt(1, pid);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
