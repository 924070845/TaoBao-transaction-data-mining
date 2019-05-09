package nuc.zb.dao;

import nuc.zb.Apriori.Apriori2;
import nuc.zb.conn.Conn;
import nuc.zb.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    //查询出 商品类别、品牌、行为、年龄、性别的所有数据，以供关联分析
    public List<User> selectUserRules() {
        ArrayList<String> userList = new ArrayList<>();
        ResultSet rs = null;

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            //查询100K条数据
            String sql_select = "select distinct cat_id, brand_id, action, age_range, gender " +
                    "from user_log limit 0,100";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            String data = null;
            while (rs.next()) {
                User user = new User();
                user.setCat_id(rs.getString("cat_id"));
                user.setBrand_id(rs.getString("brand_id"));
                user.setActionType(rs.getString("action"));
                user.setAge_rangeType(rs.getString("age_range"));
                user.setGenderType(rs.getString("gender"));

                data =
                        "  Cat_id"+rs.getString("cat_id")+","+
                                "  Brand_id"+rs.getString("brand_id")+","+
                                "  action"+rs.getString("action")+","+
                                "  Age"+rs.getString("age_range")+","+
                                "  Gender"+rs.getString("gender")
                        ;
                userList.add(data);
            }

            Apriori2 apriori2 = new Apriori2();
            apriori2.letsGo(userList);//执行关联规则的Apriori算法。

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    //查询 女性数量 0表示女性
    public String selectGender0Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(gender) FROM user_log where gender=0";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();

            while (rs.next()) {
                user.setGender0Num(rs.getString("count(gender)"));
//                System.out.println("Gender0:"+user.getGender0Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getGender0Num();
    }

    //查询 男性数量 1表示男性
    public String selectGender1Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(gender) FROM user_log where gender=1";
//            System.out.println("查询的结果为：");
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setGender1Num(rs.getString("count(gender)"));
//                System.out.println("Gender1:"+user.getGender1Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getGender1Num();
    }

    //查询 未知性别数量 2和NULL表示未知
    public String selectGender2Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(gender) FROM user_log where gender=2\n";
//            System.out.println("查询的结果为：");
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setGender2Num(rs.getString("count(gender)"));
//                System.out.println("Gender2:"+user.getGender2Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getGender2Num();
    }

    //查询 动作为 0表示点击的数量
    public String selectAction0Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(action) FROM user_log where action=0";
//            System.out.println("查询的结果为：");
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAction0Num(rs.getString("count(action)"));
//                System.out.println("Action0:"+user.getAction0Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAction0Num();
    }

    //查询 动作为 1表示加入购物车的数量
    public String selectAction1Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(action) FROM user_log where action=1";
//            System.out.println("查询的结果为：");
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAction1Num(rs.getString("count(action)"));
//                System.out.println("Action1:"+user.getAction1Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAction1Num();
    }

    //查询 动作为 2表示购买的数量
    public String selectAction2Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(action) FROM user_log where action=2";
//            System.out.println("查询的结果为：");
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAction2Num(rs.getString("count(action)"));
//                System.out.println("Action2:"+user.getAction2Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAction2Num();
    }

    //查询 动作为 3表示关注商品的数量
    public String selectAction3Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(action) FROM user_log where action=3";
//            System.out.println("查询的结果为：");
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAction3Num(rs.getString("count(action)"));
//                System.out.println("Action3:"+user.getAction3Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAction3Num();
    }

    //查询 年龄1表示年龄<18
    public String selectAge1Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=1";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range1Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range1:"+user.getAge_range1Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range1Num();
    }

    //查询 年龄2表示年龄在[18,24]
    public String selectAge2Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=2";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range2Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range2:"+user.getAge_range2Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range2Num();
    }

    //查询 年龄3表示年龄在[25,29]
    public String selectAge3Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=3";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range3Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range3:"+user.getAge_range3Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range3Num();
    }

    //查询 年龄4表示年龄在[30,34]
    public String selectAge4Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=4";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range4Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range4:"+user.getAge_range4Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range4Num();
    }

    //查询 年龄5表示年龄在[35,39]
    public String selectAge5Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=5";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range5Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range5:"+user.getAge_range5Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range5Num();
    }

    //查询 年龄6表示年龄在[40,49]
    public String selectAge6Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=6";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range6Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range6:"+user.getAge_range6Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range6Num();
    }

    //查询 年龄7和8表示年龄>=50
    public String selectAge7Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=7 or age_range=8";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range7Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range7/8:"+user.getAge_range7Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range7Num();
    }

    //查询 年龄0和NULL则表示未知
    public String selectAge0Num() {
        ResultSet rs = null;
        User user = new User();

        try {
            //连上数据库的语句
            Conn conn = new Conn();
            Connection bdc = conn.getConn();
            String sql_select = "SELECT count(age_range) FROM user_log where age_range=0";
            PreparedStatement pst = bdc.prepareStatement(sql_select);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setAge_range0Num(rs.getString("count(age_range)"));
//                System.out.println("Age_range0:"+user.getAge_range0Num());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  user.getAge_range0Num();
    }


}
