package com.suxton.kunmall.dao;

import com.suxton.kunmall.pojo.Recommends;
import com.suxton.kunmall.pojo.RecommendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    long countByExample(RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int deleteByExample(RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int insert(Recommends row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int insertSelective(Recommends row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    List<Recommends> selectByExample(RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    Recommends selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int updateByExampleSelective(@Param("row") Recommends row, @Param("example") RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int updateByExample(@Param("row") Recommends row, @Param("example") RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int updateByPrimaryKeySelective(Recommends row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Thu Jan 25 16:04:20 CST 2024
     */
    int updateByPrimaryKey(Recommends row);
}