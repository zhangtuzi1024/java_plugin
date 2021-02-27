package com.zhangtuzi.app.common.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管制信息表
 * </p>
 *
 * @author zhangtuzi
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Controlinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事件id
     */
    @TableField("EventId")
    private String EventId;

    /**
     * 方向
     */
    @TableField("Direction")
    private String Direction;

    /**
     * 高速名称
     */
    @TableField("RoadName")
    private String RoadName;

    /**
     * 站点名称
     */
    @TableField("StationName")
    private String StationName;

    /**
     * 管制状态（0-开启、1-关闭、2-限流、3-分流）
     */
    @TableField("Status")
    private Integer Status;

    /**
     * 管制原因
     */
    @TableField("Reason")
    private String Reason;

    /**
     * 出入标识（0-入，1-出）
     */
    @TableField("Label")
    private Integer Label;

    /**
     * 记录时间
     */
    @TableField("RecordDate")
    private LocalDateTime RecordDate;

    /**
     * 管制信息类型 0-未结束，1-结束
     */
    @TableField("Type")
    private Integer Type;

    /**
     * 管制结束时间
     */
    @TableField("EndTime")
    private LocalDateTime EndTime;


}
