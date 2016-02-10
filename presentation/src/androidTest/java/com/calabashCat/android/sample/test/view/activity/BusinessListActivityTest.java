/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.calabashCat.android.sample.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import com.calabashCat.android.sample.presentation.R;
import com.calabashCat.android.sample.presentation.view.activity.BusinessListActivity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BusinessListActivityTest extends ActivityInstrumentationTestCase2<BusinessListActivity> {

  private BusinessListActivity businessListActivity;

  public BusinessListActivityTest() {
    super(BusinessListActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    businessListActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsUserListFragment() {
    Fragment userListFragment =
        businessListActivity.getFragmentManager().findFragmentById(R.id.fragmentUserList);
    assertThat(userListFragment, is(notNullValue()));
  }

  public void testContainsProperTitle() {
    String actualTitle = this.businessListActivity.getTitle().toString().trim();

    assertThat(actualTitle, is("Users List"));
  }

  private Intent createTargetIntent() {
    Intent intentLaunchActivity =
        BusinessListActivity.getCallingIntent(getInstrumentation().getTargetContext());

    return intentLaunchActivity;
  }
}
