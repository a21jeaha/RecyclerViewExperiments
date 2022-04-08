package com.example.recyclerviewexperiments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{  // we implement owen RecyclerViewInterface to enable a clickable recycleView

    private ArrayList<User> userList;
    private RecyclerView recyclerView;

    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = new ArrayList<>();
        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        adapter = new RecyclerAdapter(userList, this);
        // because RecyclerViewInterface was implemented we only need to write "this", to pass it to the adapter
        recyclerView = findViewById(R.id.rvTester);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());   /// try to see if this can be replaced

        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.setItemAnimator(new DefaultItemAnimator());    /// what is this ?

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

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLongItemClick(int position) { // this method removes the user from the position specified
        userList.remove(position);
        adapter.notifyItemRemoved(position); // the adapter needs to know of the changes
    }
}