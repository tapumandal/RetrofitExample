package com.example.retrofitexample.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitexample.R;
import com.example.retrofitexample.activity.SecondActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class UserListAdapter extends ArrayAdapter<String> {


    final Activity context;

    final ArrayList<String> userList;
    final ArrayList<String> userEmail;
    final ArrayList<String> userImg;

    public UserListAdapter(Activity context, ArrayList<String> userList, ArrayList<String> userEmail, ArrayList<String> userImg) {
        super(context, R.layout.second_activity, userList);

        this.context = context;
        this.userList = userList;
        this.userEmail = userEmail;
        this.userImg = userImg;
    }

    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.users, null, true);

        ImageView imgView = (ImageView) rowView.findViewById(R.id.user_img);
        TextView userNameView = (TextView) rowView.findViewById(R.id.user_name);
        TextView userEmailView = (TextView) rowView.findViewById(R.id.user_email);


        userNameView.setText(userList.get(position));
        userEmailView.setText(userEmail.get(position));
        Glide.with(context).load(userImg.get(position)).into(imgView);

        return rowView;
    }
}
