package com.likejin.mybatis.entity;

/**
 * @Author 李柯锦
 * @Date 2023/5/24 20:30
 * @Description 多表联查使用
 */
public class User {
    Integer id;
    String username;
    String password;
    String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {

    }

    public User(Integer id, String username, String password, String email) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
