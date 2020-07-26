package com.colin.mapper;

import com.colin.bean.User;

public interface UserMapper {
    User selectUser(User user);

    void insertUser(User user);

    void updateFourthScore(String id, int score);

    void changePassword(User userLogin);

    void insertTestRecord(String uid, String class1, String class3, int score);

    Integer selectBestScore(String uid, String class1, String class3);

    void replaceAvatar(User userLogin);

}
