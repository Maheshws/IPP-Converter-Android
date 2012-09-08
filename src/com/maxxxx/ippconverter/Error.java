package com.maxxxx.ippconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Error extends Activity {
	String Message;
	TextView ErrorMessage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);
        

        ErrorMessage=(TextView)findViewById(R.id.ErrorMessage);
        
        Bundle extras = getIntent().getExtras(); 
        if(extras !=null)
        {
         Message = extras.getString("Message");
        }
        
        ErrorMessage.setText(Message);
    }
}
