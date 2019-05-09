package nuc.zb.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    //定义常量
    //库的基本信息
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";//mysql数据库驱动类型
    //	public static final String DBDRIVER="com.mysql.jdbc.Driver";//mysql数据库驱动类型
    public static final String DBURL = "jdbc:mysql://localhost:3306/taobaoshujuji";
    public static final String DBUSER = "root";
    public static final String DBPASS = "123456";
    Connection conn = null;

    public Connection getConn() {
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
