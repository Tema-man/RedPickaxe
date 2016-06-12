package com.cherryman.redpickaxe.domain.cases.base;

import com.cherryman.redpickaxe.exceptions.AppException;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public interface Case<T> {
    void execute(Subscriber<T> subscriber);
    void execute(Action1<T> action, Action1<AppException> error);
    void unsubscribe();
}
