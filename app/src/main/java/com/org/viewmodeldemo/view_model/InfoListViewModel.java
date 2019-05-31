package com.org.viewmodeldemo.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.org.viewmodeldemo.networking.APICallback;
import com.org.viewmodeldemo.networking.NetworkingService;
import com.org.viewmodeldemo.request_pojo.RowContentInfo;
import com.org.viewmodeldemo.request_pojo.RowDescription;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class InfoListViewModel extends ViewModel {
    MutableLiveData<List<RowDescription>> rowData;

    public LiveData<List<RowDescription>> fetchInfo() {

        if (rowData == null) {
            rowData = new MutableLiveData<List<RowDescription>>();

            retrieveData();
        }
        return rowData;
    }

    private void retrieveData() {

        NetworkingService.fetchResponse(new APICallback() {
            @Override
            public void onResponse(Call<?> call, Response<RowContentInfo> response, int requestCode) {
                rowData.setValue(response.body().getRows());
            }

            @Override
            public void onFailure(Call<?> call, Throwable t, int requestCode) {

            }
        }, 1);
    }
}
