package androidusertracker;

import android.content.Context;
import android.content.ContextWrapper;

import com.test.IAndroidAnalyzable;

public abstract class AnalyzableContext extends ContextWrapper implements IAndroidAnalyzable {

	public AnalyzableContext(Context base) {
		super(base);
	}

}
