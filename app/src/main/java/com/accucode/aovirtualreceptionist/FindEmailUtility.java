package com.accucode.aovirtualreceptionist;

import android.content.Context;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import java.util.Arrays;

import static android.R.attr.name;

/**
 * Created by jarenas on 10/24/2016.
 */

public class FindEmailUtility {
    private GoogleAccountCredential mCredential;

    static final int REQUEST_ACCOUNT_PICKER = 1000;
    static final int REQUEST_AUTHORIZATION = 1001;
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;

        private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = { SheetsScopes.SPREADSHEETS_READONLY };

    public String FindEmailFor (Context applicationContext, String name){
        mCredential = GoogleAccountCredential.usingOAuth2(
                applicationContext, Arrays.asList(SCOPES))
                .setBackOff(new ExponentialBackOff());
        return "jarenas";

    }

}

