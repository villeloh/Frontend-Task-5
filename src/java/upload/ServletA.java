
package upload;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ville L
 */
@WebServlet(name = "testUploadA", urlPatterns = {"/ServletA"})
@MultipartConfig(location = "/var/www/html/test")
public class ServletA extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.setContentType("html");
        try (PrintWriter out = response.getWriter()) {
            request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Image uploaded!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<img src=\"http://10.114.32.109/test/" + request.getPart("fileup").getSubmittedFileName() + "\">");
            out.println("</body>");
            out.println("</html>");            
        }
    }
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} // end class
