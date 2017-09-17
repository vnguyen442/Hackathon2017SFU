package edu.wwu.addictionhelperlog;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by dell on 9/16/2017.
 */

public class LogActivity extends AppCompatActivity {
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_log);
    }

    public void insert(View v){
        String date = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        EditText eaddiction = (EditText) findViewById(R.id.eaddiction);
        String addiction = eaddiction.getText().toString();
        EditText ecause = (EditText) findViewById(R.id.ecause);
        String cause = ecause.getText().toString();
        EditText eamount = (EditText) findViewById(R.id.eamount);
        String amount = eamount.getText().toString();
        EditText ecost = (EditText) findViewById(R.id.ecost);
        String cost = ecost.getText().toString();
//        EditText ewho = (EditText) findViewById(R.id.ewho);
//        String who = ewho.getText().toString();
//        EditText ewhere = (EditText) findViewById(R.id.ewhere);
//        String where = ewhere.getText().toString();

        //try{
        Entry logEntry = new Entry(0, date, addiction, cause, amount, cost/*, who, where*/);
        dbManager.insert(logEntry);
        Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show();
        //}
    }

    //public void goBack(View v) { this.finish(); }
}
