package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Job;
import model.DatabaseInfo;

/**
 *
 * @author ASUS-PRO
 */
public class JobDB {

    public static Job addNew(Job u) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "Insert into Job(job_title,min_salary,max_salary) values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getJobName());
            stmt.setFloat(2, u.getMinsalary());
            stmt.setFloat(3, u.getMaxsalary());
            stmt.executeUpdate();
            con.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Job getID(int uid) {
        Job u = null;
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "select job_id,job_title,min_salary,max_salary from Job where job_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();
            stmt.executeUpdate();
            while (rs.next()) {
                int bid = rs.getInt(1);
                String name = rs.getString(2);
                int min = rs.getInt(3);
                int max = rs.getInt(4);
                u = new Job(bid, name, min, max);
            }
            con.close();
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Job> viewAllJob(int offet) {
        String sql = "select job_id,job_title,min_salary,max_salary from Job \n"
                + "order by job_id \n"
                + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        ArrayList<Job> list = new ArrayList<Job>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (offet - 1) * 4);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int bid = rs.getInt(1);
                String name = rs.getString(2);
                int min = rs.getInt(3);
                int max = rs.getInt(4);
                list.add(new Job(bid, name, min, max));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
  
    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from Job");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public static ArrayList<Job> getAll() {
        ArrayList<Job> list = new ArrayList<Job>();
        String sql = "select job_id,job_title,min_salary,max_salary from Job";
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int jid = rs.getInt(1);
                String jtitle = rs.getString(2);
                int min = rs.getInt(3);
                int max = rs.getInt(4);
                list.add(new Job(jid, jtitle, min, max));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static ArrayList<Job> delete(int id) {
        ArrayList<Job> list = getAll();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Delete Job where job_id=?");
            stmt.setInt(1, id);
            int rc = stmt.executeUpdate();
            con.close();
            return list;
        } catch (Exception ex) {
          throw new RuntimeException("Delete faile!");
        }
    }
 
}
