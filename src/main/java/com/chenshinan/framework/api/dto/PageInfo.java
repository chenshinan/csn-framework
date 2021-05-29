package com.chenshinan.framework.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 *
 * @author shinan.chen
 * @since 2021/5/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {
    /**
     * 当前页码，最小值为1
     */
    private Integer pageNum;
    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 数据总数
     */
    private Integer total;
    /**
     * 数据集合
     */
    private List<T> list;
}
