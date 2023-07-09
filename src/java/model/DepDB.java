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

/**
 *
 * @author ASUS-PRO
 */
public class DepDB {

    public static Department addNew(Department d) {
        try ( Connection con = DatabaseInfo.getConnect()) {
            String sql = "SET IDENTITY_INSERT department ON; \n"
                    + "INSERT INTO department(id,name) VALUES (?,?);\n"
                    + "SET IDENTITY_INSERT department OFF;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, d.getDid());
            stmt.setString(2, d.getDname());
            stmt.executeUpdate();
            con.close();
            return d;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Department> getAll() {
        ArrayList<Department> list = new ArrayList<Department>();
        String sql = "select id,Name from department";
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Department(name, id));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
    }

    public static boolean getAllByID(int did) {
        Department list = null;
        int affected_rows = 0;
        String sql = "select id,Name from department where id=?";
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, did);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list = new Department(name, id);
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

    public ArrayList<Department> viewAllDep(int offet) {
        String sql = "select id,Name from department \n"
                + "order by id \n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        ArrayList<Department> list = new ArrayList<Department>();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (offet - 1) * 5);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Department(name, id));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getTotal() {
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select count(*) from department");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw new RuntimeException("something wrong!");
        }
        return 0;
    }

    public static ArrayList<Department> delete(int id) {
        ArrayList<Department> list = getAll();
        try ( Connection con = DatabaseInfo.getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Delete department where id=?");
            stmt.setInt(1, id);
            int rc = stmt.executeUpdate();
            con.close();
            return list;
        } catch (Exception ex) {
            throw new RuntimeException("Delete faile!");
        }
    }

}
