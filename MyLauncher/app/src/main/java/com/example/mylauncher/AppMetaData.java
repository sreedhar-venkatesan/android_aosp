package com.example.mylauncher;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.function.Consumer;


final class AppMetaData{
    private final ComponentName mComponentName;
    private final Drawable mIcon;
    private final String mDisplayName;
    private final Consumer<Context> mLaunchCallback;

    AppMetaData(String mDisplayName, ComponentName mComponentName, Drawable mIcon, Consumer<Context> mLaunchCallback) {
        this.mIcon = mIcon;
        this.mLaunchCallback = mLaunchCallback;
        this.mComponentName = mComponentName;
        this.mDisplayName = mDisplayName;
    }

    public Drawable getIcon() {
        return mIcon;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public Consumer<Context> getLaunchCallback() {
        return mLaunchCallback;
    }

    public ComponentName getComponentName() {
        return mComponentName;
    }


}
