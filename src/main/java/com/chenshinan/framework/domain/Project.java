package com.chenshinan.framework.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author shinan.chen
 * @date 2021/05/16
 */
@Data
@Table(name = "project")
public class Project extends BaseDO {

    private String code;
    private String name;
    private String description;

    @TableField(exist = false)
    private BigDecimal sequence;
}
