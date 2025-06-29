package com.nineai.nineai.dao.requestdto;

import com.nineai.nineai.dao.AuthTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 登录请求参数
 */
@Schema(name = "LoginInfoRequestDTO", description = "登录请求体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfoRequestDTO {
    @Schema(description = "登录方式：EMAIL / PHONE", required = true, example = "EMAIL")
    private AuthTypeEnum loginType;      // ← 新增字段
    @Schema(description = "用户名 / 邮箱 / 手机号", example = "admin")
    private String username;

    @Schema(description = "登录密码（明文经 HTTPS 传输，后端加密处理）", example = "123456")
    private String password;
}
