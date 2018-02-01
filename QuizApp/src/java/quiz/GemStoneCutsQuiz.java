package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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
public class GemStoneCutsQuiz extends HttpServlet {

    public static Map<String, String> key = new HashMap<>();

    static {
        key.put("Round", "1");
        key.put("Octagon", "2");
        key.put("Oval", "3");
        key.put("Princess", "12");
        key.put("Triangle", "5");
        key.put("Cushion", "4");
        key.put("Baguette", "11");
        key.put("Radiant", "7");
        key.put("Heart", "9");
        key.put("Pear", "10");
        key.put("Trillion", "8");
        key.put("Marquise", "6");
    }

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

        System.out.println("header");
        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name);
            System.out.println("      " + request.getHeader(name) + "\n");
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Results</title>");
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
            out.println("<img src=\"sources/gemstoneCuts.jpg\" alt=\"\"/>");
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
