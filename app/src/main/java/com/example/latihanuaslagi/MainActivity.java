package com.example.latihanuaslagi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Fragment input, update, delete, showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = new InputFragment();
        update = new UpdateFragment();
        delete = new DeleteFragment();
        showData = new ShowDataFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tf = fm.beginTransaction();
        tf.replace(R.id.Fragment, input).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_navbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.inputItem){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction tf = fm.beginTransaction();
            tf.replace(R.id.Fragment, input).commit();
        }else  if (item.getItemId() == R.id.UpdateItem){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction tf = fm.beginTransaction();
            tf.replace(R.id.Fragment, update).commit();
        }else  if (item.getItemId() == R.id.DeleteItem){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction tf = fm.beginTransaction();
            tf.replace(R.id.Fragment, delete).commit();
        }else  if (item.getItemId() == R.id.ShowItem){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction tf = fm.beginTransaction();
            tf.replace(R.id.Fragment, showData).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}