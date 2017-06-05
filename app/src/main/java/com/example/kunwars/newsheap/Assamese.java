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

public class Assamese extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayList<News> newsList;
    NewsAdaptor adaptor;
    String url;

    EditText eTxtSearch;

    void initView() {

        listView = (ListView) findViewById(R.id.listViewAssamese);
        eTxtSearch = (EditText) findViewById(R.id.editTextSearch);

        newsList = new ArrayList<>();

        newsList.add(new News(R.drawable.janasadharan, "JANASADHARAN"));
        newsList.add(new News(R.drawable.asomiyapratidin, "ASOMIYA PRATIDIN"));
        newsList.add(new News(R.drawable.amarasom, "AMAR ASOM"));
        newsList.add(new News(R.drawable.asamiyakhabor, "ASSAMIYA KHABOR"));
        newsList.add(new News(R.drawable.dainikagradoot, "DAINIK AGRADOOT"));
        newsList.add(new News(R.drawable.dainikjanambhumi, "THE DAINIK JAMAMBHUMI"));
        newsList.add(new News(R.drawable.ganaadhikar, "GANA ADHIKAR"));

        adaptor = new NewsAdaptor(this, R.layout.listitem, newsList);

        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assamese);
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

            case "JANASADHARAN":
                url = "http://www.janasadharan.in/";
                break;
            case "ASOMIYA PRATIDIN":
                url = "http://www.asomiyapratidin.in/";
                break;
            case "AMAR ASOM":
                url = "http://amarasom.glpublications.in/";
                break;
            case "ASSAMIYA KHABOR":
                url = "http://www.assamiyakhabor.com/";
                break;
            case "DAINIK AGRADOOT":
                url = "http://dainikagradoot.com/";
                break;
            case "THE DAINIK JAMAMBHUMI":
                url = "http://dainikjanambhumi.co.in/";
                break;
            case "GANA ADHIKAR":
                url = "http://www.ganaadhikar.com/";
                break;
        }
        Intent intent = new Intent(Assamese.this, WebViewActivity.class);
        intent.putExtra("urlname",url);
        startActivity(intent);
    }
}
