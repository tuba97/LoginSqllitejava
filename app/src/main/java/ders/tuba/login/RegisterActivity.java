package ders.yasin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etRegisterUN,etRegisterPass,etConfirm,etEmail;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etRegisterUN=findViewById(R.id.et_RegisterUN);
        etRegisterPass=findViewById(R.id.et_RegisterPass);
        etEmail=findViewById(R.id.et_Email);
        etConfirm=findViewById(R.id.et_Confirm);
        btnRegister=findViewById(R.id.btn_Register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etRegisterUN.getText().toString();
                String password=etRegisterPass.getText().toString();
                String email=etEmail.getText().toString();
                String confirmPass=etConfirm.getText().toString();
                if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPass)){
                    if(password.equals(confirmPass)){
                        DatabaseClass databaseObject=new DatabaseClass(RegisterActivity.this);
                        if(databaseObject.insertUser(userName,email,password))
                            Toast.makeText(RegisterActivity.this,"Your account is created successfully",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(RegisterActivity.this,"An error occured",Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(RegisterActivity.this,"Two passwords do not match",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}