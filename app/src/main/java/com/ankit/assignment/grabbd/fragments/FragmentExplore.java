package com.ankit.assignment.grabbd.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ankit.assignment.grabbd.Interface.ApiInterface;
import com.ankit.assignment.grabbd.R;
import com.ankit.assignment.grabbd.adapter.SectionAdapter;
import com.ankit.assignment.grabbd.adapter.VenueAdapter;
import com.ankit.assignment.grabbd.api.RetrofitClient;
import com.ankit.assignment.grabbd.model.Explore;
import com.ankit.assignment.grabbd.model.Item_;
import com.ankit.assignment.grabbd.model.Section;
import com.ankit.assignment.grabbd.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentExplore extends Fragment{

    private RecyclerView mSectionRecyclerView;
    private List<String> sectionArray = new ArrayList<>();
    private List<Section> mSectionList;
    private SectionAdapter mSectionAdapter;
    private String geoLocation = "28.41,77.04";

    private List<Item_> mVenueItemList;
    private VenueAdapter mVenueAdapter;
    private RecyclerView mVenueRecyclerView;

    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_explore , container , false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sectionArray = Arrays.asList("food" , "drinks" , "coffee" , "shops" , "arts" , "outdoors" , "sights", "trending");
        mSectionList = new ArrayList<>();

        for (int i =0;i<sectionArray.size();i++){
            Section section = new Section();
            section.setSection(sectionArray.get(i));
            mSectionList.add(section);
        }

        mSectionRecyclerView = mView.findViewById(R.id.section_recycler_view);
        mSectionRecyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL ,false));

        mSectionAdapter = new SectionAdapter(getContext() , mSectionList);
        mSectionRecyclerView.setAdapter(mSectionAdapter);
        mSectionAdapter.notifyDataSetChanged();

        mVenueRecyclerView = mView.findViewById(R.id.venue_recycler_view);
        mVenueRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getResults();
    }

    private void getResults(){
        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        Call<Explore> exploreCall = apiInterface.exploreVenues(Constants.FOURSQUARE_CLIENT_ID,
                Constants.FOURSQUARE_CLIENT_SECRET,geoLocation  ,1);

        exploreCall.enqueue(new Callback<Explore>() {
            @Override
            public void onResponse(Call<Explore> call, Response<Explore> response) {
                mVenueItemList = new ArrayList<>();
                mVenueItemList = response.body().getResponse().getGroups().get(0).getItems();
                mVenueAdapter = new VenueAdapter(getContext() , mVenueItemList);
                mVenueRecyclerView.setAdapter(mVenueAdapter);
                mVenueAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Explore> call, Throwable t) {
                Log.e("Error:" , t.toString());
            }
        });
    }
}
