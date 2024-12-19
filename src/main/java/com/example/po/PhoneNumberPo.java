package com.example.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * phone_number
 */
@TableName("phone_number")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneNumberPo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
