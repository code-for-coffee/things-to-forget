package org.codeforcoffee.thingstoforget;

import java.util.ArrayList;

/**
 * Created by codeforcoffee on 6/16/16.
 */
public class TodoList extends ArrayList<Item> {

    private String name;

    public TodoList(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private boolean setName(String name) {
        try {
            this.name = name.toString(); // just in case
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            // todo: err handling
        } finally {
            return false;
        }
    }

}
