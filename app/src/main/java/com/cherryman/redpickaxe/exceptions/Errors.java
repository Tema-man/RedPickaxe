package com.cherryman.redpickaxe.exceptions;

import com.cherryman.redpickaxe.R;

/**
 * @author Artemii Vishnevskii
 * @since 05.06.2016
 */
public class Errors {

    public static AppException noInternet(){
        return new AppException(R.string.error_noInternetConnection);
    }

    public static AppException network(){
        return new AppException(R.string.error_networkError);
    }
}
