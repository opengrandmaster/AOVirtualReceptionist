package com.accucode.aovirtualreceptionist;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bcarr on 7/8/2016.
 */
public class ActivityTwo extends Activity implements OnClickListener{


    Button btnGetSheetApiResults;
    GoogleAccountCredential mCredential;
    SheetMe SheetMeObject = new SheetMe();

//    Button btnNotifyPerson =(Button)findViewById(R.id.btnNotifyPerson);
String emailForUsers ="";
    String[] emailList = { "A. J. Love", "Aaron Ledbetter", "Andrew Bristol","Andrew Sager","Bayliss Carr", "Bob Bloom","Brandon Grant", "Cephas Talbot", "Chad Haynes",
            "Chantal Maestas","Charlie Fedorko","Chris Barr","Connor Price","David Gardner","Dakota Deutsch",
            "Dawn Wilson","Don Everett", "Eric Reed","George Vrontas","Heather Carnes","Heather Williams","Jake Nguyen","Jeff Eger", "Jeffrey Carlson","Jenna Ricci",
            "Jenny Schillinger","Jim Schneider","John Arenas","Kayla DeJong", "Kevin Hughes","Kevin Horgan","Kevin Price","Kevin Reynolds","Kristine Semanic",
            "Laura Pietzsch","Mark Hagger","Mark Lentell","Mark Yantis","Matthew Didier","Meaghan McCormick","Michael Minter","Michael Connelly", "Mike Kleinberg",
            "Morgan Deppe","Nicholas Barr","Nicole Schottleutner","Paul McMahon","Peter Abplanalp","Ray Head","Ryan Waxler","Sandy Deskin",
            "Stephanie Wagner","Steve Gundersen","Steven Meister","Teppei Masaki","Travis Plakke","Wyatt Love"
    };
    Button btnNotifyPerson;

    @Override
    public void onClick(View view) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_layout);


        btnGetSheetApiResults = (Button)findViewById(R.id.btnAPISheets);
//        btnGetSheetApiResults.setText(BUTTON_TEXT);
        btnGetSheetApiResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SheetMeObject.getResultsFromApi();

//                mCallApiButton.setEnabled(true);
            }
        });

        //Called when the activity is created.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, emailList);
        //Find TextView control
        final AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.emailACList);
        acTextView.setOnClickListener(this);

        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(1);
        //Set the adapter
        acTextView.setAdapter(adapter);


        //On select
        acTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int arg2, long arg3) {
                Toast.makeText(ActivityTwo.this, "You have selected: " + (String) arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();


                hideKeyboard(ActivityTwo.this);

                String s = (String) arg0.getItemAtPosition(arg2);
                String[] splitString = s.split("\\s+");
                String firstName = splitString[0];
                String lastName = splitString[splitString.length - 1];
                String firstLetterOfName = firstName.substring(0, 1);
//                String emailForUser = firstLetterOfName + lastName + "@accucode.com";
                final String emailForUser = firstLetterOfName + lastName + "@accucode.com";

                // Wyatt...
//                final String emailForUser = new FindEmailUtility().FindEmailFor(getApplicationContext(), s);

                Log.i("CREATED", emailForUser);
                emailForUsers = emailForUser;

                NetworkUtilityCallback.initiateRequest(new Runnable() {
                    @Override
                    public void run() {
                        final String emailResponse = Utility.httpsPost("https://jqluk9ixz6.execute-api.us-east-1.amazonaws.com/prod/","{\"receiver\":\"" + emailForUser  + "\"}" );

                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Toast.makeText(ActivityTwo.this, emailResponse, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }});

        btnNotifyPerson=(Button)findViewById(R.id.btnNotifyPerson);

        final Timer timera = new Timer();
        timera.schedule(new TimerTask() {

            public void run() {

                Intent my3Intent = new Intent(ActivityTwo.this, MainActivity.class);
                startActivity(my3Intent);

            }

        }, 30000);

        btnNotifyPerson.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                timera.cancel();
                Intent myIntent = new Intent(ActivityTwo.this, ActivityThree.class);
                startActivity(myIntent);
            }
        });
    }

    public static void hideKeyboard(Activity activity)
    {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if(view == null)
        {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}