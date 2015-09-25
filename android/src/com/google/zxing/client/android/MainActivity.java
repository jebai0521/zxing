package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import me.perkd.barscansdk.R;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	
	private TextView resultView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.main);
		
		resultView = (TextView) this.findViewById(R.id.result);
	}

	public void onScanClick(View view) {
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, CaptureActivity.class);
		this.startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {

		case 0:
			
			if (resultCode == Activity.RESULT_OK) {
				String result = data.getExtras().getString("result");//得到新Activity 关闭后返回的数据
				Log.i(TAG, result);
				resultView.setText(result);
			} else {
				
			}
			
			break;
		default:
			break;

		}

		// if (requestCode == 0)
	}
}
