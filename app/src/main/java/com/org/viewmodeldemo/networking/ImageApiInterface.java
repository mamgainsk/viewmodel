package com.org.viewmodeldemo.networking;


import com.org.viewmodeldemo.request_pojo.RowContentInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImageApiInterface {

    @GET("s/2iodh4vg0eortkl/facts.json")
    Call<RowContentInfo> getJsonResponse();
}
