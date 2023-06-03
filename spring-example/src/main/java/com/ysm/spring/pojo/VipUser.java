package com.ysm.spring.pojo;

import java.util.List;
import java.util.Map;

public class VipUser {
    private User user;

    private List<User> users;

    private Map<String,User> userMap;




    public VipUser() {
    }

    public VipUser(User user, List<User> users, Map<String, User> userMap) {
        this.user = user;
        this.users = users;
        this.userMap = userMap;
    }

    @Override
    public String toString() {
        return "VipUser{" +
                "user=" + user +
                ", users=" + users +
                ", userMap=" + userMap +
                '}';
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUser() {
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    //set注入
    public void setUser(User user) {
        this.user = user;
    }

}
