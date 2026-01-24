package com.example.anime.domain;

public class AnimeStatus {
    private int animeUid;
    private int malId;
    private String favyn;
    private String watchyn;
    private String completedyn;
    private String planToWatch;
    private int userUid;

    public int getAnimeUid() {
        return animeUid;
    }

    public void setAnimeUid(int animeUid) {
        this.animeUid = animeUid;
    }

    public int getMalId() {
        return malId;
    }

    public void setMalId(int malId) {
        this.malId = malId;
    }

    public String getFavyn() {
        return favyn;
    }

    public void setFavyn(String favyn) {
        this.favyn = favyn;
    }

    public String getWatchyn() {
        return watchyn;
    }

    public void setWatchyn(String watchyn) {
        this.watchyn = watchyn;
    }

    public String getCompletedyn() {
        return completedyn;
    }

    public void setCompletedyn(String completedyn) {
        this.completedyn = completedyn;
    }

    public String getPlanToWatch() {
        return planToWatch;
    }

    public void setPlanToWatch(String planToWatch) {
        this.planToWatch = planToWatch;
    }

    public int getUserUid() {
        return userUid;
    }

    public void setUserUid(int userUid) {
        this.userUid = userUid;
    }
}
