package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.Comment;
import com.suxton.kunmall.pojo.MomentWithPhoto;

import java.util.List;

public interface MomentService {
    List<MomentWithPhoto> getMoments();

    int addMoment(String userName, int userID, String text);

    void addPhoto(int momentID, byte[] bytes);

    List<Comment> getCommentList(int id);

    void addComment(int user_id, String userName, int moment_id, String content);

    int like(int userID, int momentID);
}
