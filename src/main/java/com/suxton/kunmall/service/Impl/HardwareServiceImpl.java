package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.*;
import com.suxton.kunmall.pojo.*;
import com.suxton.kunmall.service.HardwareService;
import jakarta.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
    public List<String[]> getCPUInfoList() {
        CPUExample cpuExample = new CPUExample();
        List<String[]> cpuList = new ArrayList<>();
        cpuMapper.selectByExample(cpuExample).forEach(cpu -> {
            String[] strings = new String[2];
            strings[0] = cpu.getName();
            strings[1] = cpu.getMoney().toString();
            cpuList.add(strings);
        });
        return cpuList;
    }

    @Override
    public List<String[]> getGPUInfoList() {
        List<String[]> gpuList = new ArrayList<>();
        gpuMapper.selectByExample(new GPUExample()).forEach(cpu -> {
            String[] strings = new String[2];
            strings[0] = cpu.getName();
            strings[1] = cpu.getMoney().toString();
            gpuList.add(strings);
        });
        return gpuList;
    }

    @Override
    public List<String[]> getMemoryInfoList() {
        List<String[]> list = new ArrayList<>();
        memoryMapper.selectByExample(new MemoryExample()).forEach(cpu -> {
            String[] strings = new String[2];
            strings[0] = cpu.getName();
            strings[1] = cpu.getMoney().toString();
            list.add(strings);
        });
        return list;
    }

    @Override
    public List<String[]> getDriveInfoList() {
        List<String[]> list = new ArrayList<>();
        driveMapper.selectByExample(new DriveExample()).forEach(cpu -> {
            String[] strings = new String[2];
            strings[0] = cpu.getName();
            strings[1] = cpu.getMoney().toString();
            list.add(strings);
        });
        return list;
    }

    @Override
    public HashMap<String, Integer> getRecommendDetail(int id) {
        Recommends recommends = recommendsMapper.selectByPrimaryKey(id);
        HashMap<String, Integer> details = new HashMap<>();
        details.put("CPUSel", recommends.getCpuid());
        details.put("GPUSel", recommends.getGpuid());
        details.put("MemorySel", recommends.getMemoryid());
        details.put("DriveSel", recommends.getDriveid());
        return details;
    }

    @Override
    public List<CPU> getCPUList() {
        return cpuMapper.selectByExample(new CPUExample());
    }

    @Override
    public List<GPU> getGPUList() {
        return gpuMapper.selectByExample(new GPUExample());
    }

    @Override
    public List<Memory> getMemoryList() {
        return memoryMapper.selectByExample(new MemoryExample());
    }

    @Override
    public List<Drive> getDriveList() {
        return driveMapper.selectByExample(new DriveExample());
    }

    @Override
    public void updateCPU(int id, double price, int amount) {
        CPU cpu = cpuMapper.selectByPrimaryKey(id);
        cpu.setMoney(BigDecimal.valueOf(price));
        cpu.setAmount(amount);
        cpuMapper.updateByPrimaryKey(cpu);
    }

    @Override
    public void updateGPU(int id, double price, int amount) {
        GPU gpu = gpuMapper.selectByPrimaryKey(id);
        gpu.setMoney(BigDecimal.valueOf(price));
        gpu.setAmount(amount);
        gpuMapper.updateByPrimaryKey(gpu);
    }

    @Override
    public void updateMemory(int id, double price, int amount) {
        Memory memory = memoryMapper.selectByPrimaryKey(id);
        memory.setAmount(amount);
        memory.setMoney(BigDecimal.valueOf(price));
        memoryMapper.updateByPrimaryKey(memory);
    }

    @Override
    public void updateDrive(int id, double price, int amount) {
        Drive drive = driveMapper.selectByPrimaryKey(id);
        drive.setAmount(amount);
        drive.setMoney(BigDecimal.valueOf(price));
        driveMapper.updateByPrimaryKey(drive);
    }

    @Override
    public void deleteCPU(int id) {
        cpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteGPU(int id) {
        gpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteMemory(int id) {
        memoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteDrive(int id) {
        driveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addCPU(String name, double price, int amount) {
        CPU cpu = new CPU();
        cpu.setAmount(amount);
        cpu.setName(name);
        cpu.setMoney(BigDecimal.valueOf(price));
        cpuMapper.insert(cpu);
    }

    @Override
    public void addGPU(String name, double price, int amount) {
        GPU gpu = new GPU();
        gpu.setAmount(amount);
        gpu.setName(name);
        gpu.setMoney(BigDecimal.valueOf(price));
        gpuMapper.insert(gpu);
    }

    @Override
    public void addMemory(String name, double price, int amount) {
        Memory memory = new Memory();
        memory.setAmount(amount);
        memory.setName(name);
        memory.setMoney(BigDecimal.valueOf(price));
        memoryMapper.insert(memory);
    }

    @Override
    public void addDrive(String name, double price, int amount) {
        Drive drive = new Drive();
        drive.setAmount(amount);
        drive.setName(name);
        drive.setMoney(BigDecimal.valueOf(price));
        driveMapper.insert(drive);
    }

}
