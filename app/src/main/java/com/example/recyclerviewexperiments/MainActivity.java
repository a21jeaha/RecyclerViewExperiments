package com.example.recyclerviewexperiments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<>();
        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(userList);
        recyclerView = findViewById(R.id.rvTester);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());   /// try to see if this can be replaced

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);



    }

    private void setUserInfo(){

        userList.add(new User("Max"));
        userList.add(new User("Sara"));
        userList.add(new User("Ben"));
        userList.add(new User("Marie"));
        userList.add(new User("Carl"));
        userList.add(new User("Phone"));
        userList.add(new User("Xerxes"));
        userList.add(new User("Hellen"));
        userList.add(new User("Hank"));
        userList.add(new User("Bell"));
        userList.add(new User("Bark"));
        userList.add(new User("Maria"));
        userList.add(new User("Hunk"));
        userList.add(new User("Redfield"));
        userList.add(new User("Chris"));
        userList.add(new User("Ninja"));
        userList.add(new User("Hanna"));
    }
}