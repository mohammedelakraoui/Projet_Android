package fr.esgi.record_me;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
  Button start_record;
  Button stop_record;
  AlertDialog message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_record=(Button)findViewById(R.id.btn_start);
        stop_record=(Button) findViewById(R.id.btn_stop);
        start_record.setOnClickListener(action_start);
        stop_record.setOnClickListener(action_stop);
        message = new AlertDialog.Builder(this).create();
        

    }
    
View.OnClickListener action_start= new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		message.setTitle("start");
		message.setMessage("Button start record.");
		message.show();
	}
};
  View.OnClickListener action_stop=new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		
		message.setTitle("stop");
		message.setMessage("Button stop record.");
		message.show();
	}
};  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
