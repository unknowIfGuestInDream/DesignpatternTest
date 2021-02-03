package 原型.拷贝单例类;

/**
 * @author: TangLiang
 * @date: 2021/2/3 19:10
 * @since: 1.0
 */
public class DbUtil implements Cloneable {
    private String driver;
    private String url;
    private String user;
    private String pass;

    private static class SingletonHolder {
        private static final DbUtil INSTANCE = new DbUtil();
    }

    public static final DbUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private DbUtil() {
        if (null != SingletonHolder.INSTANCE) {
            throw new RuntimeException(DbUtil.class.getName() + "已创建，不可再创建");
        }
    }

    public void init() {
        if (driver == null) {
            throw new RuntimeException("缺少driver");
        }
        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(pass);
    }

    public Object clone() {
        DbUtil w = null;
        try {
            w = (DbUtil) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        return w;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "DbUtil{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
