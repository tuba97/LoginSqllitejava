package ders.yasin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etLoginUN,etLoginPass;
    TextView tvNewUser;
    Button btnLogin, btnViewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etLoginPass=findViewById(R.id.et_LoginPass);
        etLoginUN=findViewById(R.id.et_LoginUN);
        btnLogin=findViewById(R.id.btn_Login);
        tvNewUser=findViewById(R.id.tv_NewUser);
        btnViewUsers=findViewById(R.id.btn_AllUsers);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etLoginUN.getText().toString();
                String password=etLoginPass.getText().toString();
                if(!TextUtils.isEmpty(userName)&& !TextUtils.isEmpty(password)){
                    DatabaseClass databaseObject=new DatabaseClass(LoginActivity.this);
                    String realPassword=databaseObject.findUser(userName);
                    if(password.equals(realPassword)){
                        Intent i=new Intent(LoginActivity.this,WelcomeActivity.class);
                        i.putExtra("USERNAME",userName);
                        startActivity(i);
                    }else
                        Toast.makeText(getApplicationContext(),"Username or password is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        btnViewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,ViewUserActivity.class);
                startActivity(i);
            }
        });
    }
}