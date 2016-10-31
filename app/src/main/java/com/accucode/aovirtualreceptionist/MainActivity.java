package com.accucode.aovirtualreceptionist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.telephony.gsm.SmsManager;
import android.widget.TextView;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ServiceException;

import java.util.Arrays;

public class MainActivity extends Activity {
    Button btnTransfer;
    private static final String BUTTON_TEXT = "Call Google Sheets API";
    private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = { SheetsScopes.SPREADSHEETS_READONLY };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTransfer=(Button)findViewById(R.id.btnTransfer);
        btnTransfer.setBackgroundColor(Color.TRANSPARENT);
        btnTransfer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(myIntent);
            }
        });
    }

}