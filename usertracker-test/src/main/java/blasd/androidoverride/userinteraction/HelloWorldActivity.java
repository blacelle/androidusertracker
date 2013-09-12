package blasd.androidoverride.userinteraction;

import java.util.Arrays;
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
import android.widget.Toast;

import com.test.IAndroidAnalyzable;

/**
 * Simple {@link Activity} demonstrating how any kind of listener is intercepted
 * and redirected towards {@link IAndroidAnalyzable}
 * 
 * @author BLA
 * 
 */
public class HelloWorldActivity extends Activity implements IAndroidAnalyzable {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(HelloWorldActivity.this, OnClickListener.class.getName(), Toast.LENGTH_SHORT).show();
			}
		});

		findViewById(R.id.button1).setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				Toast.makeText(HelloWorldActivity.this, OnLongClickListener.class.getName(), Toast.LENGTH_SHORT).show();

				return true;
			}
		});

		{
			ListView lv = (ListView) findViewById(R.id.listView1);
			lv.setAdapter(new ArrayAdapter<String>(this, R.layout.singletextview, Arrays.asList("single text box")));

			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Toast.makeText(HelloWorldActivity.this, OnItemClickListener.class.getName(), Toast.LENGTH_SHORT).show();
				}
			});

			lv.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
					Toast.makeText(HelloWorldActivity.this, OnItemLongClickListener.class.getName(), Toast.LENGTH_SHORT).show();

					return true;
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
					Toast.makeText(HelloWorldActivity.this, OnGroupClickListener.class.getName(), Toast.LENGTH_SHORT).show();

					return true;
				}
			});

			elv.setOnChildClickListener(new OnChildClickListener() {

				@Override
				public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
					Toast.makeText(HelloWorldActivity.this, OnChildClickListener.class.getName(), Toast.LENGTH_SHORT).show();

					return true;
				}
			});
		}
	}

	protected void doGenericAnalytics(View view, Object listener, Boolean returnedValue) {
		String message = "Spotted Interaction on id=" + view.getId() + " class=" + view.getClass();

		if (view instanceof TextView) {
			message += " Text=" + ((TextView) view).getText();
		}

		if (returnedValue != null) {
			message += " ReturnedValue=" + returnedValue;
		}

		Toast.makeText(HelloWorldActivity.this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void doAnalytics(OnClickListener listener, View view) {
		doGenericAnalytics(view, listener, null);
	}

	@Override
	public void doAnalytics(OnLongClickListener listener, View view, boolean returnedValue) {
		doGenericAnalytics(view, listener, returnedValue);
	}

	@Override
	public void doAnalytics(OnItemClickListener listener, AdapterView<?> parent, View view, int position, long id) {
		doGenericAnalytics(view, listener, null);
	}

	@Override
	public void doAnalytics(OnItemLongClickListener listener, AdapterView<?> parent, View view, int position, long id, boolean returnedValue) {
		doGenericAnalytics(view, listener, returnedValue);
	}

	@Override
	public void doAnalytics(OnGroupClickListener listener, ExpandableListView parent, View view, int groupPosition, long id, boolean returnedValue) {
		doGenericAnalytics(view, listener, returnedValue);
	}

	@Override
	public void doAnalytics(OnChildClickListener listener, ExpandableListView parent, View view, int groupPosition, int childPosition, long id,
			boolean returnedValue) {
		doGenericAnalytics(view, listener, returnedValue);
	}

}
