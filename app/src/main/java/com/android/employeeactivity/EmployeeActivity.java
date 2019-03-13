package com.android.employeeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    final String Tag = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_activity);

        Fragment fragment = new EmployeeFragement();
        FragmentManager fmanager = getSupportFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();
        ft.replace(R.id.frame1, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }


    boolean twice = false;
    @Override
    public void onBackPressed() {

        Log.d(Tag, "click here");
         if(twice == true)
         {
             Intent intent = new Intent(this, MainActivity.class);
             startActivity(intent);
             finish();
             System.exit(0);
//             startActivityForResult(intent, Constant.resetPasswordKey);
         }
         twice = true;

        Toast.makeText(EmployeeActivity.this, "Please press back again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(Tag , "click here");
            }
        }, 2000);

    }
}
