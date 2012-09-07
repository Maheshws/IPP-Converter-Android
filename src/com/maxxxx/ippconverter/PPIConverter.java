package com.maxxxx.ippconverter;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class PPIConverter extends Activity implements OnClickListener {
	Button Post2In;
	Button Post2Pre;
	TextView tRes;
	EditText Exp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppicon);
        
        
        Post2In=(Button)findViewById(R.id.Post2In);
        Post2Pre=(Button)findViewById(R.id.Post2Pre);

        Exp=(EditText)findViewById(R.id.Exp);
        tRes=(TextView)findViewById(R.id.tRes);
        
        
        Post2In.setOnClickListener(this);
        Post2Pre.setOnClickListener(this);
        
               
    }
	public void onClick(View v) {
		 switch (v.getId()){
		  case R.id.Post2Pre:
			  break;
		  case R.id.Post2In:
			  break;
   	 }
		
	}

	

}
