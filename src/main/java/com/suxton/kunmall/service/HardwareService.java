package com.suxton.kunmall.service;

import java.util.HashMap;
import java.util.List;

public interface HardwareService {
//    List<Recommends> getAllRecommends();

    List<String[]> getResolvedRecommendsList();

    List<String[]> getCPUInfoList();

    List<String[]> getGPUInfoList();

    List<String[]> getMemoryInfoList();

    List<String[]> getDriveInfoList();

    HashMap<String, Integer> getRecommendDetail(int id);
}
