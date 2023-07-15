package com.suxton.kunmall.dao;

import com.suxton.kunmall.pojo.GPU;
import com.suxton.kunmall.pojo.GPUExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GPUMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    long countByExample(GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int deleteByExample(GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int insert(GPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int insertSelective(GPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    List<GPU> selectByExample(GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    GPU selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int updateByExampleSelective(@Param("row") GPU row, @Param("example") GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int updateByExample(@Param("row") GPU row, @Param("example") GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int updateByPrimaryKeySelective(GPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Sun Jul 16 01:24:10 CST 2023
     */
    int updateByPrimaryKey(GPU row);
}