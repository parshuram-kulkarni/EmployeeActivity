package com.android.employeeactivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import quickutils.core.QuickUtils;

public class MainActivity extends Activity implements DialogInterface.OnClickListener, View.OnClickListener {

    private Button loginButton;
    private EditText textPassword;
    private EditText textUserName;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.buttonLogIn);


        textPassword = (EditText) findViewById(R.id.editTextPassword);
        textUserName = (EditText) findViewById(R.id.editTextUserName);
        Log.i("info", "welcome for validation");
        loginButton.setOnClickListener(this);


        if (Constant.myPassword == null) {
            Constant.myPassword = Constant.defaultPassword;
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                 break;

            case DialogInterface.BUTTON_NEGATIVE:
                Intent intent = new Intent(this, ResetPassword.class);
                startActivityForResult(intent, Constant.resetPasswordKey);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (textUserName.getText().toString().isEmpty()){
            textUserName.requestFocus();
           textUserName.setError("Please enter the username");
        }
        else if (textPassword.getText().toString().isEmpty()) {
            textPassword.setError("Please enter the password");
        }else if(!textUserName.getText().toString().equals(Constant.defaultUserName)){
            textUserName.setError("Please enter valid  the username");
        }
        else {
            password = textPassword.getText().toString();
            if (password.equals(Constant.myPassword)) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, EmployeeActivity.class);
                startActivity(intent);
            } else {
                Log.i("info", "Inside the button");
                AlertDialog alert = new AlertDialog.Builder(this).setMessage("Sorry wrong password")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setTitle("Reset the password")
                        .setPositiveButton("Cancel", this)
                        .setNegativeButton("Reset", this)
                        .create();
                alert.show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constant.resetPasswordKey) {
            String i = data.getStringExtra(Constant.resetExtraKey);
            if (resultCode == RESULT_OK) {
                Constant.myPassword = data.getStringExtra(Constant.resetExtraKey);
                Toast.makeText(MainActivity.this, Constant.myPassword, Toast.LENGTH_LONG).show();
            }
        }
    }
}

 /* else  {
            SpannableString contentText = new SpannableString(textUserName.getText());
            contentText.toString();
        }*/
    /*  else{
            textPassword = (EditText) textPassword.getText();
        }*/
