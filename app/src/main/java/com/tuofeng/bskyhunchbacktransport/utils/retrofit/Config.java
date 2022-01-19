package com.tuofeng.bskyhunchbacktransport.utils.retrofit;

import static com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication.mIsTestFlage;

public class Config {

    public static String baseUrl = mIsTestFlage ? "https://testapiv2.bjtftech.com" : "https://apiv2.bjtftech.com";//总地址 //https://testapiv2.bjtftech.com
    public static String baseLoginUrl = mIsTestFlage ? "https://testauth.bjtftech.com" : "https://auth.bjtftech.com";//登录请求地址 //https://testauth.bjtftech.com
    public static String mPickUpPhotoUrl = "https://bskyv2.oss-cn-beijing.aliyuncs.com";//图片根目录

    //----------------------------登录Start----------------------------
    public static String mPhoneCodeUrl = baseUrl + "/api/message/sms/code/login/";//获取验证码
    public static String mLoginUrl = baseLoginUrl + "/api/AuthorizationManagement/login/driver";//登录请求
    //----------------------------登录End----------------------------

    //----------------------------用户信息Start----------------------------
    public static String mDriverDataURL = baseUrl + "/api/business/driver/my-profile";//获取当前登陆司机信息
    public static String mDriverHistoricalMissionUrl = baseUrl + "/api/business/driverTask/past";//司机历史任务查询
    public static String mDriverCheckTheMonthlyTurnoverURL = baseUrl + "/api/business/driverTask/monthAccount";//查询司机当月流水
    //----------------------------用户信息End----------------------------

    //----------------------------任务相关接口Start----------------------------
    public static String mTaskListURL = baseUrl + "/api/business/driverTask/list";//查询当前登录司机任务列表
    public static String mStartTaskURL = baseUrl + "/api/business/driverTask/startTask/";//开始任务（司机端调用）
    public static String mDriverArrivalsURL = baseUrl + "/api/business/driverTask/arriveStartPlace/";//到达提货地（司机端调用）

    public static String mDriverStartLoadingURL = baseUrl + "/api/business/driverTask/startLoad/";//开始装车（司机端调用）
    public static String mDriverStartUnloadingURL = baseUrl + "/api/business/driverTask/startUnload/";//开始卸车（司机端调用）

    public static String mDeliverykURL = baseUrl + "/api/business/driverTask/pickupJoin/";//提货交接（司机端调用）
    public static String mDeliveryPlaceURL = baseUrl + "/api/business/driverTask/arriveEndPlace/";//到达送货地（司机端调用）
    public static String mConfirmDeliveryURL = baseUrl + "/api/business/driverTask/deliveryJoin/";//送货交接（司机端调用）
    public static String mDriverUploadImageURL = baseUrl + "/api/base/files/driverImage/multiple/{driverId}";//批量上传司机图片

    //装车图片上传Start
    public static String mDrivertransportImTgeURL = baseUrl + "/api/base/files/ticketImage/multiple/";//批量上传运单图片
    public static String mDriveryAddWaybillPicturesInBulkURL = baseUrl + "/api/business/ticketImage/bulk";//批量添加运单图片
    //装车图片上传End

    public static String getDriverLoadingPhotosUrl(String ticketNo) {//转车照片转换地址
        String url = baseUrl + "/api/base/files/ticketImage/multiple/" + ticketNo;
        return url;
    }

    public static String getDriverConversionURL(String driverId) {//转换司机图片
        String url = baseUrl + "/api/base/files/driverImage/" + driverId;
        return url;
    }

    public static String getDriverCertificationURL(String driverId) {//上传司机图片
        String url = baseUrl + "/api/business/driver/" + driverId + "/image";
        return url;
    }

    public static String getExpenserWriterURL(String shortBargeNo) {//批量上传短驳图片
        String url = baseUrl + "/api/base/files/db/" + shortBargeNo + "/imgs";
        return url;
    }

    public static String refreshQRCodeUrl(String shortBargeSubId) {//查询任务当前状态
        String url = baseUrl + "/api/business/driverTask/" + shortBargeSubId + "/task-state";
        return url;
    }

    public static String mDriverTestURL = "https://www.baidu.com/";//批量上传司机图片
    public static String mExpenseReportingListURL = baseUrl + "/api/business/shortBarge/applyFee/list";//获取短驳子单费用申报表(列表不分页)

    public static String mAddExpenseBillURL = baseUrl + "/api/business/shortBarge/applyFee";//添加短驳子单费用申报表

    public static String mModifyExpenseBillURL = baseUrl + "/api/business/shortBarge/applyFee/";//修改短驳子单费用申报表

    public static String mDeliverySubmitWaybillPictureURL = baseUrl + "/api/business/ticketImage";//添加运单图片

    public static String mDriverFeeReportURL = baseUrl + "/api/business/finance/cost/driver";//司机费用填报

    public static String mDriverHistoryTaskTimeDataURL = baseUrl + "/api/business/driverTask/past/month";//查询/修改、增加司机费用填报

    public static String mDriverHistoryTaskURL = baseUrl + "/api/business/driverTask/past";//司机历史任务查询

    public static String mDriverHistoryTaskFeeDetailsURL = baseUrl + "/api/business/finance/cost/driver";//查询司机历史任务费用

    public static String mDriverTrafficTrajectoryURL = baseUrl + "/api/gps/shortBarge/shortBargeSubTrail";//获取短驳子单追踪记录

    public static String getDriverQueryFeeURL(String shortBargeSubId) {//查询司机费用填报
        return baseUrl + "/api/business/finance/cost/driver/" + shortBargeSubId;
    }

    //----------------------------任务相关接口End----------------------------

    //----------------------------异常接口Start----------------------------
    public static String mDriverQueryExceptionRecordsURL = baseUrl + "/api/business/exceptionType/all";//查询异常记录列表
    public static String mDriverExceptionReportURL = baseUrl + "/api/business/shortBargeException";//短驳异常上报
    public static String mDriverListOfExceptionInformationURL = baseUrl + "/api/business/shortBargeException/paged";//分页查询异常信息
    public static String mDriverExceptionRecordDetailsDataURL = baseUrl + "/api/business/shortBargeException/shortBargeSubId";//根据子任务id获取短驳异常表信息
    //----------------------------异常接口End----------------------------

    public static String UpdateAppUrl = baseUrl + "/api/base/appversion/get";//App更新接口
}
