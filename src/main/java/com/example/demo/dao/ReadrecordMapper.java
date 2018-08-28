package com.example.demo.dao;

import com.example.demo.model.Readrecord;
import com.example.demo.model.ReadrecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ReadrecordMapper {
    long countByExample(ReadrecordExample example);

    int deleteByExample(ReadrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Readrecord record);

    int insertSelective(Readrecord record);

    List<Readrecord> selectByExample(ReadrecordExample example);

    Readrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Readrecord record, @Param("example") ReadrecordExample example);

    int updateByExample(@Param("record") Readrecord record, @Param("example") ReadrecordExample example);

    int updateByPrimaryKeySelective(Readrecord record);

    int updateByPrimaryKey(Readrecord record);
}