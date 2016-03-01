/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.calabashCat.android.sample.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.support.v7.widget.Toolbar;

import com.calabashCat.android.sample.presentation.R;

/**
 * Activity that shows a list of Users.
 */
public class BusinessListActivity extends BaseActivity{
    public static Intent getCallingIntent(Context context) {
        return new Intent(context, BusinessListActivity.class);
    }
    class InnerBusinessListActivity extends AppCompatActivity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

            DataBindingUtil.setContentView(this, R.layout.user_list_activity);
            Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(myToolbar);
        }
    }
}
