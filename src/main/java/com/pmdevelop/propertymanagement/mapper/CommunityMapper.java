package com.pmdevelop.propertymanagement.mapper;

import com.pmdevelop.propertymanagement.entity.Community;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    List<Community> findAll();

    Community findById(Integer id);

    void insert(Community community);

    void delete(Integer id);
}
