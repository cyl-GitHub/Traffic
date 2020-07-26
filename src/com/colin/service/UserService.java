package com.colin.service;

import com.colin.bean.User;

public interface UserService {


    //查询用户的具体信息
    User selectUser(User user);

    //用户注册
    void insertUser(User user);

    //更新用户科四的考试成绩
    void updateFourthScore(String id, int score);

    //更改用户密码
    void changePassword(User userLogin);

    void insertTestRecord(String uid, String class1, String class3, int score);

    Integer selectBestScore(String uid, String class1, String class3);


    void replaceAvatar(User userLogin);

}
