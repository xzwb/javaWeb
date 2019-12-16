import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Test1",
        urlPatterns = {"/test1"},
        loadOnStartup = 1
)
/**
 * req.getReader()方法对于get请求没啥用感觉
 */
public class Test1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(bodyContent(req.getReader()));
    }

    private String bodyContent(BufferedReader reader)
        throws IOException {
        String input = null;
        StringBuilder requestBody = new StringBuilder();
        while ((input = reader.readLine()) != null) {
            requestBody.append(input).append("<br>");
        }
        return requestBody.toString();
    }
}
