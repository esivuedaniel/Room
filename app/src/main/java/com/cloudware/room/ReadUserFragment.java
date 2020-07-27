package com.cloudware.room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView mtxt_display_info;
    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_user, container, false);
        mtxt_display_info=view.findViewById(R.id.txt_display_info);

        List<User> users=MainActivity.myAppDataBase.myDao().getUser();

        String info="";

        for (User us: users){
            int id=us.getId();
            String name=us.getName();
            String email=us.getEmail();

            info= info+"\n\n"+"id: "+id+"\n\n name: "+name+"\n\n email: "+email;
        }

        mtxt_display_info.setText(info);

        return view;
    }
}
