package com.suxton.kunmall.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderData {
  private String CPUName;
  private String GPUName;
  private String MemoryName;
  private String DriveName;
  private double sum;
  private String address;
  private String comment;
}
