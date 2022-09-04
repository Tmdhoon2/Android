package com.example.githubapisample.model;

public class User {

    private String login;
    private int id;
    private String image;
    private String blog;
    private String location;
    private int followers;
    private int following;

    public User(String login, int id, String image, String blog, String location, int followers, int following) {
        this.login = login;
        this.id = id;
        this.image = image;
        this.blog = blog;
        this.location = location;
        this.followers = followers;
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getBlog() {
        return blog;
    }

    public String getLocation() {
        return location;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }
}
