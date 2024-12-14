package com.example.mylauncher;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AppGridActivity extends AppCompatActivity {
    //private static AppCompatActivity instance;
    private int mColumnNumber = 3;
    private AppGridAdapter mGridAdapter;
    private PackageManager mPackageManager;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app_grid);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.appgrid_area), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //instance = this;
            return insets;

        });
        mPackageManager = getPackageManager();
        mGridAdapter = new AppGridAdapter(this);
        RecyclerView gridView = requireViewById(R.id.app_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,mColumnNumber);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(mGridAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateAppsLists();
    }

    
        public static Context getContext() {
            Context instance = null;
            return instance.getApplicationContext();
        }

         
    private void    updateAppsLists()
    {
        AppLauncherUtils.LauncherAppsInfo appsInfo = AppLauncherUtils.getLauncherApps(
                getSystemService(LauncherApps.class),
                mPackageManager
        );
        mGridAdapter.setAllApps(appsInfo.getLaunchableAppList());
    }
}
