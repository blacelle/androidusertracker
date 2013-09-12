package android.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

import com.test.IAndroidAnalyzable;
import com.test.IAndroidNotAnalyzable;

/**
 * The Trace aspect injects tracing messages before and after method main of
 * class HelloWorld.
 */

aspect AndroidUserInteractionInterceptor {

	pointcut OnClickListener_onClick(View v)         :execution(void    OnClickListener.onClick(View))         && args(v) && !this(IAndroidNotAnalyzable);

	pointcut OnLongClickListener_onLongClick(View v) :execution(boolean OnLongClickListener.onLongClick(View)) && args(v) && !this(IAndroidNotAnalyzable);

	pointcut OnItemClickListener_onItemClick(AdapterView<?> parent, View view, int position, long id)           :execution(void OnItemClickListener.onItemClick(AdapterView<?>, View, int, long))             && args(parent, view, position, id);

	pointcut OnItemLongClickListener_onItemLongClick(AdapterView<?> parent, View view, int position, long id)   :execution(boolean OnItemLongClickListener.onItemLongClick(AdapterView<?>, View, int, long)) && args(parent, view, position, id) && !this(IAndroidNotAnalyzable);

	pointcut OnGroupClickListener_onGroupClick(ExpandableListView parent, View view, int groupPosition, long id)     :execution(boolean OnGroupClickListener.onGroupClick(ExpandableListView, View, int, long))       && args(parent, view, groupPosition, id);

	pointcut OnChildClickListener_onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id)     :execution(boolean OnChildClickListener.onChildClick(ExpandableListView, View, int, int, long))       && args(parent, view, groupPosition, childPosition, id);

	protected IAndroidAnalyzable getAnalyzable(View v) {
		if (v == null) {
			return null;
		}

		Context c = v.getContext();

		IAndroidAnalyzable analyzable = null;

		if (c instanceof IAndroidAnalyzable) {
			analyzable = (IAndroidAnalyzable) c;
		} else if (c.getApplicationContext() instanceof IAndroidAnalyzable) {
			analyzable = (IAndroidAnalyzable) c.getApplicationContext();
		}

		return analyzable;
	}

	/**
	 * Before if we want to log even if the onCLick method thrown
	 * 
	 * After as we want to log if events returned true or false
	 * 
	 * @param v
	 */
	after(View v) : OnClickListener_onClick(v) {
		IAndroidAnalyzable analyzable = getAnalyzable(v);

		if (analyzable != null) {
			if (thisJoinPoint.getTarget() instanceof OnClickListener) {
				analyzable.doAnalytics((OnClickListener) thisJoinPoint.getTarget(), v);
			} else {
				// TODO: Log unexpected call
			}
		}
	}

	after(View v) returning(boolean returnedValue) : OnLongClickListener_onLongClick(v) {
		IAndroidAnalyzable analyzable = getAnalyzable(v);

		if (analyzable != null) {
			if (thisJoinPoint.getTarget() instanceof OnLongClickListener) {
				analyzable.doAnalytics((OnLongClickListener) thisJoinPoint.getTarget(), v, returnedValue);
			}
		}
	}

	after(AdapterView<?> parent, View view, int position, long id) : OnItemClickListener_onItemClick(parent, view, position, id) {
		IAndroidAnalyzable analyzable = getAnalyzable(view);

		if (analyzable != null) {
			if (thisJoinPoint.getTarget() instanceof OnItemClickListener) {
				analyzable.doAnalytics((OnItemClickListener) thisJoinPoint.getTarget(), parent, view, position, id);
			}
		}
	}

	after(AdapterView<?> parent, View view, int position, long id) returning(boolean returnedValue) : OnItemLongClickListener_onItemLongClick(parent, view, position, id) {
		IAndroidAnalyzable analyzable = getAnalyzable(view);

		if (analyzable != null) {
			if (thisJoinPoint.getTarget() instanceof OnItemLongClickListener) {
				analyzable.doAnalytics((OnItemLongClickListener) thisJoinPoint.getTarget(), parent, view, position, id, returnedValue);
			}
		}
	}

	after(ExpandableListView parent, View view, int groupPosition, long id) returning(boolean returnedValue) : OnGroupClickListener_onGroupClick(parent, view, groupPosition, id) {
		IAndroidAnalyzable analyzable = getAnalyzable(view);

		if (analyzable != null) {
			if (thisJoinPoint.getTarget() instanceof OnGroupClickListener) {
				analyzable.doAnalytics((OnGroupClickListener) thisJoinPoint.getTarget(), parent, view, groupPosition, id, returnedValue);
			}
		}
	}

	after(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) returning(boolean returnedValue) : OnChildClickListener_onChildClick(parent, view, groupPosition, childPosition, id) {
		IAndroidAnalyzable analyzable = getAnalyzable(view);

		if (analyzable != null) {
			if (thisJoinPoint.getTarget() instanceof OnChildClickListener) {
				analyzable.doAnalytics((OnChildClickListener) thisJoinPoint.getTarget(), parent, view, groupPosition, childPosition, id,
						returnedValue);
			}
		}
	}

}
