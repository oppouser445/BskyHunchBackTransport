package com.tuofeng.bskyhunchbacktransport.module.bean;

public class LoginBean extends BaseBean{

    /**
     * access_token : eyJhbGciOiJSUzI1NiIsImtpZCI6Im9EUWFFY3MzeEFCRXdvLUlqVnJINHciLCJ0eXAiOiJhdCtqd3QifQ.eyJuYmYiOjE1OTA0NjIwNjYsImV4cCI6MTYyMTk5ODA2NiwiaXNzIjoiaHR0cDovLzE5Mi4xNzAuMjAuODo4ODAyIiwiYXVkIjpbIkJTa3kiLCJCU2t5QmFzZVNlcnZpY2UiLCJCU2t5QnVzaW5lc3NTZXJ2aWNlIiwiQlNreUdQU1NlcnZpY2UiXSwiY2xpZW50X2lkIjoiQlNreV9XZWIiLCJzdWIiOiI1NDEzYjVlZi01ZGNmLTY3YjktMWMyZi0zOWY1NGM4NDUzMDIiLCJhdXRoX3RpbWUiOjE1OTA0NjIwNjYsImlkcCI6ImxvY2FsIiwicm9sZSI6ImFkbWluIiwibmFtZSI6ImFkbWluIiwiZW1haWwiOiJhZG1pbkBhYnAuaW8iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInBob25lX251bWJlciI6IjEzNTY4ODg1NTY2IiwicGhvbmVfbnVtYmVyX3ZlcmlmaWVkIjpmYWxzZSwic2NvcGUiOlsiYWRkcmVzcyIsImVtYWlsIiwib3BlbmlkIiwicGhvbmUiLCJwcm9maWxlIiwicm9sZSIsIkJTa3kiLCJCU2t5QmFzZVNlcnZpY2UiLCJCU2t5QnVzaW5lc3NTZXJ2aWNlIiwiQlNreUdQU1NlcnZpY2UiLCJvZmZsaW5lX2FjY2VzcyJdLCJhbXIiOlsicHdkIl19.UhsvfbQekgcBR4OfA4CQ9gIU_niGixEJAaI7qO5h2x4ztSn-n2Ct5D8bbCIE8VLD2tWz58q_dnRtuqSbm1cK4hhx5qVcyqqeHYVKP4Zr46Xhp3oDLw5Orm2D1v6WCQ4fXqDv45Sa5n0SxFImn9QB0fg6tWmJHHbr_2c_dErSLgxQPQQCks_Rcj1EXf1ds_vB9HsEUE3ilCYAScN84HQyPkNo9wPsX_tqzS4yVFgqlKHpUrjPZC9xHPnMtRJ3Q-iX5Kvg8UQT1RYTBCB4mXgvBeRzg2LXChe2NZ-SLozNchdj1j7gRyMUwFDwoHa1lygBiFocIDquNLhZquN8f53FDg
     * expires_in : 31536000
     * token_type : Bearer
     * refresh_token : U3rucb-MD8cDYvjxkT9RlbhBEOAm-cBCObfQteD9rfo
     * scope : address BSky BSkyBaseService BSkyBusinessService BSkyGPSService email offline_access openid phone profile role
     */

    private String access_token;
    private int expires_in;
    private String token_type;
    private String refresh_token;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", token_type='" + token_type + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
