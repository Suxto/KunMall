package com.suxton.kunmall.dao;

import com.suxton.kunmall.pojo.Memory;
import com.suxton.kunmall.pojo.MemoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    long countByExample(MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int deleteByExample(MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int insert(Memory row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int insertSelective(Memory row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    List<Memory> selectByExample(MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    Memory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByExampleSelective(@Param("row") Memory row, @Param("example") MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByExample(@Param("row") Memory row, @Param("example") MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByPrimaryKeySelective(Memory row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Memory
     *
     * @mbg.generated Thu Jan 25 18:43:37 CST 2024
     */
    int updateByPrimaryKey(Memory row);
}