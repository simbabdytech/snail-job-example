package com.example.bo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * excel表格手机号BO
 */
@Data
public class PhoneNumberBo {

    @ExcelProperty(value = "手机号码", index = 0)
    private String phoneNumber;

}
