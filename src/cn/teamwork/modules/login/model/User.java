package cn.teamwork.modules.login.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_USERS")
public class User implements Serializable{
	/**
	 * auto generated serialVersionUID
	 */
	private static final long serialVersionUID = -4185130840073491992L;
	
	@Id	@GeneratedValue	@Column(name = "ID")
	private long id;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "NAME")
	private String name;

    public User() {
    }

    public long getId() {
        return id;
    }

    public User(String code, String password, String name) {
        this.code = code;
        this.password = password;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}