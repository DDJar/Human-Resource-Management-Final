/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author ASUS-PRO
 */
public class SearchLog extends HttpServlet {

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
            out.println("<title>Servlet SearchLog</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchLog at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("list-receive");
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
        String txt = request.getParameter("txt");
        String cond = request.getParameter("sCriteria");
        ArrayList<Log> rList = null;
        switch (cond) {
            case "all":
                break;
            case "lid":
                rList = UsersDB.search(LogDB.getAll(), s -> String.valueOf(s.getLogID()).contains(txt));
                break;
            case "uid":
                rList = UsersDB.search(LogDB.getAll(), s -> String.valueOf(s.getUserID()).contains(txt));
                break;
            case "pid":
                rList = UsersDB.search(LogDB.getAll(), s -> String.valueOf(s.getpID()).contains(txt));
                break;
            case "mrDate":
                rList = UsersDB.search(LogDB.getAll(), s -> s.getMrDate().equals(txt));
                break;
            case "description":
                rList = UsersDB.search(LogDB.getAll(), s -> s.getMrDate().equals(txt));
                break;
            default:
                rList = LogDB.getAll();
        }
        if (cond.equals("all")) {
            response.sendRedirect("list-receive");
        } else if (rList == null) {
            request.setAttribute("MSG", "Not Found");
            request.setAttribute("MS", "Search");
            request.getRequestDispatcher("listLog.jsp").forward(request, response);
        } else {
            request.setAttribute("sCriteria", cond);
            request.setAttribute("listA", rList);
            request.setAttribute("MS", "Search");
            request.getRequestDispatcher("listLog.jsp").forward(request, response);
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
