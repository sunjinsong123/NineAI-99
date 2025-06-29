package com.nineai.nineai.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一 API 响应包装
 *
 * @param <T> 业务数据类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /** 业务状态码：0=成功；其它=失败 */
    private Integer code;

    /** 文本信息：成功 / 错误描述 */
    private String msg;

    /** 真实返回数据；失败时可为 null */
    private T data;

    /* ---------- 静态工厂 ---------- */

    public static <T> Result<T> success() {
        return new Result(0, "success", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(0, "success", data);
    }
    public static <T> Result<T> success(String msg) {
        return new Result(0, msg, null);
    }
    public static <T> Result<T> fail(int code, String msg) {
        return new Result(code, msg, null);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result(-1, msg, null);
    }
}
