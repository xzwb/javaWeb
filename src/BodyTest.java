import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "BodyTest",
        urlPatterns = {"/body"}
)
public class BodyTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>body</title>");
        out.print("</head>");
        out.print("<body>");
        out.print(bodyContent(request.getReader()));
        out.print("hello world");
        out.print("</body>");
        out.print("</html>");
        System.out.println("hshsh");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>body</title>");
        out.print("</head>");
        out.print("<body>");
        out.print(bodyContent(request.getReader()));
        out.print("</body>");
        out.print("</html>");
    }

    private String bodyContent(BufferedReader reader)
        throws IOException {
        String input = null;
        StringBuilder requestBody = new StringBuilder();
        while ((input = reader.readLine()) != null) {
            requestBody.append(input)
                    .append("<br>");
        }
        return requestBody.toString();
    }
}
