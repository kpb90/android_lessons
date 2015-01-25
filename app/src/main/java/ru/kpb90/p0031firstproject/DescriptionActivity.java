package ru.kpb90.p0031firstproject;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import ru.kpb90.p0031firstproject.modal.News;


/**
 * Created by eMachines on 26.01.2015.
 */
public class DescriptionActivity extends ActionBarActivity {
    public final static String EXTRA_NEWS = "EXTRA_NEWS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descr);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            News news = (News) extras.getParcelable(EXTRA_NEWS);
            TextView titleView = (TextView) findViewById(R.id.title_view);
            TextView descrView = (TextView) findViewById(R.id.descr_view);
            titleView.setText(news.getTitle());
            descrView.setText(news.getDescr());
        }
    }

}
