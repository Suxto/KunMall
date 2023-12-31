package com.suxton.kunmall.dao;

import com.suxton.kunmall.pojo.CPU;
import com.suxton.kunmall.pojo.CPUExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CPUMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    long countByExample(CPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int deleteByExample(CPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int insert(CPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int insertSelective(CPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    List<CPU> selectByExample(CPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    CPU selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int updateByExampleSelective(@Param("row") CPU row, @Param("example") CPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int updateByExample(@Param("row") CPU row, @Param("example") CPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int updateByPrimaryKeySelective(CPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPU
     *
     * @mbg.generated Mon Jul 17 14:47:32 CST 2023
     */
    int updateByPrimaryKey(CPU row);
}