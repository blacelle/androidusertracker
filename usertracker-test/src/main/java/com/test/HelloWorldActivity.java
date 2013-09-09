package com.test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class HelloWorldActivity extends Activity implements IAndroidAnalyzable {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		test1();

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("Cestparti");
			}
		});

		findViewById(R.id.button1).setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				System.out.println("Cestparti");

				return true;
			}
		});

		{
			ListView lv = (ListView) findViewById(R.id.listView1);
			lv.setAdapter(new ArrayAdapter<String>(this, R.layout.singletextview));

			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub

				}
			});

			lv.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub
					return false;
				}
			});
		}

		{
			String singleKey = "go";
			List<Map<String, String>> groupData = Collections.singletonList(Collections.singletonMap(singleKey, "parent"));
			List<? extends List<? extends Map<String, ?>>> childData = Collections.singletonList(Collections.singletonList(Collections.singletonMap(
					singleKey, "child")));

			ExpandableListView elv = (ExpandableListView) findViewById(R.id.expandableListView1);
			elv.setAdapter(new SimpleExpandableListAdapter(this, groupData, R.layout.singletextview, new String[] { singleKey },
					new int[] { R.id.singletextview }, childData, R.layout.singletextview, new String[] { singleKey },
					new int[] { R.id.singletextview }));

			elv.setOnGroupClickListener(new OnGroupClickListener() {

				@Override
				public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
					// TODO Auto-generated method stub
					return false;
				}
			});
			
			elv.setOnChildClickListener(new OnChildClickListener() {

				@Override
				public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
					// TODO Auto-generated method stub
					return false;
				}
			});
		}
	}

	@Override
	public void doAnalytics(View v, OnClickListener onClickListener) {
		if (v instanceof TextView) {
			System.out.println("Spotted Click on  " + v.getId() + " " + v.getClass() + " " + ((TextView) v).getText());
		} else {
			System.out.println("Spotted Click on  " + v.getId() + " " + v.getClass());
		}
	}

	@Override
	public void doAnalytics(View v, OnLongClickListener target) {
		System.out.println("Spotted Long Click on  " + v.getId());
	}

	public void test1() {
		test1_1();
		test1_2(333);
	}

	public void test1_1() {
		System.out.println("test1_1()");
	}

	public void test1_2(int i) {
		System.out.println("test1_2() + " + i);
	}

	@Override
	public void doAnalytics(View paramView, OnItemClickListener paramOnItemClickListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAnalytics(View view, OnItemLongClickListener target) {
		// TODO Auto-generated method stub
		
	}
}
