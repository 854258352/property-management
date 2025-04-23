package com.pmdevelop.propertymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // 生成无参构造方法
@AllArgsConstructor // 生成全参构造方法
public class Room {

    private Integer id;  // 房间ID（主键）

    private Integer communityId;  // 小区ID

    private Integer building;  // 楼号

    private Integer unit;  // 单元号

    private String roomNum;  // 房间门牌号

    private Boolean parking;  // 是否有车位

    private Integer area;  // 房间面积（平方米）
}
