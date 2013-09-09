package com.test;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public interface IAndroidAnalyzable {

	void doAnalytics(View v, OnClickListener onClickListener);

	void doAnalytics(View v, OnLongClickListener target);

}
