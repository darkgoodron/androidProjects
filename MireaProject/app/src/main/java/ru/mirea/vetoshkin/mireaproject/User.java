package ru.mirea.vetoshkin.mireaproject;

public class User {

    private String nickName;
    private String hobby;
    private String city;

    public User(String nickName, String hobby, String city) {

        this.nickName = nickName;
        this.hobby = hobby;
        this.city = city;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setCapital(String hobby) {
        this.hobby = hobby;
    }

    public String getCity() {
        return this.city;
    }

    public void setFlagResource(String city) {
        this.city = city;
    }
}
