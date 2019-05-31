package com.org.viewmodeldemo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.org.viewmodeldemo.adapter.InfoListAdapter;
import com.org.viewmodeldemo.request_pojo.RowDescription;
import com.org.viewmodeldemo.view_model.InfoListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView infoRecyclerView;
    private InfoListAdapter infoListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_list_activity);
        infoRecyclerView = findViewById(R.id.infoListView);
        infoRecyclerView.setHasFixedSize(true);
        infoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        InfoListViewModel infoListViewModel = ViewModelProviders.of(this).get(InfoListViewModel.class);

        infoListViewModel.fetchInfo().observe(this, new Observer<List<RowDescription>>() {
            @Override
            public void onChanged(List<RowDescription> rowDescriptions) {
                infoListAdapter = new InfoListAdapter(MainActivity.this, rowDescriptions);
                infoRecyclerView.setAdapter(infoListAdapter);

            }
        });

    }

}
