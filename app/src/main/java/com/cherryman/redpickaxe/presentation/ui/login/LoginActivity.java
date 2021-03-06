package com.cherryman.redpickaxe.presentation.ui.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.Toast;

import com.cherryman.redpickaxe.R;
import com.cherryman.redpickaxe.presentation.di.components.AppComponent;
import com.cherryman.redpickaxe.presentation.di.components.DaggerLoginComponent;
import com.cherryman.redpickaxe.presentation.di.components.LoginComponent;
import com.cherryman.redpickaxe.presentation.di.modules.LoginModule;
import com.cherryman.redpickaxe.exceptions.AppException;
import com.cherryman.redpickaxe.presentation.presenters.LoginPresenter;
import com.cherryman.redpickaxe.presentation.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements
    LoginPresenter.View {

    @BindView(R.id.al_edit_host) TextInputEditText mHostField;
    @BindView(R.id.al_edit_login) TextInputEditText mLoginField;
    @BindView(R.id.al_edit_password) TextInputEditText mPassField;
    @BindView(R.id.al_edit_apiKey) TextInputEditText mApiKeyField;

    @Inject LoginPresenter mPresenter;

    private LoginComponent mLoginComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter.onAttachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDeteachView();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.al_btn_Login)
    public void onLoginClick() {
        mPresenter.onLoginClick(
            mLoginField.getText().toString(),
            mApiKeyField.getText().toString()
        );
    }

    //region Dependency Injection
    //--------------------------------------------------------------------------------------------//
    @Override
    protected void setupComponent(AppComponent appComponent) {
        mLoginComponent = DaggerLoginComponent.builder()
            .appComponent(appComponent)
            .loginModule(new LoginModule())
            .build();
        mLoginComponent.inject(this);
    }
    //endregion

    //region LoginPresenter.View Implementation
    //--------------------------------------------------------------------------------------------//
    @Override
    public void showError(AppException e) {
        Toast.makeText(LoginActivity.this, "error call from presenter", Toast.LENGTH_SHORT).show();
    }
    //endregion
}
