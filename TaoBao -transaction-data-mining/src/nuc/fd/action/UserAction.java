package nuc.zb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import nuc.zb.dao.UserDao;
import nuc.zb.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven {

    User user = new User();

    //查询所有信息
    public String selectUserRules(){
        System.out.println(1);
        UserDao userDao = new UserDao();
        List<User> userList = new ArrayList<User>();
        userList = userDao.selectUserRules();//调用selectUserRules方法
        return "selectUserRulesSUCCESS";
    }


    //查询 各个性别的人数
    public String selectGenderNum(){
        System.out.println(2);
        UserDao userDao = new UserDao();
        HashMap userGenderMap = new HashMap();
        userGenderMap.put("man",userDao.selectGender0Num());
        userGenderMap.put("woman",userDao.selectGender1Num());
        userGenderMap.put("unknown",userDao.selectGender2Num());
        ActionContext.getContext().getSession().put("userGenderMap", userGenderMap);
        return "selectGenderNumSUCCESS";
    }

    //查询 各种动作的人数
    public String selectActionNum(){
        UserDao userDao = new UserDao();
        HashMap userActionMap = new HashMap();
        userActionMap.put("click",userDao.selectAction0Num());
        userActionMap.put("add",userDao.selectAction1Num());
        userActionMap.put("buy",userDao.selectAction2Num());
        userActionMap.put("attention",userDao.selectAction3Num());
        ActionContext.getContext().getSession().put("userActionMap", userActionMap);
        return "selectActionNumSUCCESS";
    }

    //查询 各个年龄段人数
    public String selectAge_rangeNum(){
        UserDao userDao = new UserDao();
        HashMap userAgeMap = new HashMap();
        userAgeMap.put("_18YearsOld",userDao.selectAge1Num());
        userAgeMap.put("_18_24_",userDao.selectAge2Num());
        userAgeMap.put("_25_29_",userDao.selectAge3Num());
        userAgeMap.put("_30_34_",userDao.selectAge4Num());
        userAgeMap.put("_35_39_",userDao.selectAge5Num());
        userAgeMap.put("_40_49_",userDao.selectAge6Num());
        userAgeMap.put("_50YearsOld_",userDao.selectAge7Num());
        userAgeMap.put("unknown",userDao.selectAge0Num());
        ActionContext.getContext().getSession().put("userAgeMap", userAgeMap);

        return "selectAge_rangeNumSUCCESS";
    }



    @Override
    public Object getModel() {
        return user;
    }
}


















