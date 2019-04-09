package com.example.retrofitexample.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofitexample.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<String> userList = new ArrayList<String>();

    private ListView userListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        userListView = (ListView) findViewById(R.id.user_list);
        this.showUserList();
    }


    protected void showUserList(){
        userList = (ArrayList<String>) getIntent().getSerializableExtra("userList");

        final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.user_list, userList);

        userListView.setAdapter(listAdapter);

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = listAdapter.getItem(position);
                Toast.makeText(getApplicationContext(),position+"-"+value+"-"+id,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
