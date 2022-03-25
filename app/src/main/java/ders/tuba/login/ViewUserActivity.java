package ders.yasin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewUserActivity extends AppCompatActivity {
    ListView lvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        lvUsers=findViewById(R.id.lv_Users);
        DatabaseClass databaseClass=new DatabaseClass(ViewUserActivity.this);
        ArrayList<String> userList=new ArrayList<String>();
        userList=databaseClass.viewAllUsers();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,userList);
        lvUsers.setAdapter(adapter);

    }
}