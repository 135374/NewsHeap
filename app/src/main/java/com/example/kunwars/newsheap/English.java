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

public class English extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<News> newsList;
    NewsAdaptor adaptor;
    String url;

    EditText eTxtSearch;

    void initView() {

        listView = (ListView) findViewById(R.id.listViewEnglish);
        eTxtSearch = (EditText)findViewById(R.id.editTextSearch);

        newsList = new ArrayList<>();

       // newsList.add(new News(R.drawable.timesofindia, "THE TIMES OF INDIA"));
        newsList.add(new News(R.drawable.thetribune, "THE TRIBUNE"));
        newsList.add(new News(R.drawable.theindianexpress, "THE INDIAN EXPRESS"));
        newsList.add(new News(R.drawable.hindustantimes, "HINDUSTAN TIMES"));
        newsList.add(new News(R.drawable.thehindu, "THE HINDU"));
        newsList.add(new News(R.drawable.deccanchronicle, "DECCAN CHRONICLE"));
        newsList.add(new News(R.drawable.thetelegraph,"THE TELEGRAPH"));
        newsList.add(new News(R.drawable.economictimes,"ECONOMIC TIMES"));
        newsList.add(new News(R.drawable.accomodationtimes,"ACCOMMODATION TIMES"));
        newsList.add(new News(R.drawable.centralchronical,"CENTRAL CHRONICLE"));
        newsList.add(new News(R.drawable.sentinel,"SENTINEL ASSAM"));
        newsList.add(new News(R.drawable.businessstandard,"BUSINESS STANDARD"));
        newsList.add(new News(R.drawable.midday,"MID DAY"));
        newsList.add(new News(R.drawable.thestateman,"THE STATESMEN"));
        newsList.add(new News(R.drawable.financialexpress,"FINANCIAL EXPRESS"));

        adaptor = new NewsAdaptor(this, R.layout.listitem, newsList);

        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
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

            case "THE TRIBUNE":
                url = "http://www.tribuneindia.com/";
                break;

            case "THE INDIAN EXPRESS":
                url = "http://indianexpress.com/";
                break;

            case "HINDUSTAN TIMES":
                url = "http://www.hindustantimes.com/";
                break;
            case "THE HINDU":
                url ="http://www.thehindu.com/";
                 break;

            case "TIMES OF INDIA":
                url ="http://timesofindia.indiatimes.com/";
                break;

            case "DECCAN CHRONICLE":
                url = "http://www.deccanchronicle.com/";
                break;
            case "THE TELEGRAPH":
                url = "http://www.telegraphindia.com/";
                break;
            case "ECONOMIC TIMES":
                url = "http://economictimes.indiatimes.com/";
                break;
            case "ACCOMMODATION TIMES":
                url = "http://accommodationtimes.com/";
                break;
            case "CENTRAL CHRONICLE":
                url = "http://centralchronicle.in/";
                break;
            case "SENTINEL ASSAM":
                url = "http://www.sentinelassam.com/";
                break;
            case "BUSINESS STANDARD":
                url = "http://www.business-standard.com/";
                break;
            case "MID DAY":
                url = "http://www.mid-day.com/";
                break;
            case "THE STATESMEN":
                url = "http://www.thestatesman.com/";
                break;
            case "FINANCIAL EXPRESS":
                url = "http://www.financialexpress.com/";
                break;

        }
        Intent intent = new Intent(English.this, WebViewActivity.class);
        intent.putExtra("urlname",url);
        startActivity(intent);
    }
}
