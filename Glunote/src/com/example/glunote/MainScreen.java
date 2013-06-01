package com.example.glunote;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class MainScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }
    
    public void TestingPage(View view1) {
    	Intent intent1 = new Intent(this, TestingPageActivity.class);
    	startActivity(intent1);
    }
    
    public void CarbsPage(View view1) {
    	Intent intent1 = new Intent(this, CarbsPageActivity.class);
    	startActivity(intent1);
    }
    
}
