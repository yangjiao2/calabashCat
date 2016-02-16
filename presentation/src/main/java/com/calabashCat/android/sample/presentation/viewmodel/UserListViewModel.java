package com.calabashCat.android.sample.presentation.viewmodel;


import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.calabashCat.android.sample.data.dto.User;
import com.calabashCat.android.sample.domain.interactor.DefaultSubscriber;
import com.calabashCat.android.sample.domain.interactor.GetUserList;
import com.calabashCat.android.sample.domain.interactor.UseCase;
import com.calabashCat.android.sample.presentation.AndroidApplication;
import com.calabashCat.android.sample.presentation.mapper.UserModelDataMapper;
import com.calabashCat.android.sample.presentation.model.UserModel;
import com.calabashCat.android.sample.presentation.navigation.ActivityNavigator;
import com.calabashCat.android.sample.presentation.view.activity.BusinessDetailsActivity;
import com.calabashCat.android.sample.presentation.view.adapter.BusinessesAdapter;
import com.yelp.clientlib.entities.SearchResponse;

import java.util.Collection;
import java.util.List;

/**
 * Created by rocko on 15-11-5.
 */
public class UserListViewModel extends LoadingViewModel {
	private final static String TAG = UserListViewModel.class.getSimpleName();

	public final ObservableBoolean showContentList = new ObservableBoolean(false);
	public final ObservableField<BusinessesAdapter> usersListAdapter = new ObservableField<>();

	UseCase getUserList = new GetUserList(AndroidApplication.getContext());


	@BindView
	@Override
	public void showLoading() {
		super.showLoading();
		showContentList.set(false);
	}

	@BindView
	@Override
	public void showRetry() {
		super.showRetry();
		showContentList.set(false);
	}

	@BindView
	public void showContentList(BusinessesAdapter businessesAdapter) {
		showLoading.set(false);
		showRetry.set(false);
		showContentList.set(true);
		usersListAdapter.set(businessesAdapter);
	}

	@BindView
	public void showMoreContent() {
		// userAdapter
	}

	@Command
	public void loadUsersCommand() {
		if (showLoading.get()) {
			return;
		}
		showLoading();
		getUserList.execute(new DefaultSubscriber<SearchResponse>() {
			@Override
			public void onNext(SearchResponse searchResponse) {

				Log.d("a","a");
				//businessesAdapter.setOnItemClickListener(onUserItemClick());
				//showContentList(businessesAdapter);
			}

			@Override
			public void onCompleted() {
				super.onCompleted();
			}

			@Override
			public void onError(Throwable e) {
				showRetry();
			}

		});
	}

	@Override
	public View.OnClickListener onRetryClick() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				loadUsersCommand();

			}
		};
	}

	public BusinessesAdapter.OnItemClickListener onUserItemClick() {
		return new BusinessesAdapter.OnItemClickListener() {
			@Override
			public void onUserItemClicked(UserModel userModel) {
				Intent intent = BusinessDetailsActivity.getCallingIntent(AndroidApplication.getInstance().getCurrentActivity(), userModel.getUserId());
				ActivityNavigator.navigateTo(BusinessDetailsActivity.class, intent);
			}
		};
	}

}
