package com.cherryman.redpickaxe.presentation.presenters.base;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
public interface Presenter<V extends BaseView> {

    void onAttachView(V view);

    void onDeteachView();
}
