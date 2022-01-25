package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityDriverTeamcaptainCertificationBindingImpl;
import com.tuofeng.bskyhunchbacktransport.in.ITeamCaptainCertificationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.TeamCaptainCertificationActViewModel;

public class TeamCaptainCertificationActivity extends BaseActivity<ActivityDriverTeamcaptainCertificationBindingImpl, TeamCaptainCertificationActViewModel> implements ITeamCaptainCertificationView , View.OnClickListener {

    @Override
    protected TeamCaptainCertificationActViewModel getViewModel() {
        return new TeamCaptainCertificationActViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_driver_teamcaptain_certification;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarBack.setOnClickListener(v -> finish());
        mToolbarTitle.setText("请选择认证的角色");
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void SubmitCertification() {
        Intent intent = new Intent(this, TeamCaptainCertificationReview.class);
        startActivity(intent);
    }
}
