/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.calabashCat.android.sample.presentation.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calabashCat.android.sample.presentation.R;
import com.calabashCat.android.sample.presentation.UserCardBinding;
import com.calabashCat.android.sample.presentation.viewmodel.UserCardViewModel;
import com.dexafree.materialList.view.MaterialListView;

/**
 * Fragment that shows a card of Users.
 */
public class BusinessCardFragment extends BaseFragment<UserCardViewModel, UserCardBinding> {

	public final static String TAG = BusinessCardFragment.class.getSimpleName();
	public MaterialListView mListView;

	public BusinessCardFragment() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {


		setBinding(DataBindingUtil.<UserCardBinding>inflate(inflater, R.layout.fragment_user_card_list, container, true));
		setViewModel(new UserCardViewModel(this));
		getBinding().setViewModel(getViewModel());
		setupUI();

		return getBinding().getRoot();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getViewModel().loadUsersCommand();
	}

	private void setupUI() {
		;
	}

	@Override
	public Context getContext() {
		return this.getActivity().getApplicationContext();
	}
}
