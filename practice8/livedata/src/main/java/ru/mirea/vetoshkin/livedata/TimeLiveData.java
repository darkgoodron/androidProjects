package ru.mirea.vetoshkin.livedata;

import android.annotation.SuppressLint;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class TimeLiveData {
    private static MutableLiveData<Long> data = new MutableLiveData<Long>();
    //sets latest time to LiveData
    static LiveData<Long> getTime(){
        data.setValue(new Date().getTime());
        return data;
    }
    static void setTime(){
        data.setValue(new Date().getTime());
    }
    private static LiveData<String> getStTime = Transformations.map(data, input -> {
        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(calendar.getTime());
    });
    static LiveData<String> getDate(){
        return getStTime;
    }
}
