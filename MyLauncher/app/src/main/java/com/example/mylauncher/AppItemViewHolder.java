package com.example.mylauncher;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class AppItemViewHolder extends RecyclerView.ViewHolder {
    private final Context mContext;
    private View mAppItem;
    private ImageView mAppIconView;
    private TextView mAppNameView;

    public AppItemViewHolder(@NonNull View itemView, Context context){
        super(itemView);
        this.mContext=context;
        mAppItem=itemView.findViewById(R.id.app_item);
        mAppIconView=mAppItem.findViewById(R.id.app_icon);
        mAppNameView=mAppItem.findViewById(R.id.app_name);
    }
    public void bind   (AppMetaData app){
        mAppIconView.setImageDrawable(null);
        mAppNameView.setText(null);
        if (app==null)
            return;
        mAppNameView.setText(app.getDisplayName());
        mAppIconView.setImageDrawable(app.getIcon());
        // click listener
        mAppItem.setOnClickListener(view -> app.getLaunchCallback().accept(mContext));

    }
}
