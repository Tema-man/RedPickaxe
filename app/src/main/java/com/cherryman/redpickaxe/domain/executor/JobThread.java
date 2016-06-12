package com.cherryman.redpickaxe.domain.executor;

import rx.Scheduler;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public interface JobThread {
    Scheduler getScheduler();
}
