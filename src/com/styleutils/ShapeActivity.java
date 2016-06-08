package com.styleutils;

import com.styleutils.MainActivity.BtnOnClickListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ShapeActivity extends Activity {

	private static final String TAG = "ShapeActivity";

	private Button btnRectangle, btnOval, btnLine, btnRing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        
        initView();
        setListener();
    }
    
    private void initView() {
    	btnRectangle = (Button) findViewById(R.id.btn_rectangle);
    	btnOval = (Button) findViewById(R.id.btn_oval);
    	btnLine = (Button) findViewById(R.id.btn_line);
    	btnRing = (Button) findViewById(R.id.btn_ring);
	}

	private void setListener() {
		btnRectangle.setOnClickListener(new BtnOnClickListener());
		btnOval.setOnClickListener(new BtnOnClickListener());
		btnLine.setOnClickListener(new BtnOnClickListener());
		btnRing.setOnClickListener(new BtnOnClickListener());
	}

	class BtnOnClickListener implements OnClickListener {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			switch (view.getId()) {
			case R.id.btn_rectangle:
				gotoActivityByClass(RectangleActivity.class);
				break;
			case R.id.btn_oval:
				gotoActivityByClass(OvalActivity.class);
				break;
			case R.id.btn_line:
				gotoActivityByClass(LineActivity.class);
				break;
			case R.id.btn_ring:
				gotoActivityByClass(RingActivity.class);
				break;

			default:
				break;
			}
		}
	}
	
	private void gotoActivityByClass(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}
}
