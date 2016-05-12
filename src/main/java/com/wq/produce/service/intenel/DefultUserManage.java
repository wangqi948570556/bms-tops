package com.wq.produce.service.intenel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wq.produce.jpa.UserRepository;
import com.wq.produce.model.User;
import com.wq.produce.service.UserManage;

public class DefultUserManage implements UserManage {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
