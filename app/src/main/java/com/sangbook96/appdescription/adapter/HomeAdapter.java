package com.sangbook96.appdescription.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sangbook96.appdescription.R;
import com.sangbook96.appdescription.api.ApiUtils;
import com.sangbook96.appdescription.model.Homes;
import com.sangbook96.appdescription.util.Formatter;
import com.sangbook96.appdescription.util.RecyclerViewItemClickListener;
import com.sangbook96.appdescription.util.RoundedCornersTransform;
import com.sangbook96.appdescription.util.RoundedCornersTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ItemViewHolder> {
    private Context context;
    private static final String TAG = HomeAdapter.class.getSimpleName();
    private ArrayList<Homes>arrHome;
    private RecyclerViewItemClickListener.OnItemClickCallBack onItemClickCallBack;

    public HomeAdapter(Context context, ArrayList<Homes> arrHome, RecyclerViewItemClickListener.OnItemClickCallBack onItemClickCallBack) {
        this.context = context;
        this.arrHome = arrHome;
        this.onItemClickCallBack = onItemClickCallBack;
    }
    @Override
    public HomeAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final HomeAdapter.ItemViewHolder holder, int position) {
        Homes homes = arrHome.get(position);
        Log.e(TAG, "onBindViewHolder: "+homes.getCreated_at() );
        if (position%2==0) {
            Picasso.get().load(ApiUtils.BASE_URL_UPLOAD + homes.getMedia().getUrl())
                    .transform(new RoundedCornersTransform())
                    .resize(250,250).into(holder.mImageLeft);
        }else {
            final int radius = 10;
            final int margin = 5;
            final Transformation transformation = new RoundedCornersTransformation(radius, margin);
            Picasso.get().load(ApiUtils.BASE_URL_UPLOAD + homes.getMedia().getUrl())
                    .transform(transformation)
                    .resize(250,250).into(holder.mImageRight);
        }
        holder.mTextTitle.setText(Formatter.formatDateToString(homes.getCreated_at()));
        holder.mLayoutClickItem.setOnClickListener(new RecyclerViewItemClickListener(position, onItemClickCallBack));

    }

    @Override
    public int getItemCount() {
        return arrHome.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public com.sangbook96.appdescription.util.CircleImageView mImageLeft;
        public ImageView mImageRight;;
        public TextView mTextTitle;
        public LinearLayout mLayoutClickItem;

        public ItemViewHolder(final View itemview) {
            super(itemview);
            mImageLeft = itemview.findViewById(R.id.img_left);
            mImageRight = itemview.findViewById(R.id.img_right);
            mTextTitle = itemview.findViewById(R.id.tv_title);
            mLayoutClickItem = itemview.findViewById(R.id.layout_item);
        }
    }

}
