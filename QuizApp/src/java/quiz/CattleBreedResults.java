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
    public static Map<String, String> key = new HashMap<>();

    static {
        key.put("Watusi", "14");
        key.put("Texas Longhorn", "16");
        key.put("Angus", "2");
        key.put("Red Angus", "10");
        key.put("Piedmontese", "6");
        key.put("Shorthorn", "13");
        key.put("Holstein", "11");
        key.put("Simmental", "15");
        key.put("Scottish Highland", "12");
        key.put("Gelbvieh", "8");
        key.put("Limousin", "1");
        key.put("Hereford", "9");
        key.put("Brahman", "4");
        key.put("Dexter", "7");
        key.put("Charolais", "5");
        key.put("Belted Galloway", "3");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CattleBreedResults</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Results</h1>");
            out.println("<table>");
            out.println("<tr><th></th><th>Your Answer</th><th>Correct Answer</th></tr>");
            int count = 0;
            for (String k : key.keySet()) {
                out.println("<tr><td>");
                String answer = request.getParameter(k);
                if (answer.equals(key.get(k))) {
                    answer = "<b>" + answer + "</b>";
                    count++;
                } else {
                    answer = "<font color=red>" + answer + "</font>";
                }
                out.println(k);
                out.println("</td><td>");
                out.println(answer);
                out.println("</td><td>");
                out.println(key.get(k));

                out.println("</td></tr>");
            }

            out.println("</table>");
            
            out.println("<h1>" + count + " right.</h1>");
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
