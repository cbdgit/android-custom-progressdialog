package com.example.customprogressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnShow, btnDismiss;
	private ProgressDialog pd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnShow = (Button) findViewById(R.id.buttonshow);
		btnShow.setOnClickListener(this);
		
		btnDismiss = (Button) findViewById(R.id.buttondismiss);
		btnDismiss.setOnClickListener(this);
		
		pd = CustomProgressDialog.ctor(this, "Cargando/Loading");
		pd.setCancelable(true);
		pd.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.buttonshow:
			pd.show();
			break;
		case R.id.buttondismiss:
			break;
		}
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
	    
		// disable back button functionality
	    if (keyCode == KeyEvent.KEYCODE_BACK) {
	    	pd.dismiss();
        	 return true;
        }
        return false;
	}

}
