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
public class AirportCodesResults extends HttpServlet {

    public static Map<String, String> key = new HashMap<>();

    static {
        key.put("Cancun", "CUN");
        key.put("Reykjavik", "KEF");
        key.put("Stockholm", "ARN");
        key.put("London", "LHR");
        key.put("Vancouver", "YVR");
        key.put("Chicago", "ORD");
        key.put("Honolulu", "HNL");
        key.put("Sao Paulo", "GRU");
        key.put("Paris", "CDG");
        key.put("Munich", "MUC");
        key.put("Rome", "FCO");
        key.put("Copenhagen", "CPH");
        key.put("Sydney", "SYD");
        key.put("Tokyo", "HND");
        key.put("Beijing", "PEK");
        key.put("Seoul", "GMP");
        key.put("Mumbai", "BOM");
        key.put("Ho Chi Minh City", "SGN");
        key.put("Riyadh", "RUH");
        key.put("Saint Petersburg", "LED");

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
                try {
                    if (answer.equalsIgnoreCase(key.get(k))) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
                out.println("</td></tr>");
            }

            out.println("</table>");

            out.println("<h1>" + count + " right.</h1>");

            out.println("Guangzhou	Guangzhou Baiyun International Airport	CAN<br/>");
            out.println("Frankfurt	Frankfurt Airport	FRA<br/>");
            out.println("No such code - REY<br/>");
            out.println("No such code - SWE<br/>");
            out.println("No such code - ENG<br/>");
            out.println("No such code - PET<br/>");
            out.println("No such code - BZL<br/>");
            out.println("No such code - SOK<br/>");
            out.println("No such code - HCM<br/>");
            out.println("No such code - COP<br/>");

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
