package com.suxton.kunmall.pojo;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class MomentWithPhoto extends Moment {
    //    private final Moment moment;
    private final List<String> photos = new ArrayList<>();

    public void addPhotoAndCodedWithBase64(byte[] bytes) {
        String base64Image = Base64.getEncoder().encodeToString(bytes);
        photos.add(base64Image);
    }

    public MomentWithPhoto(Moment moment) {
        this.setContent(moment.getContent());
        this.setId(moment.getId());
        this.setUserId(moment.getUserId());
        this.setUserName(moment.getUserName());
        this.setCommentNum(moment.getCommentNum());
        this.setLikeNum(moment.getLikeNum());
        this.setTimePosted(moment.getTimePosted());
    }

    public List<String> getPhotos() {
        return photos;
    }

}
