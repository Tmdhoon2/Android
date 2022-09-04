package com.example.githubapisample.model;

public class UserList {

    private String login;
    private int id;

    public UserList(String login, int id) {
        this.login = login;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
