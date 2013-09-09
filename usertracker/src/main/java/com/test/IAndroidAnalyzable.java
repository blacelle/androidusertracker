package com.test;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public interface IAndroidAnalyzable {

	void doAnalytics(View v, OnClickListener onClickListener);

	void doAnalytics(View v, OnLongClickListener target);

	void doAnalytics(View view, OnItemClickListener target);

	void doAnalytics(View view, OnItemLongClickListener target);

}
