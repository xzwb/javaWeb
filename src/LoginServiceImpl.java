public class LoginServiceImpl implements LoginService {
    // 创建Dao层对象
    LoginDao ld = new LoginDaoImpl();
    @Override
    public User checkLoginService(String uname, String pwd) {

        return ld.checkLoginDao(uname, pwd);
    }
}
