package com.calabashCat.android.sample.test.viewmodel;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.calabashCat.android.sample.data.dto.User;
import com.calabashCat.android.sample.presentation.R;
import com.calabashCat.android.sample.presentation.mapper.UserModelDataMapper;
import com.calabashCat.android.sample.presentation.model.UserModel;
import com.calabashCat.android.sample.presentation.view.activity.BusinessDetailsActivity;
import com.calabashCat.android.sample.presentation.view.activity.BusinessListActivity;
import com.calabashCat.android.sample.presentation.view.adapter.BusinessesAdapter;
import com.calabashCat.android.sample.presentation.view.fragment.BusinessListFragment;
import com.calabashCat.android.sample.presentation.viewmodel.UserListViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;

/**
 * Created by rocko on 15-11-6.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserListViewModelTest {

	private UserModelDataMapper userModelDataMapper;
	private List<User> fakeUsersList;

	private BusinessListFragment businessListFragment;
	private UserListViewModel userListViewModel;
	private BusinessesAdapter businessesAdapter;

	@Rule
	public IntentsTestRule<BusinessListActivity> mActivityRule = new IntentsTestRule<>(
			BusinessListActivity.class);

	@Before
	public void setUp() {
//		intending(not(isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));

		userModelDataMapper = new UserModelDataMapper();
		fakeUsersList = makeFakeUsers();

		businessListFragment = (BusinessListFragment) mActivityRule.getActivity().getFragmentManager().findFragmentById(R.id.fragmentUserList);
		userListViewModel = businessListFragment.getViewModel();

		Collection<UserModel> userModelsCollection = userModelDataMapper.transformUsers(fakeUsersList);
		//roy3221  feb.23 2016
		// businessesAdapter = new BusinessesAdapter(mActivityRule.getActivity(), userModelsCollection);
		businessesAdapter.setOnItemClickListener(userListViewModel.onUserItemClick());
		userListViewModel.showContentList(businessesAdapter);
	}

	@Test
	public void testShowContentList() throws Exception {
		assertEquals(fakeUsersList.size(), businessesAdapter.getItemCount());
	}

	@Test
	public void testOnUserItemClick() throws Exception {
		User user = fakeUsersList.get(1);

		onView(withId(R.id.rv_users)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

		intending(hasExtra(BusinessDetailsActivity.INTENT_EXTRA_PARAM_USER_ID, user.getUserId() + ""));
	}


	private List<User> makeFakeUsers() {
		List<User> fakeUsersList = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			User user = new User(i);
			user.setFullName("NAME: " + i);
			user.setEmail(i + "@fake.com");
			user.setFollowers(i);
			user.setDescription("Description: " + i);
			fakeUsersList.add(user);
		}

		return fakeUsersList;
	}
}
