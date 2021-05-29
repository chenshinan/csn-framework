package com.chenshinan.framework.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenshinan.framework.api.dto.PageInfo;
import com.chenshinan.framework.api.service.ProjectService;
import com.chenshinan.framework.domain.Project;
import com.chenshinan.framework.infra.exception.CsnException;
import com.chenshinan.framework.infra.mapper.ProjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author shinan.chen
 * @Date 2019/5/22
 */
@Component
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Project baseCreate(Project create) {
        create.setGmtCreate(new Date());
        create.setGmtModified(new Date());
        if (projectMapper.insert(create) != 1) {
            throw new CsnException("");
        }
        return create;
    }

    @Override
    public Project baseUpdate(Project update) {
        update.setGmtModified(new Date());
        if (projectMapper.updateById(update) != 1) {
            throw new CsnException("");
        }
        return update;
    }

    @Override
    public Project selectById(Long id) {
        Project one = projectMapper.selectById(id);
        if (one == null) {
            throw new CsnException("");
        }
        return one;
    }

    @Override
    public void deleteById(Long id) {
        this.selectById(id);
        if (projectMapper.deleteById(id) != 1) {
            throw new CsnException("");
        }
    }

    @Override
    public PageInfo<Project> page(String keyword, Integer pageNum, Integer pageSize) {
        Integer count = projectMapper.count(keyword);
        List<Project> list = projectMapper.page(keyword, pageNum, pageSize);
        return new PageInfo<>(pageNum, pageSize, count, list);
    }
}
