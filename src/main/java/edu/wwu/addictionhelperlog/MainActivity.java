package edu.wwu.addictionhelperlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //private DatabaseManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
    }

    public void onLog(View v){
        Intent logIntent = new Intent(this, LogActivity.class);
        this.startActivity(logIntent);
    }

    public void onEntries(View v){
        Intent entriesIntent = new Intent(this, EntriesActivity.class);
        startActivity(entriesIntent);
    }

    public void onStats(View v){
        Intent statsIntent = new Intent(this, StatsActivity.class);
        startActivity(statsIntent);
    }

    public void onHelp(View v){
        Intent helpIntent = new Intent(this, HelpActivity.class);
        startActivity(helpIntent);
    }



}
