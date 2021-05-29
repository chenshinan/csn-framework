package com.chenshinan.framework.api.dto;

import lombok.Data;

/**
 * 分页入参对象
 *
 * @author shinan.chen
 * @since 2021/5/16
 */
@Data
public class PageSearchParam {
    /**
     * 当前页码，最小值为1
     */
    private Integer pageNum;
    /**
     * 每页显示的行数
     */
    private Integer pageSize;
}
