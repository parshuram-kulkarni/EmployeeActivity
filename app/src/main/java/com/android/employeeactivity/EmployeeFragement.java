package com.android.employeeactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeFragement extends Fragment {

    public EmployeeFragement() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.list, container, false); /*findViewById(R.id.listItem);*/

        ListView list = view.findViewById(R.id.myList);



        CustomAdapter customAdapter = new CustomAdapter(getContext(), addEmployee());
        list.setAdapter(customAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(),"Click",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), EmployeeInfo.class);
               /* intent.putExtra("image", addEmployee().get(position).getImage());
                intent.putExtra("name", addEmployee().get(position).getName());
                intent.putExtra("designation", addEmployee().get(position).getDesignation());
*/
/*Bundle bundle = new Bundle();
bundle.putString("name", listEmployee.get(position).getName());
bundle.putInt("image", imgs[position]);
DetailActivity detailActivity = new DetailActivity();*/
                EmployeeInfo info = new EmployeeInfo ();

                Bundle args = new Bundle();
                args.putString("name",addEmployee().get(position).getName());
                args.putString("designation",addEmployee().get(position).getDesignation());
                args.putInt("images",addEmployee().get(position).getImage());
                info.setArguments(args);

                //Inflate the fragment
                getFragmentManager().beginTransaction().replace(R.id.frame1, info).commit();


            }
        });

        return view;
    }


    public ArrayList<Employee> addEmployee(){
        final ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ayan", "Manager",  R.drawable.manager));
        employees.add(new Employee("Nikhil", "Software Developer", R.drawable.se));
        employees.add(new Employee("Saurabh", "Civil Engineer", R.drawable.civil));
        employees.add(new Employee("Komal", "HR" , R.drawable.hr));
        employees.add(new Employee("Abhishek", "Architect", R.drawable.architect));
        employees.add(new Employee("Shamlin","Designer", R.drawable.designer));
        return employees;
    }


}
