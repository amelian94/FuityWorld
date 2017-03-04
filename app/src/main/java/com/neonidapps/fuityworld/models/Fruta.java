package com.neonidapps.fuityworld.models;

/**
 * Created by Neonidas on 02/03/2017.
 */

public class Fruta {

    private String name;
    private String origin;
    private int refIcon;

    public Fruta(String name, String origin, int refIcon) {

        this.name = name;
        this.origin = origin;
        this.refIcon = refIcon;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getRefIcon() {
        return refIcon;
    }

    public void setRefIcon(int refIcon) {
        this.refIcon = refIcon;
    }


}
