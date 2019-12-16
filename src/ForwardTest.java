import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ForwardTest",
        urlPatterns = {"/forward"}
)
public class ForwardTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("开始转发啦");
        RequestDispatcher dispatcher = req.getRequestDispatcher("iaf");
        dispatcher.forward(req, resp);
        out.println("转发结束啦");
        resp.setHeader("key1", "value1");
    }
}
