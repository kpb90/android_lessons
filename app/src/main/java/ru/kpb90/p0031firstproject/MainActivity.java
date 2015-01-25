package ru.kpb90.p0031firstproject;

import android.content.Context;
import android.content.Intent;
import android.renderscript.RenderScript;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.kpb90.p0031firstproject.modal.News;


public class MainActivity extends ActionBarActivity {
    List<News> newsItems = Arrays.asList(new News("http://allboxing.ru/sites/default/files/styles/new_news-list/public/gassiev2_1.jpg?itok=-KQB5qfE","Мурат Гассиев победил Теренса Смита", "Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита"),
                                         new News("http://allboxing.ru/sites/default/files/styles/new_news-list/public/ufn-stockholm-weighin-0045.jpg?itok=OYK3td0z","Фото: Взвешивание UFC on Fox 14", "Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита"),
                                         new News("http://allboxing.ru/sites/default/files/styles/new_news-list/public/ufn-stockholm-weighin-0045.jpg?itok=OYK3td0z","Фото: Взвешивание UFC on Fox 14", "Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита"),
                                         new News("http://allboxing.ru/sites/default/files/styles/new_news-list/public/ufn-stockholm-weighin-0045.jpg?itok=OYK3td0z","Фото: Взвешивание UFC on Fox 14", "Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита"),
                                         new News("http://allboxing.ru/sites/default/files/styles/new_news-list/public/ufn-stockholm-weighin-0045.jpg?itok=OYK3td0z","Фото: Взвешивание UFC on Fox 14", "Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита Мурат Гассиев победил Теренса Смита"));

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
            return newsItems.size();
        }

        @Override
        public News getItem(int position) {
            return newsItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            View view;

            if (convertView == null || !(convertView.getTag(R.id.tag_holder) instanceof Holder)) {
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_random, parent, false);
                holder = new Holder(view);
                view.setTag(R.id.tag_holder, holder);
            } else {
                view = convertView;
                holder = (Holder) view.getTag(R.id.tag_holder);
            }
            News news = getItem(position);
            holder.fillData(news);
            view.setTag(R.id.tag_content, news);
            view.setOnClickListener(onNewsClickListener);
            return view;
        }

        private class Holder {
            private TextView titleTextView;
            private ImageView imageView;

            private Holder(View view) {
                imageView = (ImageView) view.findViewById(R.id.image_view);
                titleTextView = (TextView) view.findViewById(R.id.text_view);
            }

            public void fillData(News news) {
                titleTextView.setText(news.getTitle());
                Picasso.with(MainActivity.this).load(news.getImageUrl()).into(imageView);
            }

        }

        private final View.OnClickListener onNewsClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getTag(R.id.tag_content) instanceof News) {
                    News news = (News) v.getTag(R.id.tag_content);
                    Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                    intent.putExtra(DescriptionActivity.EXTRA_NEWS, news);
                    startActivity(intent);
                }
            }
        };

    }

}
