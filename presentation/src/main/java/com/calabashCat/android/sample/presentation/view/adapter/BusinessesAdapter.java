/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.calabashCat.android.sample.presentation.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.calabashCat.android.sample.data.entities.Business;
import com.calabashCat.android.sample.presentation.R;
import com.calabashCat.android.sample.presentation.RowUserBinding;
import com.calabashCat.android.sample.presentation.model.UserModel;

import java.util.Collection;
import java.util.List;


/**
 * Adaptar that manages a collection of {@link UserModel}.
 */
public class BusinessesAdapter extends RecyclerView.Adapter<BusinessesAdapter.UserViewHolder> {

	private RowUserBinding rowUserBinding;

	public interface OnItemClickListener {
		void onUserItemClicked(Business userModel);
	}

	private List<Business> businessCollection;
	private final LayoutInflater layoutInflater;
	private Context mContext;
	private OnItemClickListener onItemClickListener;

	public BusinessesAdapter(Context context, Collection<Business> businessCollection) {
		this.mContext=context;
		this.validateUsersCollection(businessCollection);
		this.layoutInflater =
				(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.businessCollection = (List<Business>) businessCollection;
	}

	@Override
	public int getItemCount() {
		return (this.businessCollection != null) ? this.businessCollection.size() : 0;
	}

	@Override
	public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		rowUserBinding = DataBindingUtil.inflate(layoutInflater, R.layout.row_user, parent, false);
		UserViewHolder userViewHolder = new UserViewHolder(rowUserBinding);
		return userViewHolder;
	}

	@Override
	public void onBindViewHolder(UserViewHolder holder, final int position) {
		final Business userModel = this.businessCollection.get(position);
		int reviewCount= userModel.getReview_count();
		holder.textViewTitle.setText(userModel.getName());

// by roy, feb. 26 2016 rating count.
		holder.textViewReview.setText(Integer.toString(reviewCount));
		if(reviewCount>1)
		holder.textViewReview.append(" reviews");
		else
			holder.textViewReview.append(" review");

// by roy, feb. 23 2016 food image.
		Glide.with(mContext)
				.load(userModel.getImage_url())
				.thumbnail(0.5f)
				.into(holder.imageView);

// by roy, feb. 23 2016 review rate image.
		Glide.with(mContext)
				.load(userModel.getRating_img_url_small())
				.thumbnail(0.5f)
				.into(holder.RatingImgView);

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (BusinessesAdapter.this.onItemClickListener != null) {
					BusinessesAdapter.this.onItemClickListener.onUserItemClicked(userModel);
				}
			}
		});
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void setUsersCollection(Collection<Business> businessCollection) {
		this.validateUsersCollection(businessCollection);
		this.businessCollection = (List<Business>) businessCollection;
		this.notifyDataSetChanged();
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	private void validateUsersCollection(Collection<Business> businessCollection) {
		if (businessCollection == null) {
			throw new IllegalArgumentException("The list cannot be null");
		}
	}

	static class UserViewHolder extends RecyclerView.ViewHolder {
		TextView textViewTitle;
		TextView textViewReview;
		ImageView imageView;
		ImageView RatingImgView;

		public UserViewHolder(RowUserBinding rowUserBinding) {
			super(rowUserBinding.getRoot());
			textViewTitle = rowUserBinding.title;
			textViewReview = rowUserBinding.reviewCount;
			imageView = rowUserBinding.avatar;
			RatingImgView = rowUserBinding.RatingImg;
		}
	}
}
