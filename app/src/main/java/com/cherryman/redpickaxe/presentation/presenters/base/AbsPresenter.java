package com.cherryman.redpickaxe.presentation.presenters.base;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
public abstract class AbsPresenter<V extends BaseView> implements Presenter<V> {

    private WeakReference<V> mWeakView;

    @CallSuper
    @Override
    public void onAttachView(V view) {
        mWeakView = new WeakReference<>(view);
    }

    @CallSuper
    @Override
    public void onDeteachView() {
        if (mWeakView != null) {
            mWeakView.clear();
            mWeakView = null;
        }
    }

    @Nullable
    public V getView() {
        return mWeakView == null ? null : mWeakView.get();
    }
}
