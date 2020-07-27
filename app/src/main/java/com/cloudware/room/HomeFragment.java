package com.cloudware.room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button mbtn_add_user, mbtn_view_user;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        mbtn_add_user=view.findViewById(R.id.btn_add_user);
        mbtn_view_user=view.findViewById(R.id.btn_view_user);

        mbtn_add_user.setOnClickListener(this);
        mbtn_view_user.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_user:
                //once we clik our home fragment, it will open to AddUserFragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment())
                        .addToBackStack(null).commit();
                break;

                case R.id.btn_view_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;


        }

    }
}
