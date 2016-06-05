package com.cherryman.redpickaxe.domain.cases.base;

import rx.functions.Action1;

/**
 * @author Artemii Vishnevskii
 * @since 22.05.2016
 */
public interface Case<T> {
    void execute(Action1<T> action);
    void unsubscribe();
}
