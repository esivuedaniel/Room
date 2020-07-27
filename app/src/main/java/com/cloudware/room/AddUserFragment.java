package com.cloudware.room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText UserId, UserName, UserEmail;
    private Button mbtn_save;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user, container, false);
        UserId=view.findViewById(R.id.edt_user_id);
        UserName=view.findViewById(R.id.edt_user_name);
        UserEmail= view.findViewById(R.id.edt_user_email);
        mbtn_save = view.findViewById(R.id.btn_save);

        mbtn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId= Integer.parseInt(UserId.getText().toString());
                String userName=UserName.getText().toString();
                String userEmail=UserEmail.getText().toString();

                //Save the above details in a room
                User user=new User();
                user.setId(userId);
                user.setEmail(userEmail);
                user.setName(userName);

                //I saved Id, Name, Email inside myAppDataBase  from mainActivity
                MainActivity.myAppDataBase.myDao().addUser(user);

                Toast.makeText(getActivity(), "successsfully added", Toast.LENGTH_SHORT).show();
                UserEmail.setText("");
                UserId.setText("");
                UserName.setText("");


            }
        });


        return view;
    }
}
