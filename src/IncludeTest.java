import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "IncludeTest",
        urlPatterns = {"/include"},
        loadOnStartup = 1
)
public class IncludeTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("开始包含啦");
        RequestDispatcher dispathcher = req.getRequestDispatcher("iaf");
        dispathcher.include(req, resp);
        out.println("包含结束啦");
    }
}
