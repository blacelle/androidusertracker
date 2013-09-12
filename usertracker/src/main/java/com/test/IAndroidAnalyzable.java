package com.test;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

/**
 * Interface to which any Android user interaction is redirected
 * 
 * @author BLA
 * 
 */
public interface IAndroidAnalyzable {

	/**
	 * See {@link OnClickListener#onClick(View)}
	 */
	void doAnalytics(OnClickListener listener, View view);

	/**
	 * See {@link OnLongClickListener#onLongClick(View)}
	 */
	void doAnalytics(OnLongClickListener listener, View view, boolean returnedValue);

	/**
	 * See {@link OnItemClickListener#onItemClick(AdapterView, View, int, long)}
	 */
	void doAnalytics(OnItemClickListener listener, AdapterView<?> parent, View view, int position, long id);

	/**
	 * See
	 * {@link OnItemLongClickListener#onItemLongClick(AdapterView, View, int, long)}
	 */
	void doAnalytics(OnItemLongClickListener listener, AdapterView<?> parent, View view, int position, long id, boolean returnedValue);

	/**
	 * See
	 * {@link OnGroupClickListener#onGroupClick(ExpandableListView, View, int, long)}
	 */
	void doAnalytics(OnGroupClickListener listener, ExpandableListView parent, View view, int groupPosition, long id, boolean returnedValue);

	/**
	 * {@link OnChildClickListener#onChildClick(ExpandableListView, View, int, int, long)}
	 */
	void doAnalytics(OnChildClickListener listener, ExpandableListView parent, View view, int groupPosition, int childPosition, long id,
			boolean returnedValue);

}
