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

public class Bengali extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayList<News> newsList;
    NewsAdaptor adaptor;
    String url;

    EditText eTxtSearch;

    void initView() {

        listView = (ListView) findViewById(R.id.listViewBengali);
        eTxtSearch = (EditText)findViewById(R.id.editTextSearch);

        newsList = new ArrayList<>();

        newsList.add(new News(R.drawable.aajkaal, "AAJKAAL"));
        newsList.add(new News(R.drawable.anandbazaar, "ANANDBAZAR PATRIKA"));
        newsList.add(new News(R.drawable.bartamanpatrika, "BRATAMAN PATRIKA"));
        newsList.add(new News(R.drawable.ganashakti, "GANASHAKTI PATRIKA"));
        newsList.add(new News(R.drawable.oneindiabengali, "ONE INDIA BENGALI"));
        newsList.add(new News(R.drawable.uttarbangasambad, "UTTARBANGA SAMBAD"));

        adaptor = new NewsAdaptor(this, R.layout.listitem, newsList);

        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bengali);
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

            case "AAJKAAL":
                url = "http://aajkaal.in/";
                break;
            case "ANANDBAZAR PATRIKA":
                url = "http://www.anandabazar.com/";
                break;
            case "BRATAMAN PATRIKA":
                url = "http://bartamanpatrika.com/";
                break;
            case "GANASHAKTI PATRIKA":
                url = "http://ganashakti.com/bengali/";
                break;
            case "ONE INDIA BENGALI":
                url = "http://bengali.oneindia.com/";
                break;
            case "UTTARBANGA SAMBAD":
                url = "http://www.uttarbangasambad.in/";
                break;
        }
        Intent intent = new Intent(Bengali.this, WebViewActivity.class);
        intent.putExtra("urlname",url);
        startActivity(intent);
    }
}
