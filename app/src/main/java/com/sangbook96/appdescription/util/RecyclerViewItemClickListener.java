package com.sangbook96.appdescription.util;

import android.view.View;

import java.io.IOException;

public class RecyclerViewItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallBack onItemClickCallBack;

    public RecyclerViewItemClickListener(int position, OnItemClickCallBack onItemClickCallBack) {
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;
    }

    @Override
    public void onClick(View view) {
        try {
            onItemClickCallBack.onItemClicked(view, position);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public interface OnItemClickCallBack {
        void onItemClicked(View view, int position) throws IOException;
    }

}
