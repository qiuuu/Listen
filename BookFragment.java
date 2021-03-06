package com.example.iuuu.listenstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by iuuu on 16/10/18.
 */
public class BookFragment extends Fragment{
    private Button button1;
    private Button button2;
    private View bookView;
    private MainActivity mainActivity;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        mainActivity = (MainActivity)getActivity();
        bookView = inflater.inflate(R.layout.one_fragment,container,false);
        mainActivity.setTitle("change title!");
        Log.v("info","bookFragment");
        button1 = (Button)bookView.findViewById(R.id.button1);
        button2 = (Button)bookView.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("info","bookFragment button1");
                mainActivity.setBook("book1");
                changeView();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.setBook("book2");
                changeView();
            }
        });
        return bookView;
    }
  /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  button1 = (Button)getActivity().findViewById(R.id.button1);
       // button1.setOnClickListener(this);
    }
*/
/*
    @Override
    public void onClick(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                switch (bookView.getId()){
                    case R.id.button1:
                        Log.v("info!!","bookFragment button1");

                        mainActivity.setBook("1");
                        changeView();
                        Log.v("info","bookFragment button1");
                        break;
                    case R.id.button2:
                        mainActivity.setBook("2");
                        changeView();
                        break;
                    default:
                        break;
                }
            }
        }).start();


    }*/


    private void changeView(){
        TitleFragment titleFragment = new TitleFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(this);
        transaction.add(R.id.book_fragment,titleFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}

