package com.cherryman.redpickaxe.data;

import com.cherryman.redpickaxe.domain.executor.JobThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * @author Artemii Vishnevskii
 * @since 12.06.2016
 */
@Singleton
public class JobExecutor implements JobThread {

    @Inject
    public JobExecutor() {
    }

    @Override public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
