package com.pmdevelop.propertymanagement.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private Boolean status;
    private int code;     // 响应码
    private String msg;   // 响应消息
    private T data;       // 响应数据（泛型，可以是任何类型）

    // 方便创建成功响应的静态方法，返回数据
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, 200, "操作成功", data);
    }

    // 方便创建成功响应的静态方法，无数据
    public static ApiResponse<Object> success() {
        return new ApiResponse<>(true,200, "操作成功", null);
    }

    // 方便创建失败响应的静态方法
    public static ApiResponse<Object> error(int code, String msg) {
        return new ApiResponse<>(false, code, msg, null);
    }
}
