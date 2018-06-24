package com.ankit.assignment.grabbd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ankit.assignment.grabbd.R;
import com.ankit.assignment.grabbd.model.Item_;
import com.ankit.assignment.grabbd.model.Tip;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    List<Item_> mVenueItemList;
    Context mContext;
    String photoUrl;
    List<Tip> tipList = new ArrayList<>();

    public VenueAdapter(Context context , List<Item_> venueItemList){
        this.mContext = context;
        this.mVenueItemList = venueItemList;
    }

    @NonNull
    @Override
    public VenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_item_list , parent , false);
        return new VenueViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueViewHolder holder, int position) {
        String venueName = mVenueItemList.get(position).getVenue().getName();
        String cityName = mVenueItemList.get(position).getVenue().getLocation().getCity();
        String countryName = mVenueItemList.get(position).getVenue().getLocation().getCountry();
        String stateName = mVenueItemList.get(position).getVenue().getLocation().getState();
        String categoryName = mVenueItemList.get(position).getVenue().getCategories().get(0).getName();
        //photoUrl = mVenueItemList.get(position).getTips().get(0).getPhotourl();

        holder.mVenueNameTextView.setText(venueName);
        holder.mCityNameTextView.setText(cityName);
        holder.mStateNameTextView.setText(stateName);
        holder.mCountryNameTextView.setText(countryName);
        holder.mCategoryNameTextView.setText(categoryName);

        /*Glide.with(mContext.getApplicationContext())
                .load(photoUrl)
                .into(holder.mVenueImage);*/

        holder.mExpandableRelativeLayout.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mVenueItemList.size();
    }

    public class VenueViewHolder extends RecyclerView.ViewHolder{

        TextView mVenueNameTextView , mCityNameTextView, mCountryNameTextView , mStateNameTextView , mCategoryNameTextView;
        ImageView mUserPhotoImageView , mCategoryIconImageView , mVenueImage;
        RelativeLayout mExpandableRelativeLayout;

        public VenueViewHolder(View view){
            super(view);

            mVenueNameTextView = view.findViewById(R.id.tv_venue_name);
            mCityNameTextView = view.findViewById(R.id.tv_city_name);
            mStateNameTextView = view.findViewById(R.id.tv_state_name);
            mCountryNameTextView = view.findViewById(R.id.tv_country_name);
            mCategoryNameTextView = view.findViewById(R.id.tv_category_name);
            mUserPhotoImageView = view.findViewById(R.id.iv_photo);
            mCategoryIconImageView = view.findViewById(R.id.iv_category);
            mVenueImage = view.findViewById(R.id.iv_venue_image);

            mExpandableRelativeLayout = view.findViewById(R.id.expandable_layout);
        }
    }
}
