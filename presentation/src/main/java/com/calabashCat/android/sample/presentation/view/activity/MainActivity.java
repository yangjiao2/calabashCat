package com.calabashCat.android.sample.presentation.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.calabashCat.android.sample.presentation.HomeBinding;
import com.calabashCat.android.sample.presentation.R;
import com.calabashCat.android.sample.presentation.utils.LocationUtil;
import com.calabashCat.android.sample.presentation.viewmodel.HomeViewModel;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity<HomeViewModel, HomeBinding> {

  private TextView ShowLocation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setViewModel(new HomeViewModel());
    setBinding(DataBindingUtil.<HomeBinding>setContentView(this, R.layout.home_activity));
    getBinding().setViewModel(getViewModel());

    initWidget();

    ShowLocation = (TextView) findViewById(R.id.ShowLocation);
        getLocation();

  }

  private void initWidget() {
    getBinding().linkTv.setText(Html.fromHtml(getResources().getString(R.string.url)));
    getBinding().linkTv.setMovementMethod(LinkMovementMethod.getInstance());
  }

  private void getLocation(){
    LocationUtil LocationTest = new LocationUtil(this);
    double altitude = LocationTest.getAltitude();
    double longitude = LocationTest.getLongitude();
    ShowLocation.setText(altitude + ", " + longitude);

  }

}
