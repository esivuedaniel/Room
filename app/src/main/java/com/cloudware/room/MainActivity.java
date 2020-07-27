package com.cloudware.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public  static MyAppDataBase myAppDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        myAppDataBase= Room.databaseBuilder(getApplicationContext(), MyAppDataBase.class, "userdb")
                .allowMainThreadQueries().build();  //allowMainThreadQueries allowed DB  on the mainThread


        if (findViewById(R.id.fragment_container) !=null){
            if (savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}
