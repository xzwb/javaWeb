import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(
        name = "RequestTest",
        urlPatterns = {"/req"},
        loadOnStartup = 1
)
public class RequestTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 获取请求头
        // 获取请求方式
        System.out.println(req.getMethod());
        // 获取请求url
        System.out.println(req.getRequestURL());
        //获取uri
        System.out.println(req.getRequestURI());
        // 获取请求协议
        System.out.println(req.getScheme());
    // 获取请求行根据置顶键获取值 如果没有这个件就会返回null
        // 返回指定行信息
        /*System.out.println(req.getHeader("host"));*/
        // 返回所有的键
        Enumeration e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement() + ": " + req.getHeader(e.nextElement().toString()));
        }
    // 获取用户数据get是没有的就在url里面
        System.out.println(req.getParameter("user"));
        System.out.println(req.getParameter("pwd"));
    }
}
