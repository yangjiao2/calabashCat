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
import com.calabashCat.android.sample.presentation.UserListBinding;
import com.calabashCat.android.sample.presentation.view.adapter.BusinessesLayoutManager;
import com.calabashCat.android.sample.presentation.viewmodel.UserListViewModel;

/**
 * Fragment that shows a list of Users.
 */
public class BusinessListFragment extends BaseFragment<UserListViewModel, UserListBinding> {

	public final static String TAG = BusinessListFragment.class.getSimpleName();

	public BusinessListFragment() {
		super();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		setViewModel(new UserListViewModel());
		setBinding(DataBindingUtil.<UserListBinding>inflate(inflater, R.layout.fragment_user_list, container, true));
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
		getBinding().rvUsers.setLayoutManager(new BusinessesLayoutManager(getActivity()));
	}

	@Override
	public Context getContext() {
		return this.getActivity().getApplicationContext();
	}
}
