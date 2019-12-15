import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        // 声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 声明数据存储对象
        User u = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo", "root", "520520cw...");
            // 创建Sql命令
            String sql = "select *from t_user where uname=? and pwd=?";
            // 创建sql命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符复制
            ps.setString(1, uname);
            ps.setString(2, pwd);
            // 执行
            rs = ps.executeQuery();
            // 遍历执行结果
            while (rs.next()) {
                u = new User();
                u.setPwd(rs.getString("pwd"));
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
            }
            // 关闭资源

            // 返回
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}
