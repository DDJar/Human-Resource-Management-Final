/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author ASUS-PRO
 */
public class LogDB {

    public static Log addNew(Log u) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "Insert into Log(UserID,ProjectID,MRDate,Description,Status)  values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, u.getUserID());
            stmt.setInt(2, u.getpID());
            stmt.setDate(3, Date.valueOf(u.getMrDate()));
            stmt.setString(4, u.getDescription());
            stmt.setString(5, u.getStatus());
            int rs = stmt.executeUpdate();
            con.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Log> getAll() {
        ArrayList<Log> list = new ArrayList<Log>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select LogID,UserID,ProjectID,BDate,MRDate,Description,Status from Log");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int lid = rs.getInt(1);
                int bid = rs.getInt(2);
                int pid = rs.getInt(3);
                Date bdate = rs.getDate(4);
                Date mdate = rs.getDate(5);
                String descrip = rs.getString(6);
                String status = rs.getString(7);
                LocalDate brdate = bdate.toLocalDate();
                LocalDate mrdate = mdate.toLocalDate();
                list.add(new Log(lid, pid, bid, brdate, mrdate, descrip, status));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }

    }

    public static ArrayList<Log> getAllID(int id) {
        ArrayList<Log> list = new ArrayList<Log>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select LogID,UserID,ProjectID,BDate,MRDate,Description,Status from Log where ProjectID=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int lid = rs.getInt(1);
                int bid = rs.getInt(2);
                int pid = rs.getInt(3);
                Date bdate = rs.getDate(4);
                Date mdate = rs.getDate(5);
                String descrip = rs.getString(6);
                String status = rs.getString(7);
                LocalDate brdate = bdate.toLocalDate();
                LocalDate mrdate = mdate.toLocalDate();
                list.add(new Log(lid, pid, bid, brdate, mrdate, descrip, status));
            }
            con.close();
             return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }

    }

    public ArrayList<Log> viewAllLog(int offet) {
        String sql = "select LogID,UserID,ProjectID,BDate,MRDate,Description,Status from Log \n"
                + "order by LogID \n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        ArrayList<Log> list = new ArrayList<Log>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (offet - 1) * 5);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int lid = rs.getInt(1);
                int bid = rs.getInt(2);
                int pid = rs.getInt(3);
                Date bdate = rs.getDate(4);
                Date mdate = rs.getDate(5);
                String descrip = rs.getString(6);
                String status = rs.getString(7);
                LocalDate brdate = bdate.toLocalDate();
                LocalDate mrdate = mdate.toLocalDate();
                list.add(new Log(lid, pid, bid, brdate, mrdate, descrip, status));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from Log");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }
    public static void updateStatus(String status, int lid) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Update Log set Status=? where LogID=?");
            stmt.setString(1, status);
            stmt.setInt(2, lid);
            stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
