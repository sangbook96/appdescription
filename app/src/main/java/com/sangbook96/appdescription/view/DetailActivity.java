package com.sangbook96.appdescription.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.sangbook96.appdescription.R;
import com.sangbook96.appdescription.api.ApiUtils;
import com.sangbook96.appdescription.model.Homes;
import com.sangbook96.appdescription.util.Config;
import com.squareup.picasso.Picasso;

public class DetailActivity extends BaseActivity {

    TextView mDesception;
    ImageView mImage;
    private static final String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        getDataDetail();
    }

    private void getDataDetail() {
        Intent intent = this.getIntent();
        Homes homes = (Homes) intent.getSerializableExtra(Config.DATA_DETAIL);
        Log.e(TAG, "getDataDetail: " + homes.toString());
        Picasso.get().load(ApiUtils.BASE_URL_UPLOAD + homes.getMedia().getUrl())
                .into(mImage);
        mDesception.setText(getString(R.string.descption));
    }

    private void init() {
        mImage = findViewById(R.id.img_detail);
        mDesception = findViewById(R.id.tv_desception);
    }
}
