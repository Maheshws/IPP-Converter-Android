package com.maxxxx.ippconverter;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Home extends Activity implements OnClickListener {
	Button IPPHome;
	Button PIPHome;
	Button PPIHome;
	Button EvaluateHome;
	TextView textView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        
        IPPHome=(Button)findViewById(R.id.IPPHome);
        PIPHome=(Button)findViewById(R.id.PIPHome);
        PPIHome=(Button)findViewById(R.id.PPIHome);
        EvaluateHome=(Button)findViewById(R.id.EvaluateHome);
        
        
        PPIHome.setOnClickListener(this);
        PIPHome.setOnClickListener(this);
        IPPHome.setOnClickListener(this);
        EvaluateHome.setOnClickListener(this);
        
               
    }
    public void onClick(View v) {
    	 switch (v.getId()){
		  case R.id.IPPHome:
			  startActivity(new Intent(this, IPPConverter.class));
			  break;
		  case R.id.PPIHome:
			  startActivity(new Intent(this, PPIConverter.class));
			  break;
		  case R.id.PIPHome:
			  startActivity(new Intent(this, PIPConverter.class));
			  break;
		  case R.id.EvaluateHome:
			  break;
    	 }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }

    
}
