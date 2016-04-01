package com.wq.produce.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SOUPE_USER")
@Cacheable
public class User {
    //@Cacheable(value=”accountCache”)，这个注释的意思是，当调用这个方法的时候，会从一个名叫 accountCache 的缓存中查询
    //，如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中
    //@CacheEvict(value=”accountCache”,key=”#account.getName()”) 情况缓存 Key 是用来指定缓存的 key
    //@CachePut 注释，这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中，实现缓存与数据库的同步更新。
    @Column(name = "ID")
    private Long id;

	@Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "SSO_ID")
    private String ssoId;

    @Column(name = "PASSWORD")
    private String password;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}