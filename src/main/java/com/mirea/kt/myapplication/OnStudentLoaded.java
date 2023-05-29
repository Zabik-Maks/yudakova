package com.mirea.kt.myapplication;

public interface OnStudentLoaded {
    void onSuccessLoad(String text, String avaUrl);
    void onFailed(String textError);
}
