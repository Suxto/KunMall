package com.suxton.kunmall.mapper;

import com.suxton.kunmall.pojo.Recommends;
import com.suxton.kunmall.pojo.RecommendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    long countByExample(RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int deleteByExample(RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int insert(Recommends row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int insertSelective(Recommends row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    List<Recommends> selectByExample(RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    Recommends selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int updateByExampleSelective(@Param("row") Recommends row, @Param("example") RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int updateByExample(@Param("row") Recommends row, @Param("example") RecommendsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int updateByPrimaryKeySelective(Recommends row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Recommends
     *
     * @mbg.generated Fri Jul 14 14:21:49 CST 2023
     */
    int updateByPrimaryKey(Recommends row);
}