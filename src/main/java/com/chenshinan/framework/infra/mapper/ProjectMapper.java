package com.chenshinan.framework.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenshinan.framework.domain.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shinan.chen
 * @date 2021/05/16
 */
@Component
public interface ProjectMapper extends BaseMapper<Project> {
    Integer count(@Param("keyword") String keyword);

    List<Project> page(@Param("keyword") String keyword, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
