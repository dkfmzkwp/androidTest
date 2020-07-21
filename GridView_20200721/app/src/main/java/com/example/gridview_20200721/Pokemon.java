package com.example.gridview_20200721;

public class Pokemon {
    private int image;
    private int num;
    private String name;

    public Pokemon(int image, String name, int num) {
        this.image = image;
        this.name = name;
        this.num = num;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

