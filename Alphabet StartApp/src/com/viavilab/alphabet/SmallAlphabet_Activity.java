package com.viavilab.alphabet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import com.startapp.android.publish.StartAppAd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SmallAlphabet_Activity extends Activity{

	ImageView imgback,imgmute,imgnext,imgprev;
	ViewPager viewalpha;
	ImageView imageView;
	String fileName=null;
	private static int TOTAL_IMAGES;
	private int currentPosition = 0;
	TextView tx1;
	ImageView imgplay,imgstop;
	Handler handler;
	Runnable Update;

	public static final int SOUND_1 = 1;
	public static final int SOUND_2 = 2;
	public static final int SOUND_3 = 3;
	public static final int SOUND_4 = 4;
	public static final int SOUND_5 = 5;
	public static final int SOUND_6 = 6;
	public static final int SOUND_7 = 7;
	public static final int SOUND_8 = 8;
	public static final int SOUND_9 = 9;
	public static final int SOUND_10 = 10;
	public static final int SOUND_11 = 11;
	public static final int SOUND_12 = 12;
	public static final int SOUND_13 = 13;
	public static final int SOUND_14 = 14;
	public static final int SOUND_15 = 15;
	public static final int SOUND_16 = 16;
	public static final int SOUND_17 = 17;
	public static final int SOUND_18 = 18;
	public static final int SOUND_19 = 19;
	public static final int SOUND_20 = 20;
	public static final int SOUND_21 = 21;
	public static final int SOUND_22 = 22;
	public static final int SOUND_23 = 23;
	public static final int SOUND_24 = 24;
	public static final int SOUND_25 = 25;
	public static final int SOUND_26 = 26;

	SoundPool mSoundPool;
	HashMap<Integer, Integer> mSoundMap;

	private Integer[] mThumbId=
		{
			R.drawable.a,  R.drawable.b,  R.drawable.c, R.drawable.d,
			R.drawable.e,  R.drawable.f,  R.drawable.g, R.drawable.h,
			R.drawable.i,  R.drawable.j,  R.drawable.k, R.drawable.l,
			R.drawable.m,  R.drawable.n,  R.drawable.o, R.drawable.p,
			R.drawable.q,  R.drawable.r,  R.drawable.s, R.drawable.t,
			R.drawable.u,  R.drawable.v,  R.drawable.w, R.drawable.x,
			R.drawable.y,  R.drawable.z,   

		};

	float volume;
	boolean isplay=true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		StartAppAd.init(this, getString(R.string.startapp_dev_id),getString(R.string.startapp_app_id));
		setContentView(R.layout.alphabet_activity);
		StartAppAd.showSlider(this);

		imgback=(ImageView)findViewById(R.id.imageView_back);
		imgmute=(ImageView)findViewById(R.id.imageView1_about);
		imgprev=(ImageView)findViewById(R.id.imageView1_prevbtn);
		imgnext=(ImageView)findViewById(R.id.imageView2_nextbtn);
		viewalpha=(ViewPager)findViewById(R.id.view_pageralpha);
		imgplay=(ImageView)findViewById(R.id.imageView1_play);
		imgstop=(ImageView)findViewById(R.id.imageView1_stop);
		tx1=(TextView)findViewById(R.id.textView1);

		String fontPath = "fonts/ARLRDBD.TTF";
		Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
		tx1.setTypeface(tf);

		ImagePagerAdapter adapter = new ImagePagerAdapter();
		viewalpha.setAdapter(adapter);

		mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
		mSoundMap = new HashMap<Integer, Integer>();
		handler=new Handler();

		if(mSoundPool != null){
			mSoundMap.put(SOUND_1, mSoundPool.load(this, R.raw.a, 1));
			mSoundMap.put(SOUND_2, mSoundPool.load(this, R.raw.b, 1));
			mSoundMap.put(SOUND_3, mSoundPool.load(this, R.raw.c, 1));
			mSoundMap.put(SOUND_4, mSoundPool.load(this, R.raw.d, 1));
			mSoundMap.put(SOUND_5, mSoundPool.load(this, R.raw.e, 1));
			mSoundMap.put(SOUND_6, mSoundPool.load(this, R.raw.f, 1));
			mSoundMap.put(SOUND_7, mSoundPool.load(this, R.raw.g, 1));
			mSoundMap.put(SOUND_8, mSoundPool.load(this, R.raw.h, 1));
			mSoundMap.put(SOUND_9, mSoundPool.load(this, R.raw.i, 1));
			mSoundMap.put(SOUND_10, mSoundPool.load(this, R.raw.j, 1));
			mSoundMap.put(SOUND_11, mSoundPool.load(this, R.raw.k, 1));
			mSoundMap.put(SOUND_12, mSoundPool.load(this, R.raw.l, 1));
			mSoundMap.put(SOUND_13, mSoundPool.load(this, R.raw.m, 1));
			mSoundMap.put(SOUND_14, mSoundPool.load(this, R.raw.n, 1));
			mSoundMap.put(SOUND_15, mSoundPool.load(this, R.raw.o, 1));
			mSoundMap.put(SOUND_16, mSoundPool.load(this, R.raw.p, 1));
			mSoundMap.put(SOUND_17, mSoundPool.load(this, R.raw.q, 1));
			mSoundMap.put(SOUND_18, mSoundPool.load(this, R.raw.r, 1));
			mSoundMap.put(SOUND_19, mSoundPool.load(this, R.raw.s, 1));
			mSoundMap.put(SOUND_20, mSoundPool.load(this, R.raw.t, 1));
			mSoundMap.put(SOUND_21, mSoundPool.load(this, R.raw.u, 1));
			mSoundMap.put(SOUND_22, mSoundPool.load(this, R.raw.v, 1));
			mSoundMap.put(SOUND_23, mSoundPool.load(this, R.raw.w, 1));
			mSoundMap.put(SOUND_24, mSoundPool.load(this, R.raw.x, 1));
			mSoundMap.put(SOUND_25, mSoundPool.load(this, R.raw. y, 1));
			mSoundMap.put(SOUND_26, mSoundPool.load(this, R.raw.z, 1)); 

		}

		AudioManager mgr = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
		float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		volume = streamVolumeCurrent / streamVolumeMax; 

		if(isplay)
		{
			if(mSoundPool != null){
				mSoundPool.play(mSoundMap.get(1), volume, volume, 1, 0, 1.0f);
				isplay=true;
			}
		}
		else
		{
			mSoundPool.stop(mSoundMap.get(1));
			isplay=false;
		}

		TOTAL_IMAGES = (mThumbId.length - 1);
		tx1.setText("Small Alphabet");

		viewalpha.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

				if(isplay)
				{
					if(mSoundPool != null){
						mSoundPool.play(mSoundMap.get(arg0+1), volume, volume, 1, 0, 1.0f);
					}
				}
				else
				{
					mSoundPool.stop(mSoundMap.get(arg0+1));
					isplay=false;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		imgprev.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				currentPosition = viewalpha.getCurrentItem();

				int positionToMoveTo = currentPosition;
				positionToMoveTo--;
				if (positionToMoveTo < 0) {
					positionToMoveTo = TOTAL_IMAGES;
				}
				if(isplay)
				{
					if(mSoundPool != null){
						mSoundPool.play(mSoundMap.get(positionToMoveTo+1), volume, volume, 1, 0, 1.0f);
					}
				}
				else
				{
					mSoundPool.stop(mSoundMap.get(positionToMoveTo+1));
					isplay=false;
				}
				viewalpha.setCurrentItem(positionToMoveTo);
			}
		});


		imgnext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				currentPosition = viewalpha.getCurrentItem();

				int positionToMoveTo = currentPosition;
				positionToMoveTo++;
				if (currentPosition == TOTAL_IMAGES) {
					positionToMoveTo = 0;
				}
				if(isplay)
				{
					if(mSoundPool != null){
						mSoundPool.play(mSoundMap.get(positionToMoveTo+1), volume, volume, 1, 0, 1.0f);
					}
				}
				else
				{
					mSoundPool.stop(mSoundMap.get(positionToMoveTo+1));
					isplay=false;
				}
				viewalpha.setCurrentItem(positionToMoveTo);
			}
		});

		imgback.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				onBackPressed();

			}
		});

		imgmute.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isplay)
				{
					if(mSoundPool != null){
						mSoundPool.stop(mSoundMap.get(1));
						isplay=false;
						imgmute.setImageResource(R.drawable.mute_btn);
					}
				}
				else
				{
					currentPosition = viewalpha.getCurrentItem();
					mSoundPool.play(mSoundMap.get(currentPosition+1), volume, volume, 1, 0, 1.0f);
					isplay=true;
					imgmute.setImageResource(R.drawable.play_mute_btn);
				}
			}
		});

		imgplay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				playauto();
				imgnext.setVisibility(View.INVISIBLE);
				imgprev.setVisibility(View.INVISIBLE);
			}
		});

		imgstop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				handler.removeCallbacks(Update);
				imgnext.setVisibility(View.VISIBLE);
				imgprev.setVisibility(View.VISIBLE);

			}
		});

	}



	protected int getItem(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	private class ImagePagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mThumbId.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == ((ImageView) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Context context = SmallAlphabet_Activity.this;
			imageView = new ImageView(context);
			//		       int padding = context.getResources().getDimensionPixelSize(
			//		           R.dimen.padding_medium);
			//		       imageView.setPadding(padding, padding, padding, padding);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setImageResource(mThumbId[position]);
			((ViewPager) container).addView(imageView, 0);

			return imageView;

		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((ImageView) object);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alphabet, menu);
		return true;

	}
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{
		case R.id.Save:
			this.save();
			return true;
			//  Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
		case R.id.About:
			Intent intentabout=new Intent(getApplicationContext(),AboutActivity.class);
			startActivity(intentabout);
			return true;
		case R.id.Share:
			viewalpha.buildDrawingCache();
			String path = Environment.getExternalStorageDirectory().toString();
			OutputStream fOut = null;
			File file = new File(path,
					"Android/data/com.viavilab.kidsalphabet;/cache/share_cache.jpg");
			file.getParentFile().mkdirs();

			try {
				file.createNewFile();
			} catch (Exception e) {
				//Log.e("draw_save", e.toString());
			}

			try {
				fOut = new FileOutputStream(file);
			} catch (Exception e) {
				//Log.e("draw_save1", e.toString());
			}

			if (this.viewalpha.getDrawingCache() == null) {
				//Log.e("lal", "tis null");
			}

			this.viewalpha.getDrawingCache()
			.compress(Bitmap.CompressFormat.JPEG, 85, fOut);

			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
				//Log.e("draw_save1", e.toString());
			}

			Intent share = new Intent(Intent.ACTION_SEND);
			share.setType("image/jpeg");
			share.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file.getAbsolutePath()));

			startActivity(Intent.createChooser(share, "Share Image"));
			return true;

		case R.id.RateApp:
			final String appName = getPackageName();
			try {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("market://details?id=" + appName)));
			} catch (android.content.ActivityNotFoundException anfe) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://play.google.com/store/apps/details?id="
								+ appName)));
			}
			return true;
		}

		return(super.onOptionsItemSelected(item));
	}

	public void save() { // called on save menu
		//Log.e("saving1", "a");
		if (this.fileName == null) {
			//Log.e("saving2", "a");
			this.saveDialog();
		} else {
			//Log.e("saving3", "a");
			this.saveToFile(this.fileName);
		}
	}

	public void saveDialog() {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Save file...");
		alert.setMessage("File name to save ");
		final EditText input = new EditText(this);
		input.setText("");
		alert.setView(input);

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				String fname = input.getText().toString();
				if(fname.equalsIgnoreCase(""))
				{
					Toast.makeText(getApplicationContext(), "Please Enter File Name", Toast.LENGTH_SHORT).show();
				}
				else
				{
					String path = Environment.getExternalStorageDirectory().toString();
					File f = new File(path, getString(R.string.app_name)+"/" + fname + ".jpg");
					Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();

					if (f.exists()) {
						SmallAlphabet_Activity.this.fileExistsConfirmationDialog(fname);
					} else {
						SmallAlphabet_Activity.this.saveToFile(fname);
					}
				}
			}
		});

		alert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});

		alert.show();
	}

	public void fileExistsConfirmationDialog(final String fname) {
		AlertDialog.Builder alert = new AlertDialog.Builder(SmallAlphabet_Activity.this);
		alert.setTitle("Error");
		alert.setMessage("The file \"" + fname
				+ "\" already exists, do you wish to overwrite it?");
		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				SmallAlphabet_Activity.this.saveToFile(fname);
			}
		});

		alert.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});

		alert.show();
	}

	public void saveToFile(String fname) {
		this.viewalpha.setDrawingCacheEnabled(true);
		this.viewalpha.invalidate();
		String path = Environment.getExternalStorageDirectory().toString();
		OutputStream fOut = null;
		File file = new File(path, getString(R.string.app_name)+"/" + fname + ".jpg");
		file.getParentFile().mkdirs();

		try {
			file.createNewFile();
		} catch (Exception e) {
			//Log.e("draw_save", e.toString());
		}

		try {
			fOut = new FileOutputStream(file);
		} catch (Exception e) {
			//Log.e("draw_save1", e.toString());
		}

		if (this.viewalpha.getDrawingCache() == null) {
			//Log.e("lal", "tis null");
		}

		this.viewalpha.getDrawingCache()
		.compress(Bitmap.CompressFormat.JPEG, 85, fOut);

		try {
			fOut.flush();
			fOut.close();
		} catch (IOException e) {
			//Log.e("draw_save1", e.toString());
		}
	}

	public void playauto()
	{
		Update=new Runnable() {

			@Override
			public void run() {
				playauto();
				// TODO Auto-generated method stub
				if(mSoundPool != null){
					mSoundPool.play(mSoundMap.get(currentPosition+1), volume, volume, 1, 0, 1.0f);
					viewalpha.setCurrentItem(currentPosition);
				}
				currentPosition++;
				if(currentPosition==TOTAL_IMAGES+1)
				{
					currentPosition=0;
				}

			}
		};

		handler.postDelayed(Update, 1000);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(Update);

	}
}
