package com.styleutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	private Button btnShape, btnSelector, btnLayerList, btnAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		setListener();
	}

	private void initView() {
		btnShape = (Button) findViewById(R.id.btn_shape);
		btnSelector = (Button) findViewById(R.id.btn_selector);
		btnLayerList = (Button) findViewById(R.id.btn_layer_list);
		btnAnimation = (Button) findViewById(R.id.btn_animation);
	}

	private void setListener() {
		btnShape.setOnClickListener(new BtnOnClickListener());
		btnSelector.setOnClickListener(new BtnOnClickListener());
		btnLayerList.setOnClickListener(new BtnOnClickListener());
		btnAnimation.setOnClickListener(new BtnOnClickListener());
	}

	class BtnOnClickListener implements OnClickListener {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			switch (view.getId()) {
			case R.id.btn_shape:
				gotoActivityByClass(ShapeActivity.class);
				break;
			case R.id.btn_selector:
				gotoActivityByClass(SelectorActivity.class);
				break;
			case R.id.btn_layer_list:
				gotoActivityByClass(LayerListActivity.class);
				break;
			case R.id.btn_animation:
				gotoActivityByClass(AnimationActivity.class);
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
