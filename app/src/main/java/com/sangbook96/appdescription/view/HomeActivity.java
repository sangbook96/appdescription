package com.sangbook96.appdescription.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sangbook96.appdescription.R;
import com.sangbook96.appdescription.adapter.HomeAdapter;
import com.sangbook96.appdescription.model.Homes;
import com.sangbook96.appdescription.persenter.DescptionLogic;
import com.sangbook96.appdescription.persenter.DescptionPersenter;
import com.sangbook96.appdescription.util.Config;
import com.sangbook96.appdescription.util.RecyclerViewItemClickListener;

import java.io.IOException;
import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements DescptionPersenter {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private DescptionLogic descptionLogic;
    private final String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MzYsImlzQWN0aXZlIjp0cnVlfQ.Pgq2WTdzdUGEo9Cys4qUsmfniowPU8akbCgiDSePy-Y";
    private HomeAdapter homeAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Homes> arrHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        requestData();
    }


    @SuppressLint("WrongConstant")
    private void init() {
        arrHome = new ArrayList<>();
        mRecyclerView = findViewById(R.id.rcv);
        descptionLogic = new DescptionLogic(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    private void requestData() {
        descptionLogic.requestDescption(token);
        showLoading();
    }

    @Override
    public void getListDescptionSucess(ArrayList<Homes> listDescption) {
        Log.e(TAG, "getListDescptionSucess: "+listDescption );
        for (int i = 0; i < listDescption.size(); i++) {
            arrHome.add(listDescption.get(i));
        }
        homeAdapter = new HomeAdapter(HomeActivity.this, arrHome, onItemClickCallBack);
        mRecyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
        hideLoading();
    }

    @Override
    public void getListDescptionError(String errorMessage) {
        hideLoading();
        showDialogErrorMsg(errorMessage);
    }

    RecyclerViewItemClickListener.OnItemClickCallBack onItemClickCallBack = new RecyclerViewItemClickListener.OnItemClickCallBack() {
        @Override
        public void onItemClicked(View view, int position) throws IOException {
            switch (view.getId()) {
                case R.id.layout_item:
                    Intent intent = new Intent(HomeActivity.this,DetailActivity.class);
                    intent.putExtra(Config.DATA_DETAIL,arrHome.get(position));
                    startActivity(intent);
                    break;
            }
        }
    };
}
