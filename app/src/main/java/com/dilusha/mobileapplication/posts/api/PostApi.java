package com.dilusha.mobileapplication.posts.api;

import com.dilusha.mobileapplication.posts.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("/Posts")
    Call<List<Post>> getPosts();
}
