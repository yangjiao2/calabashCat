package com.calabashCat.android.sample.presentation.viewmodel;


import android.app.Fragment;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;

import com.calabashCat.android.sample.data.entities.Business;
import com.calabashCat.android.sample.data.entities.SearchResponse;
import com.calabashCat.android.sample.domain.interactor.DefaultSubscriber;
import com.calabashCat.android.sample.domain.interactor.GetUserList;
import com.calabashCat.android.sample.domain.interactor.UseCase;
import com.calabashCat.android.sample.presentation.AndroidApplication;
import com.calabashCat.android.sample.presentation.navigation.ActivityNavigator;
import com.calabashCat.android.sample.presentation.view.activity.BusinessDetailsActivity;
import com.calabashCat.android.sample.presentation.view.adapter.BusinessesAdapter;
import com.calabashCat.android.sample.presentation.view.fragment.BusinessCardFragment;
import com.dexafree.materialList.view.MaterialListView;

import java.util.Collection;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * Created by boliu on 16-03-5.
 */
public class UserCardViewModel extends LoadingViewModel {
	private final static String TAG = UserCardViewModel.class.getSimpleName();

	public final ObservableBoolean showContentList = new ObservableBoolean(false);

	UseCase getUserList = new GetUserList(AndroidApplication.getContext());

	private ViewDataBinding viewDataBinding;

	private MaterialListView mListView;
	private Fragment mContext;

	public UserCardViewModel(Fragment context) {
		this.mContext = context;
	}

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
	public void showContentList() {
		showLoading.set(false);
		showRetry.set(false);
		showContentList.set(true);
		//usersListAdapter.set(businessesAdapter);
		mListView.setItemAnimator(new SlideInLeftAnimator());
		mListView.getItemAnimator().setAddDuration(300);
		mListView.getItemAnimator().setRemoveDuration(300);

	}

	@BindView
	public void showMoreContent() {
		// userAdapter
	}

	@Command
	public void loadUsersCommand() {
		mListView = ((BusinessCardFragment)mContext).mListView;

		if (showLoading.get()) {
			return;
		}
		showLoading();
		getUserList.execute(new DefaultSubscriber<SearchResponse>() {
			@Override
			public void onNext(SearchResponse searchResponse) {

				Log.d("a", "a");
				Collection<Business> collection = searchResponse.getBusinesses();

				showContentList();
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
			public void onUserItemClicked(Business userModel) {
				Intent intent = BusinessDetailsActivity.getCallingIntent(AndroidApplication.getInstance()
						.getCurrentActivity(), userModel.getReview_count());
				ActivityNavigator.navigateTo(BusinessDetailsActivity.class, intent);
			}
		};
	}

}
