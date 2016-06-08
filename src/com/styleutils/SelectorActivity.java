package com.styleutils;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SelectorActivity extends Activity {

	private static final String TAG = "SelectorActivity";

	private Button btnActivate, btnSelect;
	private ListView listView;
	private ArrayList<String> mArrayList = new ArrayList<String>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        
        initView();
        setListener();
        
        getData();
        listView.setAdapter(new MyAdapter());
    }
    
    private void initView() {
    	btnActivate = (Button) findViewById(R.id.btn_activate);
    	btnSelect = (Button) findViewById(R.id.btn_select);
    	listView = (ListView) findViewById(R.id.listview);
    }
    
    private void setListener() {
    	btnActivate.setOnClickListener(new ButtonClickListener());
    	btnSelect.setOnClickListener(new ButtonClickListener());
    	listView.setOnItemClickListener(new ListItemClickListener());
    }
    
    class ButtonClickListener implements OnClickListener {
    	@Override
    	public void onClick(View v) {
    		//Log.i(TAG, btnActivate.isActivated() + " " + btnSelect.isSelected());
    		// TODO Auto-generated method stub
    		switch (v.getId()) {
			case R.id.btn_activate:
				if (btnActivate.isActivated()) {
					btnActivate.setActivated(false);
					btnActivate.setText("未激活");
				} else {
					btnActivate.setActivated(true);
					btnActivate.setText("已激活");
				}
				break;
			case R.id.btn_select:
				if (btnSelect.isSelected()) {
					btnSelect.setSelected(false);
					btnSelect.setText("未选中");
				} else {
					btnSelect.setSelected(true);
					btnSelect.setText("已选中");
				}
				break;

			default:
				break;
			}
    		
    	}
    }
    
    class ListItemClickListener implements OnItemClickListener {
    	@Override
    	public void onItemClick(AdapterView<?> parent, View view, int position,
    			long id) {
    		// TODO Auto-generated method stub
    		Log.i(TAG, " " + view.isFocused() + "" + view.isSelected());
    		Toast.makeText(SelectorActivity.this, "Item click on " + position, Toast.LENGTH_SHORT).show();
    	}
    }
    
    private ArrayList<String> getData() {
    	mArrayList.add("测试数据0");
    	mArrayList.add("测试数据1");
    	mArrayList.add("测试数据2");
    	mArrayList.add("测试数据3");
    	mArrayList.add("测试数据4");
    	mArrayList.add("测试数据5");
    	mArrayList.add("测试数据6");
    	mArrayList.add("测试数据7");
    	mArrayList.add("测试数据8");
    	mArrayList.add("测试数据9");
    	return mArrayList;
    }
    
    class MyAdapter extends BaseAdapter {
    	private LayoutInflater inflater;

    	public MyAdapter() {
			// TODO Auto-generated constructor stub
    		inflater = LayoutInflater.from(SelectorActivity.this);
		}
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mArrayList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mArrayList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.list_item, parent, false);
				holder = new ViewHolder();
				holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
				holder.btn = (Button) convertView.findViewById(R.id.btn);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.tvTitle.setText(mArrayList.get(position));
			holder.btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(SelectorActivity.this, "Button " + position + "click", Toast.LENGTH_SHORT).show();
				}
			});
			
			return convertView;
		}
    	
    	class ViewHolder {
    		TextView tvTitle;
    		Button btn;
    	}
    }
}
