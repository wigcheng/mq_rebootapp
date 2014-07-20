package com.example.mqreoot;

import java.io.IOException;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.prompt_text)).setText("確定要重開機嗎?");
        ((Button) findViewById(R.id.button_ok)).setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                		try {
                			Runtime.getRuntime().exec(new String[]{"/system/xbin/sunotroot","-c","reboot"});
                		} catch (IOException e) {
                			// TODO Auto-generated catch block
                			e.printStackTrace();
                		}
                    }
                });
        ((Button) findViewById(R.id.button_cancel)).setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    	finish();
                    }
                });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		public PlaceholderFragment() {
		}
	}

}
