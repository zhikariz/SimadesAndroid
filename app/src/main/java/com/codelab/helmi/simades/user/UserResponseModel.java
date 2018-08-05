package com.codelab.helmi.simades.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class UserResponseModel {
    @SerializedName("result")
    List<UserData> result;

    public List<UserData> getResult() {
        return result;
    }

    public void setResult(List<UserData> result) {
        this.result = result;
    }
}
