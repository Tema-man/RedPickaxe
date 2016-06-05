package com.cherryman.redpickaxe.domain.cases.base;

import com.cherryman.redpickaxe.domain.executor.PostThread;
import com.cherryman.redpickaxe.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public abstract class AbsCase<T> implements Case<T> {

    private final ThreadExecutor mThreadExecutor;
    private final PostThread mPostThread;

    protected Action1<Throwable> errorAction;
    private Subscription mSubscription = Subscriptions.empty();

    protected AbsCase(ThreadExecutor executor, PostThread postThread) {
        mThreadExecutor = executor;
        mPostThread = postThread;
    }

    public abstract Observable<T> buildObservable();

    public void execute(Action1<T> action) {
        mSubscription = buildObservable()
            .subscribeOn(Schedulers.from(mThreadExecutor))
            .observeOn(mPostThread.getScheduler())
            .doOnNext(action)
            .doOnError(errorAction)
            .subscribe();
    }

    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

}
