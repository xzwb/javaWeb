import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet(
        name = "hello",
        urlPatterns = {"/Hello"},
        loadOnStartup = 1
)*/
@WebServlet("/Hello")
public class Hello extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>helloworld</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>hello！%s%n</h1>", name);
        out.println("</body>");
        out.println("</html>");
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
    }
}
