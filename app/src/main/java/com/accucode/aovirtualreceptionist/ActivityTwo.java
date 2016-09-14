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
import java.util.ArrayList;
import java.util.Properties;

//import javax.mail.*;
//import javax.mail.internet.*;


/**
 * Created by bcarr on 7/8/2016.
 */
public class ActivityTwo extends Activity implements OnClickListener{

//    Button btnNotifyPerson =(Button)findViewById(R.id.btnNotifyPerson);
String emailForUsers ="";
    String[] emailList = { "A. J. Love", "Aaron Ledbetter","Allen Ewert", "Andrew Bristol","Andrew Sager","Artie Moskowitz","Bayliss Carr",
            "Bob Bloom","Brandon Grant","Chad Haynes","Chantal Maestas","Charlie Fedorko","Chris Barr","Connor Price","David Gardner",
            "Dawn Wilson","Don Everett", "Ed Pietzsch","Eric Reed","George Vrontas","Heather Williams","Jake Nguyen","Jeffrey Carlson","Jenna Ricci",
            "Jenny Schillinger","Jim Schneider","John Arenas","Kevin Hughes","Kevin Horgan","Kevin Price","Kevin Reynolds","Kristine Semanic",
            "Laura Pietzsch","Mark Hagger","Mark Lentell","Mark Yantis","Matthew Didier","Meaghan McCormick","Michael Minter","Mike Kleinberg",
            "Morgan Deppe","Nicholas Barr","Nicole Schottleutner","Paul McMahon","Peter Abplanalp","Ray Head","Ryan Eger","Ryan Waxler","Sandy Deskin",
            "Stephanie Wagner","Steve Gundersen","Steven Meister","Teppei Masaki","Travis Plakke","Wyatt Love"
    };
    Button btnNotifyPerson;
//    ArrayAdapter adapter;

    // Email list...
    String AJLove = "alove@accucode.com";
    String AaronLedbetter = "aledbetter@accucode.com";
    String AllenEwert = "aewert@accucode.com";
    String AndrewBristol = "abristol@accucode.com";
    String AndrewSager = "asager@accucode.com";
    String ArtieMoskowitz = "amoskowitz@accucode.com";
    String BaylissCarr = "bcarr@accucode.com";
    String BobBloom = "bloomr@accucode.com";
    String BrandonGrant = "bgrant@accucode.com";
    String ChadHaynes = "chaynes@accucode.com";
    String ChantalMaestas = "cmaestas@accucode.com";
    String CharlieFedorko = "cfedorko@accucode.com";
    String ChrisBarr = "cbarr@accucode.com";
    String ConnorPrice = "cprice@accucode.com";
    String DavidGardner = "dgardner@accucode.com";
    String DawnWilson = "dwilson@accucode.com";
    String DonEverett = "deverett@accucode.com";
    String EdPietzsch = "epietzsch@accucode.com";
    String EricReed = "ereed@accucode.com";
    String GeorgeVrontas = "gvrontas@accucode.com";
    String HeatherWilliams = "hwilliams@accucode.com";
    String JakeNguyen="jnguyen@accucode.com";
    String JeffreyCarlson = "jcarlson@accucode.com";
    String JennaRicci = "jricci@accucode.com";
    String JennySchillinger = "jschillinger@accucode.com";
    String JimSchneider = "jschneider@accucode.com";
    String JohnArenas = "jarenas@accucode.com";
    String KevinHughes = "khughes@accucode.com";
    String KevinHorgan = "khorgan@accucode.com";
    String KevinPrice = "kprice@accucode.com";
    String KevinReynolds = "kreynolds@accucode.com";
    String KristineSemanic = "ksemanic@accucode.com";
    String LauraPietzsch = "lpietzsch@accucode.com";
    String MarkHagger = "mhagger@accucode.com";
    String MarkLentell = "mlentell@accucode.com";
    String MarkYantis = "myantis@accucode.com";
    String MatthewDidier = "mdidier@accucode.com";
    String MeaghanMcCormick = "mmccormick@accucode.com";
    String MichaelMinter = "mminter@accucode.com";
    String MikeKleinberg = "mkleinberg@accucode.com";
    String MorganDeppe = "mdeppe@accucode.com";
    String NicholasBarr = "nbarr@accucode.com";
    String NicoleSchottleutner = "nschottleutner@accucode.com";
    String PaulMcMahon = "pmcmahon@accucode.com";
    String PeterAbplanalp = "pabplanalp@accucode.com";
    String RayHead = "rhead@accucode.com";
    String RyanEger = "reger@accucode.com";
    String RyanWaxler = "rwaxler@accucode.com";
    String SandyDeskin = "sdeskin@accucode.com";
    String StephanieWagner = "swagner@accucode.com";
    String SteveGundersen = "sgundersen@accucode.com";
    String StevenMeister = "smeister@accucode.com";
    String TeppeiMasaki = "tmasaki@accucode.com";
    String TravisPlakke = "tplakke@accucode.com";
    String WyattLove = "wlove@accucode.com";


