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
        /*int i = 1000000;
        while (i-- != 0) {
            out.println("开始转发啦");
        }*/
        // 使用request对象实现不同Servlet的数据流转
        req.setAttribute("str", "用户名或密码错误");
        RequestDispatcher dispatcher = req.getRequestDispatcher("iaf");
        dispatcher.forward(req, resp);
        /*out.println("转发结束啦");*/
        System.out.println("哈哈");
        resp.setHeader("key1", "value1");
    }
}
