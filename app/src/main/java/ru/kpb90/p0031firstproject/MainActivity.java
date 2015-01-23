package ru.kpb90.p0031firstproject;

import android.content.Context;
import android.renderscript.RenderScript;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private String [] arr = {"sdf","234"};
    List<String> arr2 = Arrays.asList("sss","ddd","qqq","fff","sss","ddd","qqq","fff","sss","ddd","qqq");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.main_list);
      //  arr2.addAll(arr2);
        listView.setAdapter(new MyAdapter());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arr2.size();
        }

        @Override
        public String  getItem(int position) {
            return arr2.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_random, parent, false);
            TextView textView = (TextView) view.findViewById(R.id.random_title);
            String text = getItem(position);
            textView.setText(text);
            return view;
        }
    }

}
