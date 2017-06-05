package com.example.kunwars.newsheap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayList<News> newsList;
    NewsAdaptor adaptor;
    void initView(){

        listView=(ListView)findViewById(R.id.MyListView);

        newsList = new ArrayList<>();

        newsList.add(new News(R.drawable.english,"ENGLISH"));
        newsList.add(new News(R.drawable.punjabi,"PUNJABI"));
        newsList.add(new News(R.drawable.hindi,"HINDI"));
        newsList.add(new News(R.drawable.bengali,"BENGALI"));
        newsList.add(new News(R.drawable.urdu,"URDU"));
        newsList.add(new News(R.drawable.malyalam,"MALYALAM"));
        newsList.add(new News(R.drawable.tamil,"TAMIL"));
        newsList.add(new News(R.drawable.gujrati,"GUJRATI"));
        newsList.add(new News(R.drawable.marathi,"MARATHI"));
        newsList.add(new News(R.drawable.telugu,"TELUGU"));
        newsList.add(new News(R.drawable.assamese,"ASSAMESE"));
       // newsList.add(new News(R.drawable.others,"OTHERS"));

        adaptor = new NewsAdaptor(this,R.layout.listitem,newsList);

        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent;
        News news = newsList.get(position);

        switch (news.getName()){
            case "ENGLISH":
                intent = new Intent(MainActivity.this , English.class);
                startActivity(intent);
                break;
            case "PUNJABI":
                intent = new Intent(MainActivity.this , Punjabi.class);
                startActivity(intent);
                break;
            case "HINDI":
                intent = new Intent(MainActivity.this , Hindi.class);
                startActivity(intent);
                break;
            case "BENGALI":
                intent = new Intent(MainActivity.this , Bengali.class);
                startActivity(intent);
                break;
            case "URDU":
                intent = new Intent(MainActivity.this, Urdu.class);
                startActivity(intent);
                break;
            case "MALYALAM":
                intent = new Intent(MainActivity.this, Malyalam.class);
                startActivity(intent);
                break;
            case "TAMIL":
                intent = new Intent(MainActivity.this, Tamil.class);
                startActivity(intent);
                break;
            case "GUJRATI":
                intent = new Intent(MainActivity.this, Gujrati.class);
                startActivity(intent);
                break;
            case "MARATHI":
                intent = new Intent(MainActivity.this, Marathi.class);
                startActivity(intent);
                break;
            case "TELUGU":
                intent = new Intent(MainActivity.this, Telgu.class);
                startActivity(intent);
                break;
            case "ASSAMESE":
                intent = new Intent(MainActivity.this, Assamese.class);
                startActivity(intent);
                break;
        }

    }
}
