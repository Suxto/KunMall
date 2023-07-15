package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.CPU;
import com.suxton.kunmall.pojo.Recommends;

import java.util.List;

public interface HardwareService {
//    List<Recommends> getAllRecommends();

    List<String[]> getResolvedRecommendsList();

    CPU getCPUById(int id);
}