    @Override
    public void onClick(View view) {
    }

//



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_layout);




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


//                CharSequence selectedUserName = new String();
//                    selectedUserName = (CharSequence)arg0.getItemAtPosition(arg2);


//                String selectedUserEmail = "";
//
////
////              String changeable = "";
//                 ;
//                String nameOfUser = "";
//                String emailOfUser = "";
//                String conCatenatedPerson = "";


//                CharSequence nameOfUserChar = (CharSequence)arg0.getItemAtPosition(arg2);

//                StringBuilder c = new StringBuilder(nameOfUserChar);

//                String aLetter = Character.toString(c.charAt(0));
//                conCatenatedPerson = c.split("\\s+");


                String s = (String) arg0.getItemAtPosition(arg2);
                String[] splitString = s.split("\\s+");
                String firstName = splitString[0];
                String lastName = splitString[splitString.length - 1];
                String firstLetterOfName = firstName.substring(0, 1);
//                String emailForUser = firstLetterOfName + lastName + "@accucode.com";
                final String emailForUser = firstLetterOfName + lastName + "@accucode.com";
                Log.i("CREATED", emailForUser);
                emailForUsers = emailForUser;
//

                NetworkUtilityCallback.initiateRequest(new Runnable() {
                    @Override
                    public void run() {
//
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

//               String nameOfUserString = new String(nameOfUserChar);
//                       String.valueOf(nameOfUserChar);

//                nameOfUser = nameOfUserChar.charAt(0);




//                conCatenatedPerson = nameOfUser.charAt(0);




            //EMAIL SELECTED PEOPLE




//                    NetworkUtilityCallback.initiateRequest(new Runnable() {
//                        @Override
//                        public void run() {
////
//                            final String emailResponse = Utility.httpsPost("https://nzfh6vmdjd.execute-api.us-east-1.amazonaws.com/prod/","bcarr@accucode.com" );
//
//                            runOnUiThread(new Runnable()
//                            {
//                                @Override
//                                public void run()
//                                {
//                                    Toast.makeText(ActivityTwo.this, emailResponse, Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        }
//                    });


//                if((CharSequence)arg0.getItemAtPosition(arg2) == "Bayliss Carr"){
////                    Toast.makeText(ActivityTwo.this, "You have CHOSEN " + (CharSequence)arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();
//
// NetworkUtilityCallback.initiateRequest(new Runnable() {
//                    @Override
//                    public void run() {
//                        String receiver = new String("{\"receiver\":\"bcarr@accucode.com\"}");
//                        final String emailResponse = Utility.httpsPost("https://nzfh6vmdjd.execute-api.us-east-1.amazonaws.com/prod/", receiver );
//
//                        runOnUiThread(new Runnable()
//                        {
//                            @Override
//                            public void run()
//                            {
//                                Toast.makeText(ActivityTwo.this, emailResponse, Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                });
//                }
//
//                if((CharSequence)arg0.getItemAtPosition(arg2) == "Andrew Bristol"){
////                    Toast.makeText(ActivityTwo.this, "You have CHOSEN " + (CharSequence)arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();
//
//
//
//                    NetworkUtilityCallback.initiateRequest(new Runnable() {
//                        @Override
//                        public void run() {
////                            String receiver = new String("{\"receiver\":\"abristol@accucode.com\"}");
////                            final String emailResponse = Utility.httpsPost("https://nzfh6vmdjd.execute-api.us-east-1.amazonaws.com/prod/", emailOfUser);
//
//                            runOnUiThread(new Runnable()
//                            {
//                                @Override
//                                public void run()
//                                {
////                                    Toast.makeText(ActivityTwo.this, emailResponse, Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                        }
//                    });









        //btn OnClick email switch ativiity
        btnNotifyPerson=(Button)findViewById(R.id.btnNotifyPerson);
//        btnNotifyPerson.setBackgroundColor(Color.TRANSPARENT);
        btnNotifyPerson.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent myIntent = new Intent(ActivityTwo.this, ActivityThree.class);
                startActivity(myIntent);
            }
        });
    }


//    public String returnChangeable(String itemSelected){
//
////        if((CharSequence)arg0.getItemAtPosition(arg2) == "Andrew Bristol") {
//
//            String changeable = BaylissCarr;
//            return changeable;
////                    Toast.makeText(ActivityTwo.this, "You have CHOSEN " + (CharSequence)arg0.getItemAtPosition(arg2), Toast.LENGTH_LONG).show();
//
//        }

//        };




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

