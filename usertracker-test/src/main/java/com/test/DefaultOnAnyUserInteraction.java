package com.test;

import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

public class DefaultOnAnyUserInteraction implements IOnUserInteractionListener {

	protected void onViewInteraction(int eventType, View v) {
		if (v == null) {

		} else {
			System.out.println("Interaction with: " + v.getId());
		}
	}

	@Override
	public void onClick(View v) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, v);
	}

	@Override
	public boolean onLongClick(View v) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED, v);

		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, view);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED, view);

		return false;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, v);
		return false;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, null);

	}

	@Override
	public void onCancel(DialogInterface dialog) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, null);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, null);

		return false;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_FOCUSED, null);

		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_FOCUSED, null);
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, null);

		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_CLICKED, null);

		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED, null);

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		onViewInteraction(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED, null);

		return false;
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
