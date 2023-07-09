/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;
import model.UsersDB;

/**
 *
 * @author ASUS-PRO
 */
public class AddNewUsers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddNewUsers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewUsers at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone =request.getParameter("phone");
        String job_id = request.getParameter("job_id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String Cpassword = request.getParameter("repeatPassword");
        String role = request.getParameter("role");
        if (!(password != null && Cpassword != null && password.equals(Cpassword))) {
            request.setAttribute("msq", "Create failed");
            request.getRequestDispatcher(response.encodeURL("addnew.jsp")).forward(request, response);
        } else {
            if (UsersDB.checkEmail(email) == true) {
                request.setAttribute("msq", "Email already exists");
                request.getRequestDispatcher(response.encodeURL("addnew.jsp")).forward(request, response);
            } else {
                Users u = new Users();
                u.setFullName(fullname);
                u.setDob(dob);
                u.setAddress(address);
                u.setGender(gender);
                u.setPhone(Integer.parseInt(phone));
                u.setDepartment_ID(7);
                u.setJob_id(Integer.parseInt(job_id));
                u.setEmail(email);
                u.setPassword(password);
                if ("EE".equals(role) || role ==null) {
                    u.setRole("EE");
                }else{
                    u.setRole(role);
                }
                u.setStatus("H");
                u.setManager_id(Integer.valueOf(UsersDB.generateManagerID()));
                UsersDB.addNew(u);
                request.setAttribute("msq", "Create success");
                request.getRequestDispatcher(response.encodeURL("addnew.jsp")).forward(request, response);
            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
