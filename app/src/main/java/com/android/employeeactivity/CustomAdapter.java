package com.android.employeeactivity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    List<Employee> emplist;

    public CustomAdapter(Context context, List<Employee> emplist) {
        this.context = context;
        this.emplist = emplist;
    }

    public CustomAdapter(){}

    @Override
    public int getCount() {
        return emplist.size();
    }

    @Override
    public Object getItem(int position) {
        return emplist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_employee_fragement, parent, false);
            TextView empName = (TextView) view.findViewById(R.id.Name);
            TextView empDesignation = (TextView) view.findViewById(R.id.designation);
            ImageView imageView= (ImageView) view.findViewById(R.id.imageView);

            empName.setText(emplist.get(position).getName());
            empDesignation.setText(emplist.get(position).getDesignation());
            imageView.setImageResource(emplist.get(position).getImage());

        }
         // get current item to be displayed
        return view;

    }
}

