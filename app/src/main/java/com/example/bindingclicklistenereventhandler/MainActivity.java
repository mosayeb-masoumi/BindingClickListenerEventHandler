package com.example.bindingclicklistenereventhandler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bindingclicklistenereventhandler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

private Contact contact;

private ClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        contact=new Contact("hassan" , "masoumi");
        binding.setContact(contact);


        handler = new ClickHandler(this);
        binding.content.setClickHandler(handler);


    }


    public class ClickHandler{

        Context context;

        public ClickHandler(Context context) {
            this.context = context;
        }

        public void simpleClickButton (View view){
            Toast.makeText(context, "simple Click Button", Toast.LENGTH_SHORT).show();
        }

        public boolean longClickButton (View view){
            Toast.makeText(context, "Long Click Button", Toast.LENGTH_SHORT).show();
            return false;
        }

        public void simpleClickButtonwithParam(View view , Contact contact){
            Toast.makeText(context, "simpleClickButtonwithParam \n" +
                    "first name : "+ contact.getFirstName() +"\n" +
                    "last name : " + contact.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }


}
