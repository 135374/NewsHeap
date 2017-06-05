package com.example.kunwars.newsheap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Marathi extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayList<News> newsList;
    NewsAdaptor adaptor;
    String url;

    EditText eTxtSearch;

    void initView() {

        listView = (ListView) findViewById(R.id.listViewMarathi);
        eTxtSearch = (EditText)findViewById(R.id.editTextSearch);

        newsList = new ArrayList<>();

        newsList.add(new News(R.drawable.divyamarathi, "DIVYA MARATHI"));
        newsList.add(new News(R.drawable.lokmat, "LOKMAT"));
        newsList.add(new News(R.drawable.loksatta, "LOKSATTA"));
        newsList.add(new News(R.drawable.maharashtratimes, "MAHARASHTRA TIMES"));
        newsList.add(new News(R.drawable.pudhari, "PUDHARI NEWS"));

        adaptor = new NewsAdaptor(this, R.layout.listitem, newsList);

        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marathi);
        initView();

        eTxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adaptor.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        News news = newsList.get(position);

        switch (news.getName()) {

            case "DIVYA MARATHI":
                url = "http://divyamarathi.bhaskar.com/";
                break;
            case "LOKMAT":
                url = "http://www.lokmat.com/";
                break;
            case "LOKSATTA":
                url = "http://www.loksatta.com/";
                break;
            case "MAHARASHTRA TIMES":
                url = "http://maharashtratimes.indiatimes.com/";
                break;
            case "PUDHARI NEWS":
                url = "http://www.pudhari.com/";
                break;

        }
        Intent intent = new Intent(Marathi.this, WebViewActivity.class);
        intent.putExtra("urlname",url);
        startActivity(intent);
    }
}
