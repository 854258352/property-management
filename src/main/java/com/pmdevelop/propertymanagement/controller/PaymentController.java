package com.pmdevelop.propertymanagement.controller;

import com.pmdevelop.propertymanagement.entity.PaymentRecord;
import com.pmdevelop.propertymanagement.response.ApiResponse;
import com.pmdevelop.propertymanagement.service.PaymentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody  // 表示返回的是 JSON 格式
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentRecordService paymentRecordService;

    @GetMapping("/list")
    public ApiResponse<List<PaymentRecord>> getAll() {
        return ApiResponse.success(paymentRecordService.findAll());
    }

    //根据roomId查询缴费记录
    @GetMapping()
    public ApiResponse<Object> getById(@RequestParam Integer roomId,
                                       @RequestParam("paymentStatus") Boolean paymentStatus) {
        List<PaymentRecord> recordList = paymentRecordService.getPaymentRecordByRoomId(roomId, paymentStatus);
        if (recordList.isEmpty()) {
            return ApiResponse.error(404, "该房间下没有缴费记录");
        } else {
            return ApiResponse.success(recordList);
        }
    }
    //自己凑合看吧
    @GetMapping("/getBill")
    public ApiResponse<Object> getBill(@RequestParam(value = "communityId", required = false) Integer communityId,
                                       @RequestParam(value = "building", required = false) Integer building,
                                       @RequestParam(value = "unit", required = false) Integer unit,
                                       @RequestParam(value = "room", required = false) Integer room) {
        List<PaymentRecord> recordList = paymentRecordService.getPaymentList(communityId, building, unit, room);
        if (recordList.isEmpty()) {
            return ApiResponse.error(404, "无法查询到相关缴费记录");
        }
        return ApiResponse.success(recordList);
    }

    @GetMapping("/getPayBill")
    public ApiResponse<Object> getPayBill(@RequestParam(value = "communityId", required = false) Integer communityId,
                                       @RequestParam(value = "building", required = false) Integer building,
                                       @RequestParam(value = "unit", required = false) Integer unit,
                                          @RequestParam(value = "room", required = false) Integer room) {
        PaymentRecord record = paymentRecordService.getPayBill(communityId, building, unit, room);
        if (record == null) {
            return ApiResponse.error(404, "未找到相关支付信息");
        }
        return ApiResponse.success(record);
    }

//    @PostMapping("/")
//    public ApiResponse<Void> add(@RequestBody PaymentRecord record) {
//        paymentRecordService.insert(record);
//        return ApiResponse.success();
//    }
//
//    @PutMapping("/")
//    public ApiResponse<Void> update(@RequestBody PaymentRecord record) {
//        paymentRecordService.update(record);
//        return ApiResponse.success();
//    }
//
//    @DeleteMapping("/{id}")
//    public ApiResponse<Void> delete(@PathVariable Integer id) {
//        paymentRecordService.delete(id);
//        return ApiResponse.success();
//    }
}
