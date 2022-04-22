package com.tuofeng.bskyhunchbacktransport.module.bean;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.BR;

public class UserBean extends BaseBean {

    private String phone;
    private String pwd;
    private String cod;

    @Bindable
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
        this.pwd = "";
        notifyPropertyChanged(BR.cod);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String p) {
        this.phone = p;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        this.cod = "";
        notifyPropertyChanged(BR.pwd);
    }
}