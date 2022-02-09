package com.tuofeng.bskyhunchbacktransport.module.bean;

/**
 * Created by qiaolulu on 2019/06/28.
 */
public class ImageTitleBean extends BaseBean{

    private String imageUrl;
    private String title;
    private int imageId;


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
