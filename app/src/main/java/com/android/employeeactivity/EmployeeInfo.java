package com.android.employeeactivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EmployeeInfo extends Fragment implements View.OnClickListener {

    TextView employeeName, employeeDesignation;
    ImageView employeeImg;
    EmployeeInfo listner;
    private Button backButton;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_info, container, false);


        employeeName = (TextView) view.findViewById(R.id.employeeName);
        employeeDesignation = (TextView) view.findViewById(R.id.textDesignation);
        employeeImg = (ImageView) view.findViewById(R.id.imageOutput);
        backButton = (Button) view.findViewById(R.id.backButton);
        /*String name = intent.getStringExtra("name");*/

        employeeName.setText(getArguments().getString("name"));
        employeeDesignation.setText(getArguments().getString("designation"));
        employeeImg.setImageResource(getArguments().getInt("images"));
        backButton.setOnClickListener(this);
        return view;
    }


    public void onClick(View view) {
        Toast.makeText(getContext(), "Back button pressed", Toast.LENGTH_LONG).show();
        getFragmentManager().beginTransaction().replace(R.id.frame1, new EmployeeFragement()).addToBackStack(null).commit();
    }
}
