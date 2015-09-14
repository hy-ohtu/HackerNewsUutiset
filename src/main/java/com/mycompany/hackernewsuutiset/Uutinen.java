package com.mycompany.hackernewsuutiset;

public class Uutinen {

    private String title;
    private String by;
    private String url;

    @Override
    public String toString() {

        return title + " by " + by + ", url: " + url;
    }

}
