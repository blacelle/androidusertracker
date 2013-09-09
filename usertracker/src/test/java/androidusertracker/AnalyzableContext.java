package androidusertracker;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.test.IAndroidAnalyzable;

public abstract class AnalyzableContext extends Context implements IAndroidAnalyzable {

	@Override
	public void doAnalytics(View v, OnClickListener onClickListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doAnalytics(View v, OnLongClickListener target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doAnalytics(View view, OnItemClickListener target) {
		// TODO Auto-generated method stub

	}

	public void doAnalytics(View v, OnItemLongClickListener listener) {
		// TODO Auto-generated method stub
		
	}

}
