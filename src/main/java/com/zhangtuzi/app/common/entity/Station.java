package com.zhangtuzi.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 站点信息表
 * </p>
 *
 * @author zhangtuzi
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 高速公路编号
     */
    @TableField("NewGBCode")
    private String NewGBCode;

    /**
     * 高速公路名称
     */
    @TableField("NewGBName")
    private String NewGBName;

    /**
     * 站点名称
     */
    @TableField("StationName")
    private String StationName;

    /**
     * 站点位置
     */
    @TableField("Location")
    private Integer Location;

    /**
     * 站点编号
     */
    @TableField("StationCode")
    private Integer StationCode;

    /**
     * 方向
     */
    @TableField("Direction")
    private String Direction;

    /**
     * 站点原始名称
     */
    @TableField("OriginName")
    private String OriginName;


}
