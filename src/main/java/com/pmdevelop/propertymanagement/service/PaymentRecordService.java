package com.pmdevelop.propertymanagement.service;

import com.pmdevelop.propertymanagement.entity.PaymentRecord;
import com.pmdevelop.propertymanagement.mapper.PaymentRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentRecordService {

    @Autowired
    private PaymentRecordMapper paymentRecordMapper;

    public List<PaymentRecord> findAll() {
        return paymentRecordMapper.findAll();
    }

    public PaymentRecord findById(Integer id) {
        return paymentRecordMapper.findById(id);
    }

    public void insert(PaymentRecord record) {
        paymentRecordMapper.insert(record);
    }

    public void update(PaymentRecord record) {
        paymentRecordMapper.update(record);
    }

    public void delete(Integer id) {
        paymentRecordMapper.delete(id);
    }

    //根据房间Id查询缴费记录
    public List<PaymentRecord> getPaymentRecordByRoomId(Integer roomId, Boolean paymentStatus) {
        return paymentRecordMapper.getPaymentRecordByRoomId(roomId, paymentStatus);
    }

    //不知道查啥，爱查啥就查啥吧
    public List<PaymentRecord> getPaymentList(Integer communityId, Integer building, Integer unit, Integer room) {
           List<PaymentRecord> recordList = paymentRecordMapper.getPaymentList(communityId, building, unit, room);
           return recordList;
    }

    //查询房间最近一次未缴费的纪律
    public PaymentRecord getPayBill(Integer communityId, Integer building, Integer unit, Integer room) {
        PaymentRecord paymentRecord = paymentRecordMapper.getPayBill(communityId, building, unit, room);
        return paymentRecord;
    }
}
