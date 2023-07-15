package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.*;
import com.suxton.kunmall.pojo.*;
import com.suxton.kunmall.service.HardwareService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.boot.logging.log4j2.*;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HardwareServiceImpl implements HardwareService {

    private static final Logger logger = LoggerFactory.getLogger(HardwareServiceImpl.class);


    @Resource
    private RecommendsMapper recommendsMapper;
    @Resource
    private CPUMapper cpuMapper;
    @Resource
    private GPUMapper gpuMapper;
    @Resource
    private MemoryMapper memoryMapper;
    @Resource
    private DriveMapper driveMapper;

    private List<Recommends> getAllRecommends() {
        RecommendsExample recommendsExample = new RecommendsExample();
        recommendsExample.or().andCpuidIsNotNull();
        return recommendsMapper.selectByExample(recommendsExample);
    }

    @Override
    public List<String[]> getResolvedRecommendsList() {
        List<String[]> recommendsResolved = new ArrayList<>();
        getAllRecommends().forEach(recommend -> {
            String[] strings = new String[6];
            Integer cpuid = recommend.getCpuid();
            Integer gpuid = recommend.getGpuid();
            Integer driveid = recommend.getDriveid();
            Integer memoryid = recommend.getMemoryid();
            CPU cpu = cpuMapper.selectByPrimaryKey(cpuid);
            GPU gpu = gpuMapper.selectByPrimaryKey(gpuid);
            Drive drive = driveMapper.selectByPrimaryKey(driveid);
            Memory memory = memoryMapper.selectByPrimaryKey(memoryid);
            BigDecimal sum = BigDecimal.ZERO;
            strings[0] = cpu.getName();
            sum = sum.add(cpu.getMoney());
            strings[1] = gpu.getName();
            sum = sum.add(gpu.getMoney());
            strings[2] = memory.getName();
            sum = sum.add(memory.getMoney());
            strings[3] = drive.getName();
            sum = sum.add(drive.getMoney());
            strings[4] = sum.toString();
            strings[5] = recommend.getComment();
            recommendsResolved.add(strings);
        });
        return recommendsResolved;
    }

    @Override
    public CPU getCPUById(int id) {
        return null;
    }


}
