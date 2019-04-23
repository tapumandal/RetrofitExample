package com.example.retrofitexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitexample.R;
import com.example.retrofitexample.model.User;
import com.example.retrofitexample.model.UsersData;
import com.example.retrofitexample.network.ApiClient;
import com.example.retrofitexample.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private ArrayList<String> userList = new ArrayList<String>();
    private ArrayList<String> userEmail = new ArrayList<String>();
    private ArrayList<String> userImg = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void getData(View view) {


        ApiService service = ApiClient.getInstance().create(ApiService.class);


        Call<List<User>> call = service.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {


                String name = response.body().get(0).getName();

                textView.setText(name);

                for(int i=0; i<response.body().size(); i++){
                    userList.add(response.body().get(i).getName());
                    userEmail.add(response.body().get(i).getEmail());
                    userImg.add(response.body().get(i).getPicture());
                }


            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed to connect " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void goSecondActivity(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("userList", this.userList);
        intent.putExtra("userEmail", this.userEmail);
        intent.putExtra("userImg", this.userImg);
        startActivity(intent);
    }

    public void goRecyclerList(View view) {
        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);

//        intent.putExtra("userList", this.userList);
//        intent.putExtra("userEmail", this.userEmail);
//        intent.putExtra("userImg", this.userImg);

        UsersData usersData = new UsersData();
        usersData.setAllName(this.userList);
        usersData.setAllEmail(this.userEmail);
        usersData.setAllImageUrl(this.userImg);

        startActivity(intent);
    }
}
