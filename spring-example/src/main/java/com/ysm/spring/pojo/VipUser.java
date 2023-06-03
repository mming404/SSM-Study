package com.ysm.spring.pojo;

import java.util.List;

public class VipUser {
    private User user;

    private List<User> users;




    public VipUser() {
    }

    public VipUser(User user, List<User> users) {
        this.user = user;
        this.users = users;
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

    @Override
    public String toString() {
        return "VipUser{" +
                "user=" + user +
                ", users=" + users +
                '}';
    }
}
