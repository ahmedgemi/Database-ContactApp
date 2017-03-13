package com.example.ahmed.contactsave_app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 11/03/17.
 */

public class FragmentView extends Fragment {


    ListView listView;
    Button b1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        listView =(ListView) view.findViewById(R.id.listview);
        b1 = (Button) view.findViewById(R.id.button2);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabase database = new MyDatabase(getActivity());

                ArrayList<Contact> list = database.getData();

                MyAdapter adapter = new MyAdapter(list);

                listView.setAdapter(adapter);
            }
        });




        return view;
    }


    private class MyAdapter extends BaseAdapter{

        ArrayList<Contact> data = new ArrayList<>();


        MyAdapter (ArrayList<Contact> list){

            data = list;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getActivity().getLayoutInflater();

            View view = inflater.inflate(R.layout.listview_layout,parent,false);

            TextView t1 = (TextView) view.findViewById(R.id.textView);
            TextView t2 = (TextView) view.findViewById(R.id.textView2);
            TextView t3 = (TextView) view.findViewById(R.id.textView3);

            t1.setText(data.get(position).name);
            t2.setText(data.get(position).mobile);
            t3.setText(data.get(position).email);


            return view;
        }
    }

}
