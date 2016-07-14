package ru.binarysimple.searchusers;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private String total_count;
    public ArrayList<User> items;

    public String getTotal_count() {
        return total_count;
    }

    public ArrayList<User> getItems() {
        return items;
    }
}
