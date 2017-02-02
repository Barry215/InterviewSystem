package com.frank.dao;

import com.frank.entity.Section;
import org.springframework.stereotype.Repository;

public interface SectionMapper {
    int deleteByPrimaryKey(Integer sectionId);

    int insert(Section section);

    int insertSelective(Section section);

    Section selectByPrimaryKey(Integer sectionId);

    int updateByPrimaryKeySelective(Section section);

    int updateByPrimaryKey(Section section);
}