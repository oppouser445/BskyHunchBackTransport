package com.tuofeng.bskyhunchbacktransport.viewmodel;

import com.tuofeng.bskyhunchbacktransport.in.ITeamCaptainCertificationView;
import com.tuofeng.bskyhunchbacktransport.module.data.TeamCaptainCertificationActRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class TeamCaptainCertificationActViewModel extends BaseViewModel<ITeamCaptainCertificationView, TeamCaptainCertificationActRepository> {

    private final String TAG = "TeamCaptainCertificationActViewModel";

    public TeamCaptainCertificationActViewModel(ITeamCaptainCertificationView iView) {
        super(iView, new TeamCaptainCertificationActRepository());
    }


    public void SubmitCertification(){
        mIView.SubmitCertification();
    }
}