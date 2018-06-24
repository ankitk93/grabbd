package com.ankit.assignment.grabbd.Interface;

import com.ankit.assignment.grabbd.model.Explore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("venues/explore?v=20180623")
    Call<Explore> exploreVenues(@Query("client_id") String clientId,
                                @Query("client_secret")String clientSecret,
                                @Query("ll")String ll,
                                @Query("limit")int limit);

    @GET("venues/explore?v=20180623")
    Call<Explore> exploreVenues(@Query("client_id") String clientId,
                               @Query("client_secret")String clientSecret,
                               @Query("ll")String ll,
                               @Query("section")String section,
                               @Query("limit")int limit);

    @GET("venues/explore?v=20180623")
    Call<Explore> exploreVenues(@Query("client_id") String clientId,
                               @Query("client_secret")String clientSecret,
                               @Query("limit")int limit,
                               @Query("near")String near);

    @GET("venues/search")
    Call<String> searchVenues();
}
