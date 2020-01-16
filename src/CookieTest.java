import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Cookie",
        urlPatterns = {"/cookie"}
)
public class CookieTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 创建cookie对象
        Cookie c = new Cookie("mouse", "leishe");
        Cookie c1 = new Cookie("key", "xzwb");
        // 设置cookie有效期
        c1.setMaxAge(7*24*60*60);
        // 响应cookie信息
        resp.addCookie(c);
        resp.addCookie(c1);

    }
}
