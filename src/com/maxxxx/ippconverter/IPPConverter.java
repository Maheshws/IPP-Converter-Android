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

public class IPPConverter extends Activity implements OnClickListener {
	Button In2Post;
	Button In2Pre;
	TextView tRes;
	EditText Exp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ippcon);
        
        
        In2Post=(Button)findViewById(R.id.In2Post);
        In2Pre=(Button)findViewById(R.id.In2Pre);

        Exp=(EditText)findViewById(R.id.Exp);
        tRes=(TextView)findViewById(R.id.tRes);
        
        
        In2Post.setOnClickListener(this);
        In2Pre.setOnClickListener(this);
        
               
    }
	public void onClick(View v) {
		 switch (v.getId()){
		  case R.id.In2Pre:
			  break;
		  case R.id.In2Post:
			  break;
   	 }
		
	}

	

}
