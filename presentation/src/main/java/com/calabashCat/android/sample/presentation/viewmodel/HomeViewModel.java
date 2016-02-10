package com.calabashCat.android.sample.presentation.viewmodel;

import android.view.View;

import com.calabashCat.android.sample.presentation.navigation.ActivityNavigator;
import com.calabashCat.android.sample.presentation.view.activity.BusinessListActivity;

/**
 * Created by rocko on 15-11-5.
 */
public class HomeViewModel extends ViewModel {

	@Command
	public View.OnClickListener onClickLoadData() {
		return new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				ActivityNavigator.navigateTo(BusinessListActivity.class);
			}
		};
	}
}
