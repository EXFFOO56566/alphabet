package com.viavilab.alphabet;

import com.startapp.android.publish.StartAppAd;
import com.viavilab.alphabet.R.string;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity{

	Button btnalpha,btnsmall,btnmore;
	private StartAppAd startAppAd;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
 		super.onCreate(savedInstanceState);
 		StartAppAd.init(this, getString(R.string.startapp_dev_id),getString(R.string.startapp_app_id));
		setContentView(R.layout.main_activity);
		StartAppAd.showSlider(this);
		startAppAd = new StartAppAd(this);
 
		btnalpha=(Button)findViewById(R.id.button_capital);
		btnsmall=(Button)findViewById(R.id.button_small);
		btnmore=(Button)findViewById(R.id.button_more);

		String fontPath = "fonts/ARLRDBD.TTF";
		Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
		btnalpha.setTypeface(tf);
		btnsmall.setTypeface(tf);
		btnmore.setTypeface(tf);
		btnsmall.setPadding(5, 0, 0, 0);

		btnalpha.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "alpha", 5000).show();

				Intent intentalpha=new Intent(getApplicationContext(),CapitalAlphabet_Activity.class);
				startActivity(intentalpha);
			}
		});

		btnsmall.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "small", 5000).show();

				Intent intentasml=new Intent(getApplicationContext(),SmallAlphabet_Activity.class);
				startActivity(intentasml);
			}
		});

		btnmore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "more", 5000).show();
 
				try {
					startActivity(new Intent(Intent.ACTION_VIEW,
							Uri.parse(getString(R.string.more_apps_developer_id))));
				} catch (android.content.ActivityNotFoundException anfe) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse(getString(R.string.more_apps_developer_id)
									)));
				}
			}
		});


	}

	@Override
	public void onResume(){
		super.onResume();
		startAppAd.onResume();
	} 
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {


		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Toast.makeText(appContext, "BAck", Toast.LENGTH_LONG).show();
			AlertDialog.Builder alert = new AlertDialog.Builder(
					MainActivity.this);
			alert.setTitle(string.app_name);
			alert.setIcon(R.drawable.app_icon);
			alert.setMessage("Are You Sure You Want To Quit?");

			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
						int whichButton) {

					startAppAd.onBackPressed();
					finish();

				}



			});

			alert.setNegativeButton("Rate App",
					new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {

					final String appName = getPackageName();
					try {
						startActivity(new Intent(Intent.ACTION_VIEW,
								Uri.parse("market://details?id="
										+ appName)));
					} catch (android.content.ActivityNotFoundException anfe) {
						startActivity(new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("http://play.google.com/store/apps/details?id="
										+ appName)));
					}
				}
			});
			alert.show();
			return true;
		}

		return super.onKeyDown(keyCode, event);

	}

}



