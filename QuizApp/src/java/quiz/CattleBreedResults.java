/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dnyffeler
 */
public class CattleBreedResults extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Map<String, String> key = new HashMap<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        key.put("14", "Watusi");
        key.put("16", "Texas Longhorn");
        key.put("2", "Angus");
        key.put("10", "Red Angus");
        key.put("6", "Piedmontese");
        key.put("13", "Shorthorn");
        key.put("11", "Holstein");
        key.put("15", "Simmental");
        key.put("12", "Scottish Highland");
        key.put("8", "Gelbvieh");
        key.put("1", "Limousin");
        key.put("9", "Hereford");
        key.put("4", "Brahman");
        key.put("7", "Dexter");
        key.put("5", "Charolais");
        key.put("3", "Belted Galloway");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CattleBreedResults</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Results</h1>");
            for(String k: key.keySet()) {
                String correct = request.getParameter(key.get(k));
                if(correct.equals(k)) {
                    correct = "";
                } else {
                    correct = "<b>" + correct + "</b>";
                }
                out.println(k + " " + key.get(k) + " " + correct + "</br>");

            }
            out.println("<img src=\"sources/cattleBreeds.jpg\" alt=\"\"/>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
