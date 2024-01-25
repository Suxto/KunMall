package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.Moment;
import com.suxton.kunmall.pojo.MomentWithPhoto;

import java.util.List;

public interface MomentService {
    List<MomentWithPhoto> getMoments();

    int addMoment(String userName, int userID, String text);

    void addPhoto(int momentID, byte[] bytes);
}
