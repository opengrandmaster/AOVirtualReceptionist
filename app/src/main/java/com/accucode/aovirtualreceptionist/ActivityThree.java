package com.accucode.aovirtualreceptionist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by bcarr on 7/8/2016.
 */
public class ActivityThree extends Activity {

    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_layout);



        btnReset=(Button)findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent my3Intent = new Intent(ActivityThree.this, MainActivity.class);
                startActivity(my3Intent);
            }
        });
    }
}
