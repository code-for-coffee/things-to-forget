package org.codeforcoffee.thingstoforget;

import java.util.Date;

/**
 * Created by codeforcoffee on 6/16/16.
 */
public class Item {

    private String name;
    private String desc;
    private Date dateCreated;

    public Item(String name, String description) {
        this.name = name;
        this.desc = description;
        this.dateCreated = new Date();
    }

    public String getDateCreated() {
        return dateCreated.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
