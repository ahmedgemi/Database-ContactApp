package com.example.ahmed.contactsave_app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ahmed on 11/03/17.
 */

public class FragmentAdd extends Fragment {


    EditText e1,e2,e3;
    Button b1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment1_layout,container,false);


        e1 = (EditText) view.findViewById(R.id.editText);
        e2 = (EditText) view.findViewById(R.id.editText2);
        e3 = (EditText) view.findViewById(R.id.editText3);

        b1 = (Button) view.findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = e1.getText().toString();
                String mobile = e2.getText().toString();
                String email = e3.getText().toString();

                Contact contact = new Contact(name,mobile,email);


                MyDatabase database = new MyDatabase(getActivity());

                database.insert(contact);

            }
        });

        return view;
    }
}
