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
@TableName("wxb_policy_day_manager")
@Data
public class PolicyDayManagerPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单位id
     */
    private Integer unitMasterId;

    /**
     * wxb_lift表主键id
     */
    private Integer wxbLiftId;

    /**
     * 排查人用户id
     */
    private String investigationUserName;

    /**
     * 排查状态：0-未排查，1-已排查
     */
    private Byte investigationStatus;

    /**
     * 排查结果：0-无风险，1-有风险
     */
    private Byte investigationResult;

    /**
     * 整改状态：1-未整改，2-部分整改，3-整改完成，4-无需整改
     */
    private Byte remediationStatus;

    /**
     * 排查项选项json
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


    private Integer sharding;

    private Byte appCodeSource;


}
