package com.pmdevelop.propertymanagement.mapper;

import com.pmdevelop.propertymanagement.entity.PaymentRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentRecordMapper {

    List<PaymentRecord> findAll();

    PaymentRecord findById(@Param("id") Integer id);

    void insert(PaymentRecord record);

    void update(PaymentRecord record);

    void delete(@Param("id") Integer id);

    //根据房间Id查询缴费记录
    List<PaymentRecord> getPaymentRecordByRoomId(@Param("roomId") Integer roomId,
                                                 @Param("paymentStatus") Boolean paymentStatus);


    List<PaymentRecord> getPaymentList(@Param("Integer") Integer communityId,
                                       @Param("building") Integer building,
                                       @Param("unit") Integer unit,
                                       @Param("room") Integer room);

    //查询房间最近一次未缴费账单
    PaymentRecord getPayBill(@Param("Integer") Integer communityId,
                             @Param("building") Integer building,
                             @Param("unit") Integer unit,
                             @Param("room") Integer room);
}
