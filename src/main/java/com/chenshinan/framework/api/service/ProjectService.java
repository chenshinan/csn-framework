package com.chenshinan.framework.api.service;

import com.chenshinan.framework.api.dto.PageInfo;
import com.chenshinan.framework.domain.Project;

/**
 * @author shinan.chen
 * @Date 2021/5/16
 */
public interface ProjectService {
    /**
     * 基础创建（内置是否创建成功判断）
     *
     * @param create 创建对象
     * @return 结果
     */
    Project baseCreate(Project create);

    /**
     * 基础修改（内置是否修改成功判断）
     *
     * @param update 修改对象
     * @return 结果
     */
    Project baseUpdate(Project update);

    /**
     * 单条记录查询（内置npe判断）
     *
     * @param id 主键
     * @return 结果
     */
    Project selectById(Long id);

    /**
     * 单条记录删除（内置是否删除成功判断）
     *
     * @param id 主键
     */
    void deleteById(Long id);

    /**
     * 分页查询
     *
     * @param keyword  关键词
     * @param pageNum  分页页码
     * @param pageSize 分页大小
     * @return 分页对象
     */
    PageInfo<Project> page(String keyword, Integer pageNum, Integer pageSize);
}
