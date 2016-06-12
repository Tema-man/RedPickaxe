package com.cherryman.redpickaxe.domain.cases.base;

import com.cherryman.redpickaxe.domain.executor.JobThread;
import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.exceptions.AppException;
import com.cherryman.redpickaxe.exceptions.Errors;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public abstract class AbsCase<T> implements Case<T> {

    private final JobThread mJobThread;
    private final PostThread mPostThread;

    private Subscription mSubscription = Subscriptions.empty();

    protected AbsCase(JobThread executor, PostThread postThread) {
        mJobThread = executor;
        mPostThread = postThread;
    }

    public abstract Observable<T> buildObservable();

    public void execute(Subscriber<T> subscriber) {
        mSubscription = buildObservable()
            .subscribeOn(mJobThread.getScheduler())
            .observeOn(mPostThread.getScheduler())
            .subscribe(subscriber);
    }

    public void execute(Action1<T> action, Action1<AppException> error) {
        mSubscription = buildObservable()
            .subscribeOn(mJobThread.getScheduler())
            .observeOn(mPostThread.getScheduler())
            .doOnNext(action)
            .doOnError(throwable -> error.call(Errors.network()))
            .subscribe();
    }

    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

}
