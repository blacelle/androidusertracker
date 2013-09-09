package com.test;

import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

/**
 * Interface capturing all Events propagated down an a native Android listener
 * 
 * @author BLA
 * 
 */
public interface IOnUserInteractionListener extends OnClickListener, OnLongClickListener, OnItemClickListener, OnItemLongClickListener,
		OnGroupClickListener, OnChildClickListener, android.content.DialogInterface.OnClickListener,
		android.content.DialogInterface.OnCancelListener, OnTouchListener, OnGestureListener {

}
