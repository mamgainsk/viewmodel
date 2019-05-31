package com.org.viewmodeldemo.networking;


import com.org.viewmodeldemo.request_pojo.RowContentInfo;

import retrofit2.Call;
import retrofit2.Response;

public interface APICallback {

    void onResponse(Call<?> call, Response<RowContentInfo> response, int requestCode);

    void onFailure(Call<?> call, Throwable t, int requestCode);
}
