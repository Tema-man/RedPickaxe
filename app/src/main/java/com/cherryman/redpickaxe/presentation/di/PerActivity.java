package com.cherryman.redpickaxe.presentation.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Artemii Vishnevskii
 * @since 15.05.2016
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
