package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.contract.LoginContract;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityLoginBinding;
import com.tuofeng.bskyhunchbacktransport.module.SingleTextWatcher;
import com.tuofeng.bskyhunchbacktransport.ui.view.DownTimerText;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.utils.CommonUtil;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.utils.ViewMyUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginContract.ILoginView, View.OnClickListener {

    private EditText mEdLoginPhone, mEdLoginVerification;
    private DownTimerText mSendCode;
    private SharedButton mBtnLogin;
    private boolean mSendCodeTag;
    private boolean mFinish = true;
    private RelativeLayout mRlayoutVerificationClear, mRelativeEmptyPhone;
    private LinearLayout mLlayoutLoginHome, mLlayoutSelectLoginTypeHome;
    private TextView mTvPasswordLogin, mTvSwitchIdentity;
    private EditText mEdtPassword;
    private RelativeLayout mRlayuotLoginPassword, mRlayoutPasswordClear, mRlayoutLoginVerification;
    private boolean mIsPasswordLogin;
    private CheckBox mChkLoginInstruction;
    private boolean mIsSelectChkLoginInstruction;
    private String TAG = "LoginActivity";
    private boolean mtxtOnClickCallback;

    @Override
    protected LoginViewModel getViewModel() {
        return new LoginViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setTransparentStatusBar(getWindow(), 2);
        mDataBinding.setViewModel(mViewModel);

        mEdLoginPhone = mDataBinding.edPhone;
        mEdLoginVerification = mDataBinding.edVerification;

        mSendCode = mDataBinding.sendCode;
        mBtnLogin = mDataBinding.btnLogin;
        mBtnLogin.setEnabled(false);

        mRlayoutLoginVerification = mDataBinding.rlayoutLoginVerification;
        mRlayoutVerificationClear = mDataBinding.rlayoutVerificationClear;
        mRlayoutVerificationClear.setOnClickListener(this);

        mRelativeEmptyPhone = mDataBinding.rlayoutEmptyPhone;
        mRelativeEmptyPhone.setOnClickListener(this);

        mLlayoutLoginHome = mDataBinding.lLayoutLoginHome;
        mLlayoutSelectLoginTypeHome = mDataBinding.linearSelectLoginTypeHome;

        mTvPasswordLogin = mDataBinding.tvPasswordLogin;
        mTvPasswordLogin.setOnClickListener(this);

        mRlayuotLoginPassword = mDataBinding.rlayuotLoginPassword;
        mRlayoutPasswordClear = mDataBinding.rlayoutPasswordClear;
        mRlayoutPasswordClear.setOnClickListener(this);

        mEdtPassword = mDataBinding.edtPassword;
        ViewMyUtils.setEdViewContentStyple(mEdtPassword);

        mTvSwitchIdentity = mDataBinding.tvSwitchIdentity;
        mTvSwitchIdentity.setOnClickListener(this);

        mChkLoginInstruction = mDataBinding.chkLoginInstruction;
        mChkLoginInstruction.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mIsSelectChkLoginInstruction = isChecked;
            initLoginBtnView(4);
        });

        TextView txtLoginInstruction = mDataBinding.txtLoginInstruction;
        txtLoginInstruction.setMovementMethod(LinkMovementMethod.getInstance());
        txtLoginInstruction.setOnClickListener(v -> {
            if (!mtxtOnClickCallback) {
                LogUtils.e(TAG, "setOnClickListener监听事件");
                ToastUtil.shortToast("setOnClickListener监听事件");
            }
            mtxtOnClickCallback = false;
        });
        txtLoginInstruction.setText(ViewMyUtils.setInstructionText(this, type -> {
            mtxtOnClickCallback = true;
            if (type == 1) {
                ToastUtil.shortToast("用户协议");
            } else {
                ToastUtil.shortToast("隐私协议");
            }
        }));
    }

    @Override
    protected void initData() {
        mEdLoginPhone.addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                initLoginBtnView(1);
            }
        });

        mEdLoginVerification.addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                initLoginBtnView(2);
            }
        });

        mEdtPassword.addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                initLoginBtnView(3);
            }
        });
    }

    @Override
    public void loginUser(int type) {
        if (type == 4) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void showLoginView(int type) {
        setPwdCodViewType(1);
        ViewMyUtils.setTtoggleEffect(mLlayoutLoginHome, true);
    }

    @Override
    public void startHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void getMobileVerificationCode() {
        mSendCode.startCountDownWithUi();
        mSendCode.setCountDownTimer(new DownTimerText.OnCountDownTimer() {
            @Override
            public void onTick(long millisUntilFinished) {
                mFinish = false;
            }

            @Override
            public void onFinish() {
                mFinish = true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSendCode.unRegisterCountDownListener();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mLlayoutSelectLoginTypeHome.getVisibility() != View.VISIBLE) {
                setEditViewType(0);
                setPwdCodViewType(0);
                ViewMyUtils.setTtoggleEffect(mLlayoutSelectLoginTypeHome, true);
                mEdLoginPhone.setText("");
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_switch_identity:
                setEditViewType(0);
                setPwdCodViewType(0);
                ViewMyUtils.setTtoggleEffect(mRlayuotLoginPassword, true);
                break;
            case R.id.rlayout_password_clear:
                mEdtPassword.setText("");
                break;
            case R.id.rlayout_verification_clear:
                mEdLoginVerification.setText("");
                break;
            case R.id.rlayout_empty_phone:
                mEdLoginPhone.setText("");
                break;
            case R.id.tv_password_login:
                mIsPasswordLogin = !mIsPasswordLogin;
                mTvPasswordLogin.setText(mIsPasswordLogin ? "验证码登录" : "密码登录");
                mEdLoginVerification.setText("");
                if (mIsPasswordLogin) {
                    mEdtPassword.setText("");
                    ViewMyUtils.setTtoggleEffect(mRlayuotLoginPassword, true);
                    mRlayoutLoginVerification.setAlpha(1);
                } else {
                    mEdLoginVerification.setText("");
                    ViewMyUtils.setTtoggleEffect(mRlayoutLoginVerification, true);
                    mRlayuotLoginPassword.setAlpha(1);
                }
                mRlayuotLoginPassword.setVisibility(mIsPasswordLogin ? View.VISIBLE : View.GONE);
                mRlayoutLoginVerification.setVisibility(mIsPasswordLogin ? View.GONE : View.VISIBLE);
                break;
        }
    }

    private void initLoginBtnView(int type) {
        String phone = mEdLoginPhone.getText().toString();
        String code = mEdLoginVerification.getText().toString();

        if (mFinish) {
            boolean isPhoneNull = !TextUtils.isEmpty(phone);
            mSendCodeTag = isPhoneNull && phone.length() == 11 && CommonUtil.telePhone(phone + "");
            mSendCode.setEnabled(mSendCodeTag);
            mRelativeEmptyPhone.setVisibility(isPhoneNull ? View.VISIBLE : View.GONE);
        }

        boolean b;
        boolean isCodNull = !TextUtils.isEmpty(code);
        boolean codFlage = isCodNull && code.length() >= 6;
        if (mRlayuotLoginPassword.getVisibility() != View.GONE) {
            String password = mEdtPassword.getText().toString();
            boolean passwordFlage = !TextUtils.isEmpty(password)/* && password.length() >= 6*/;
            b = mSendCodeTag && passwordFlage;
        } else {
            b = mSendCodeTag && codFlage;
            mRlayoutVerificationClear.setVisibility(isCodNull ? View.VISIBLE : View.GONE);
        }

        boolean b1 = b && mIsSelectChkLoginInstruction;
        mBtnLogin.setMyEnabled(b1);
        mBtnLogin.setAlpha(mSendCodeTag && b && mIsSelectChkLoginInstruction ? 1.0f : 0.3f);
        mBtnLogin.setEnabled(b1);
    }

    private void setPwdCodViewType(int type) {
        mLlayoutLoginHome.setVisibility(type == 0 ? View.GONE : View.VISIBLE);
        mLlayoutSelectLoginTypeHome.setVisibility(type == 0 ? View.VISIBLE : View.GONE);
    }

    private void setEditViewType(int type) {
        mRlayoutLoginVerification.setVisibility(type == 0 ? View.VISIBLE : View.GONE);
        mRlayuotLoginPassword.setVisibility(type == 0 ? View.GONE : View.VISIBLE);

        mEdLoginVerification.setText("");
        mEdtPassword.setText("");
    }
}