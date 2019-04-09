package com.example.retrofitexample.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("index")
@Expose
private Integer index;
@SerializedName("about")
@Expose
private String about;
@SerializedName("email")
@Expose
private String email;
@SerializedName("name")
@Expose
private String name;
@SerializedName("picture")
@Expose
private String picture;

public Integer getIndex() {
return index;
}

public void setIndex(Integer index) {
this.index = index;
}

public String getAbout() {
return about;
}

public void setAbout(String about) {
this.about = about;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPicture() {
return picture;
}

public void setPicture(String picture) {
this.picture = picture;
}

}