package edu.wwu.addictionhelperlog;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 9/16/2017.
 */

public class EntriesActivity extends AppCompatActivity{
    private DatabaseManager dbManager;
    private ScrollView scrollView;
    private int textViewWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_entries);
        scrollView = (ScrollView)findViewById(R.id.scrollView);
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        textViewWidth = size.x;
        updateView();
    }

    protected void onResume(){
        super.onResume();
        updateView();
    }

    public void updateView(){
        ArrayList<Entry> entries = dbManager.selectAll();
        if(entries.size() > 0){
            scrollView.removeAllViewsInLayout();

            GridLayout grid = new GridLayout(this);
            grid.setRowCount(entries.size());
            grid.setColumnCount(1);

            TextView [] textViews = new TextView[entries.size()];
            int i = 0;
            for(Entry logEntry : entries){
                textViews[i] = new TextView(this);
                textViews[i].setText("Date: " + logEntry.getDate() + "\nAddiction: " + logEntry.getAddiction() +
                        "\nCause: " + logEntry.getCause() + "\nAmount: " + logEntry.getAmount() +
                        "\nCost: " + logEntry.getCost() + "\n");
                grid.addView(textViews[i], textViewWidth, GridLayout.LayoutParams.WRAP_CONTENT);
                i++;
            }
            scrollView.addView(grid);

        }
    }

}
