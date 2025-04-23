package com.pmdevelop.propertymanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // 生成无参构造方法
@AllArgsConstructor // 生成全参构造方法
public class Community {

    private Integer communityId;

    private String communityName;

    private String address;

    private Integer totalNumber;

    private String adminAccount;

    private String adminPassword;

    @JsonProperty("adminPassword")  // 使用自定义 Getter 返回隐藏的密码
    public String getAdminPassword() {
        // 这里可以返回一个掩码密码或者其他内容
        return "******";  // 或者返回加密后的密码
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String adminLastLoginTime;  // 示例字段，注意日期格式

}
