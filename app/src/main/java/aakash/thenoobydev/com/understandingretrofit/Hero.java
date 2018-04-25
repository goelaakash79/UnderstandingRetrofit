package aakash.thenoobydev.com.understandingretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thenoobydev on 25/4/18.
 */

public class Hero {

    @SerializedName("name")
    private String heroname;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl;
    private String bio;

    public Hero(String heroname, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.heroname = heroname;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getHeroname() {
        return heroname;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}
