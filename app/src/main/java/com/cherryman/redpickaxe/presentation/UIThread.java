package com.cherryman.redpickaxe.presentation;

import com.cherryman.redpickaxe.domain.executor.PostThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author Artemii Vishnevskii
 * @since 12.06.2016
 */
@Singleton
public class UIThread implements PostThread {

    @Inject
    public UIThread() {
    }

    @Override public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
