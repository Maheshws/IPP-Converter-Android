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

public class PIPConverter extends Activity implements OnClickListener {
	Button Pre2Post;
	Button Pre2In;
	TextView tRes;
	EditText Exp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pipcon);
        
        
        Pre2Post=(Button)findViewById(R.id.Pre2Post);
        Pre2In=(Button)findViewById(R.id.Pre2In);

        Exp=(EditText)findViewById(R.id.Exp);
        tRes=(TextView)findViewById(R.id.tRes);
        
        
        Pre2Post.setOnClickListener(this);
        Pre2In.setOnClickListener(this);
        
               
    }
	public void onClick(View v) {
		 switch (v.getId()){
		  case R.id.Pre2In:
			  break;
		  case R.id.Pre2Post:
			  break;
   	 }
		
	}

	

}
