package com.android.employeeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ResetPassword extends AppCompatActivity implements View.OnClickListener {

    EditText newPassword;
    EditText confirmPassword;
    Button buttonSubmit;
    TextView textAnswer1;
    TextView textAnswer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPassword = (EditText) findViewById(R.id.textNewPassword);
        confirmPassword = (EditText) findViewById(R.id.textConfirmPassword);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);
    }

    public void onClick(View v) {
         if(!newPassword.getText().toString().matches(confirmPassword.getText().toString())){
            Toast.makeText(ResetPassword.this, "NewPassword and ConfirmPassword should be same", Toast.LENGTH_LONG).show();
        }


        else if(newPassword.getText().toString().matches(confirmPassword.getText().toString())){
            Intent intent = new Intent();
            intent.putExtra(Constant.resetExtraKey, newPassword.getText().toString());
            Toast toast = Toast.makeText(ResetPassword.this, "Password Reset Successfully", Toast.LENGTH_LONG);
//            LinearLayout toastLayout = (LinearLayout) toast.getView();
//            TextView toastTV = (TextView) toastLayout.getChildAt(0);
//            toastTV.setTextSize(10);
            toast.show();
            setResult(RESULT_OK, intent);
            finish();
        }else {
            Toast.makeText(ResetPassword.this, "Please Enter Password", Toast.LENGTH_LONG).show();
        }
    }
}
