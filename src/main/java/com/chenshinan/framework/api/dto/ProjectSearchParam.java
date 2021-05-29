package com.chenshinan.framework.api.dto;

import lombok.Data;

/**
 * 分页入参对象
 *
 * @author shinan.chen
 * @since 2021/5/16
 */
@Data
public class ProjectSearchParam extends PageSearchParam {
    /**
     * 搜索关键词
     */
    private String keyword;
}
