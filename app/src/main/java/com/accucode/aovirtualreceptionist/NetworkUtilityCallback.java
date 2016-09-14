package com.accucode.aovirtualreceptionist;



public abstract class NetworkUtilityCallback {

    public static void initiateRequest(final Runnable callback){
        Runnable emailHttpsThread = new Runnable()
        {
            @Override
            public void run()
            {
                callback.run();
            }
        };


        (new Thread(emailHttpsThread)).start();
    }
}
