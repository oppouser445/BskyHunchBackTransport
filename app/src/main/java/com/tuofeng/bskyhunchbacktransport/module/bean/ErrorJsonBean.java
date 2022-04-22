package com.tuofeng.bskyhunchbacktransport.module.bean;

import java.io.Serializable;

public class ErrorJsonBean extends BaseBean {

    /**
     * error : {"code":"invalid_grant","message":"Invalid username or password!","details":null,"data":{},"validationErrors":null}
     */

    private ErrorBean error;

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }

    public static class ErrorBean extends BaseBean implements Serializable {
        /**
         * code : invalid_grant
         * message : Invalid username or password!
         * details : null
         * data : {}
         * validationErrors : null
         */

        private String code;
        private String message;
        private Object details;
        private String validationErrors;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getDetails() {
            return details;
        }

        public void setDetails(Object details) {
            this.details = details;
        }

        public String getValidationErrors() {
            return validationErrors;
        }

        public void setValidationErrors(String validationErrors) {
            this.validationErrors = validationErrors;
        }
    }
}
