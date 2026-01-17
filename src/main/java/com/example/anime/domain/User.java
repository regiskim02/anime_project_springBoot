package com.example.anime.domain;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private Integer malId;
    private char favoriteyn;
    private char watchyn;
    private char completeyn;
    private char planToWatchyn;

    public User() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
    }

    public char getFavoriteyn() {
        return favoriteyn;
    }

    public void setFavoriteyn(char favoriteyn) {
        this.favoriteyn = favoriteyn;
    }

    public char getWatchyn() {
        return watchyn;
    }

    public void setWatchyn(char watchyn) {
        this.watchyn = watchyn;
    }

    public char getCompleteyn() {
        return completeyn;
    }

    public void setCompleteyn(char completeyn) {
        this.completeyn = completeyn;
    }

    public char getPlanToWatchyn() {
        return planToWatchyn;
    }

    public void setPlanToWatchyn(char planToWatchyn) {
        this.planToWatchyn = planToWatchyn;
    }
}
