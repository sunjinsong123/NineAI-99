package com.nineai.nineai.dao;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "登录方式")
public enum AuthTypeEnum {
    EMAIL,   // 邮箱登录
    PHONE    // 手机号登录
}