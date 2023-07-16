package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.CPU;
import com.suxton.kunmall.pojo.Drive;
import com.suxton.kunmall.pojo.GPU;
import com.suxton.kunmall.pojo.Memory;

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

    List<CPU> getCPUList();

    List<GPU> getGPUList();

    List<Memory> getMemoryList();

    List<Drive> getDriveList();

    void updateCPU(int id, double price, int amount);

    void updateGPU(int id, double price, int amount);

    void updateMemory(int id, double price, int amount);

    void updateDrive(int id, double price, int amount);
}
