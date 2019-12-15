import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ResponseTest",
        urlPatterns = {"/resp"},
        loadOnStartup = 1
)
/**
 * Response
 *  使用：设置响应头， 设置响应实体
 *  setHeader(String name, String value); // 在响应头中添加相应信息同键会覆盖
 *  addHeader(String name, String value); // 同键不覆盖
 */
public class ResponseTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 获取请求信息
        // 获取请求头
        // 获取请求行
        // 获取用户数据
    // 处理请求
    // 响应处理结果
        // 设置相应头
        resp.setHeader("ss", "aaa");
        resp.setHeader("ss", "bbbb");
        resp.addHeader("key", "xxxxx");
        resp.addHeader("key", "sssss");
        // 设置响应编码格式
        /*resp.setHeader("content-type", "text/html;charset=utf-8");*/
        // 普通文本
        /*resp.setContentType("text/plain;charset=utf-8");*/
        resp.setContentType("text/html;charset=utf-8");
        // 设置响应状态码
        /*resp.sendError(404, "sorry");*/
        /*resp.sendError(405, "zhao bu dao fang fa");*/
        // 设置响应实体
        resp.getWriter().print("<b>我爱你中国</b>");
    }
}
