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
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    long countByExample(GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int deleteByExample(GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int insert(GPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int insertSelective(GPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    List<GPU> selectByExample(GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    GPU selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByExampleSelective(@Param("row") GPU row, @Param("example") GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByExample(@Param("row") GPU row, @Param("example") GPUExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByPrimaryKeySelective(GPU row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table GPU
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByPrimaryKey(GPU row);
}