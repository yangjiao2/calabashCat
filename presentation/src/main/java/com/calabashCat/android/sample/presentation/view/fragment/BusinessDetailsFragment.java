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
import com.calabashCat.android.sample.presentation.UserDetailsBinding;
import com.calabashCat.android.sample.presentation.viewmodel.UserDetailsViewModel;

/**
 * Fragment that shows details of a certain user.
 */
public class BusinessDetailsFragment extends BaseFragment<UserDetailsViewModel, UserDetailsBinding> {

	public final static String TAG = BusinessDetailsFragment.class.getSimpleName();

	private static final String ARGUMENT_KEY_USER_ID = "org.android10.ARGUMENT_USER_ID";

	private int userId;

	public BusinessDetailsFragment() {
		super();

	}

	public static BusinessDetailsFragment newInstance(int userId) {
		BusinessDetailsFragment businessDetailsFragment = new BusinessDetailsFragment();

		Bundle argumentsBundle = new Bundle();
		argumentsBundle.putInt(ARGUMENT_KEY_USER_ID, userId);
		businessDetailsFragment.setArguments(argumentsBundle);

		return businessDetailsFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		setViewModel(new UserDetailsViewModel());
		setBinding(DataBindingUtil.<UserDetailsBinding>inflate(inflater, R.layout.fragment_user_details, container, false));
		getBinding().setViewModel(getViewModel());

		return getBinding().getRoot();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.initialize();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	private void initialize() {
		this.userId = getArguments().getInt(ARGUMENT_KEY_USER_ID);

		getViewModel().loadUserDetailsCommand(userId);
	}

	@Override
	public Context getContext() {
		return getActivity().getApplicationContext();
	}
}
