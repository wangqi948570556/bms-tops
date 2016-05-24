package com.wq.produce.service.intenel;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wq.produce.model.User;
import com.wq.produce.service.UserManage;

@Service
@Transactional(readOnly = true)
public class DefultUserManage implements UserManage {

//    @Autowired
//    private UserRepository userRepository;
    
//    @Autowired
//    private DefaultUserDataJdbcRepository userDataJdbcRepository;
//  
    @Override
    public List<User> getUsers() {
//        return userDataJdbcRepository.getUsers();
        return null;
    }

}
