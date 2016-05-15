package com.cherryman.redpickaxe.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cherryman.redpickaxe.App;
import com.cherryman.redpickaxe.di.components.AppComponent;

import butterknife.ButterKnife;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.get(this).getAppComponent());
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bindViews();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        bindViews();
    }

    private void bindViews() {
        ButterKnife.bind(this);
    }

    protected abstract void setupComponent(AppComponent appComponent);
}
