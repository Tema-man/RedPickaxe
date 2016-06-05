package com.cherryman.redpickaxe.exceptions;

import android.content.Context;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
public class AppException extends Exception {

    private int mErrorMessageRes;

    public AppException() {
        mErrorMessageRes = -1;
    }

    public AppException(int messageRes) {
        mErrorMessageRes = messageRes;
    }

    public String getMessage(Context context) {
        if (mErrorMessageRes == -1) return "unknown error";
        return context.getString(mErrorMessageRes);
    }
}
