package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.MomentMapper;
import com.suxton.kunmall.dao.PhotoMapper;
import com.suxton.kunmall.pojo.*;
import com.suxton.kunmall.service.MomentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MomentServiceImpl implements MomentService {
    @Resource
    private MomentMapper momentMapper;
    @Resource
    private PhotoMapper photoMapper;

    @Override
    public List<MomentWithPhoto> getMoments() {
        List<MomentWithPhoto> momentWithPhotoList = new ArrayList<>();
        MomentExample momentExample = new MomentExample();
        momentExample.setOrderByClause("id DESC");
        momentMapper.selectByExampleWithBLOBs(momentExample).forEach(moment -> {
//            System.out.println(moment);
            MomentWithPhoto momentWithPhoto = new MomentWithPhoto(moment);
            int id = momentWithPhoto.getId();

            PhotoExample photoExample = new PhotoExample();
            photoExample.or().andMomentIdEqualTo(id);
            photoMapper.selectByExampleWithBLOBs(photoExample).forEach(photo -> {
                momentWithPhoto.addPhotoAndCodedWithBase64(photo.getPhoto());
            });
            momentWithPhotoList.add(momentWithPhoto);
        });
        return momentWithPhotoList;
    }

    @Override
    public int addMoment(String userName, int userID, String text) {
        long time = Instant.now().toEpochMilli();
        Moment moment = new Moment();
        moment.setUserId(userID);
        moment.setUserName(userName);
        moment.setContent(text);
        moment.setCommentNum(0);
        moment.setLikeNum(0);
        moment.setTimePosted(time);
        momentMapper.insert(moment);
        MomentExample momentExample = new MomentExample();
        momentExample.or().andTimePostedEqualTo(time).andUserIdEqualTo(userID);
        moment = momentMapper.selectByExample(momentExample).get(0);
        return moment.getId();
    }

    @Override
    public void addPhoto(int momentID, byte[] bytes) {
        Photo photo = new Photo();
        photo.setPhoto(bytes);
        photo.setMomentId(momentID);
        photoMapper.insert(photo);
    }
}
