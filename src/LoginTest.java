import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "LoginTest",
        urlPatterns = {"/login"},
        loadOnStartup = 1
)
public class LoginTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        // 获取请求信息
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        /*System.out.println(uname + ": " + pwd);*/
        // 处理请求信息(数据库里找啦)
        // 获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname, pwd);
        /*System.out.println(u);*/
        // 响应处理结果
        if (u != null) {
            response.getWriter().print("<h1>登陆成功</h1>");
        } else {
            response.getWriter().print("<h1>登录失败</h1>");
        }
    }
}
