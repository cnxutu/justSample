package com.example.demo.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xutu
 * @since 2023-09-19
 */
@TableName("wxb_policy_week_manager")
@Data
public class PolicyWeekManagerPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单位id
     */
    private Integer unitMasterId;

    /**
     * 排查周期开始时间
     */
    private Date investigationStartDate;

    /**
     * 排查周期结束时间
     */
    private Date investigationEndDate;

    /**
     * 排查时间
     */
    private Date investigationDate;

    private Byte investigationStatus;

    /**
     * 排查人用户id
     */
    private String investigationUserName;

    /**
     * 周排查选项json
     */
    private String selectOptionJson;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 操作更新人
     */
    private Integer operator;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    private Byte isDeleted;

}
