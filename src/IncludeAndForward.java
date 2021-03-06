import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "IncludeAndForward",
        urlPatterns = {"/iaf"}
)
public class IncludeAndForward extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("key", "value");
        resp.getWriter().println("正在转发啊");
        // 获取request作用域数据
        String str = (String) req.getAttribute("str");
        System.out.println(str);
        // resp.sendError(404, "sorry");
    }
}
