package com.wq.produce.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wq.produce.model.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
