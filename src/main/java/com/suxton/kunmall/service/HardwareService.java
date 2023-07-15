package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.CPU;
import com.suxton.kunmall.pojo.Recommends;

import java.util.List;

public interface HardwareService {
//    List<Recommends> getAllRecommends();

    List<String[]> getResolvedRecommendsList();

    List<String[]> getCPUInfoList();

    List<String[]> getGPUInfoList();

    List<String[]> getMemoryInfoList();

    List<String[]> getDriveInfoList();
}
