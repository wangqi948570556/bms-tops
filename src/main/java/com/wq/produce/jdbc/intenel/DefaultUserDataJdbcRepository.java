package com.wq.produce.jdbc.intenel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.wq.produce.jdbc.UserDataJdbcRepository;
import com.wq.produce.model.User;

@Repository
public class DefaultUserDataJdbcRepository extends SqlMapClientDaoSupport implements UserDataJdbcRepository {
    @Autowired
    public DefaultUserDataJdbcRepository(SqlMapClient sqlMapClient) {
        this.setSqlMapClient(sqlMapClient);
    }
    
    public List<User> getUsers() {
        return this.getSqlMapClientTemplate().queryForList("BMS.USER.getAll", null);
    }
}
