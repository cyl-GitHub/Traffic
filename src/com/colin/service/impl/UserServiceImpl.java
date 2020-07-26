package com.colin.service.impl;

import com.colin.bean.User;
import com.colin.mapper.UserMapper;
import com.colin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateFourthScore(String id, int score) {
        userMapper.updateFourthScore(id, score);
    }

    @Override
    public void changePassword(User userLogin) {
        userMapper.changePassword(userLogin);

    }

    @Override
    public void insertTestRecord(String uid, String class1, String class3, int score) {
        userMapper.insertTestRecord(uid, class1, class3, score);
    }

    @Override
    public Integer selectBestScore(String uid, String class1, String class3) {

       return userMapper.selectBestScore(uid, class1, class3);
    }

    @Override
    public void replaceAvatar(User userLogin) {
        userMapper.replaceAvatar(userLogin);
    }


}
