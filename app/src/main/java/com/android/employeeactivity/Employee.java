package com.android.employeeactivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class Employee {
       private String name;
       private String designation;
       private int image;

    public Employee(String name, String designation, int image) {
        this.name = name;
        this.designation = designation;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
