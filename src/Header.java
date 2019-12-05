import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet(
        name = "Header",
        urlPatterns = {"/header"}
)
public class Header extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Show Header</title>");
        out.print("</head>");
        out.print("<body>");
        Collections.list(request.getHeaderNames()).forEach(name -> {
            out.printf("%s: %s<br>", name, request.getHeader(name));
        });
        out.print("</body>");
        out.print("</html>");
    }
}
