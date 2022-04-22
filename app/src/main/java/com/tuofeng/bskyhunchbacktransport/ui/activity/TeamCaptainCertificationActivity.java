package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.bumptech.glide.Glide;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityDriverTeamcaptainCertificationBindingImpl;
import com.tuofeng.bskyhunchbacktransport.in.ITeamCaptainCertificationView;
import com.tuofeng.bskyhunchbacktransport.utils.CommonUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.TeamCaptainCertificationActViewModel;

public class TeamCaptainCertificationActivity extends BaseActivity<ActivityDriverTeamcaptainCertificationBindingImpl, TeamCaptainCertificationActViewModel> implements ITeamCaptainCertificationView, View.OnClickListener {

    private ImageView mImageIDCardFront, mImageIDCardReverse;
    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;

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

        mImageIDCardFront = findViewById(R.id.image_id_card_front);
        mImageIDCardReverse = findViewById(R.id.image_id_card_reverse);

        mImageIDCardFront.setOnClickListener(this);
        mImageIDCardReverse.setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_id_card_front:
                startOCRAct(1);
                break;
            case R.id.image_id_card_reverse:
                startOCRAct(2);
                break;
        }
    }

    private void startOCRAct(int type) {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH, CommonUtil.getSaveFile(getApplication()).getAbsolutePath());
        if (type == 1) {//正面
            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
        } else {//反面
            intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
        }
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = CommonUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                ImageView imageView = null;
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        CommonUtil.recIDCard(this, IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                        imageView = mImageIDCardFront;
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        CommonUtil.recIDCard(this, IDCardParams.ID_CARD_SIDE_BACK, filePath);
                        imageView = mImageIDCardReverse;
                    }
                    Glide.with(this)
                            .load(filePath)
                            .placeholder(R.mipmap.id_card_front)
                            .into(imageView);
                }
            }
        }
    }

    @Override
    public void SubmitCertification() {
        Intent intent = new Intent(this, TeamCaptainCertificationReview.class);
        startActivity(intent);
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
}
