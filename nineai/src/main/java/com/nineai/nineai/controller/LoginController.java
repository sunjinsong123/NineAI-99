package com.nineai.nineai.controller;

import com.nineai.nineai.common.Result;
import com.nineai.nineai.dao.reponsevo.LoginRespDTO;
import com.nineai.nineai.dao.requestdto.LoginInfoRequestDTO;
import com.nineai.nineai.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Tag(name = "Auth 模块", description = "登录 / 注册相关接口")
@CrossOrigin(origins = "http://localhost:5173")   // 可以写 "*", 但开发完建议收紧
@RestController
@RequestMapping("")
public class LoginController {

    /**
     * 用户登录
     */
    @Operation(
            summary = "用户登录",
            description = "用户名 + 密码登录，成功后返回统一 Result 包装的消息或 Token"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "400", description = "参数校验失败")
    })
    @PostMapping("/login")
    public Result<LoginRespDTO> login(
            @Parameter(description = "登录请求体", required = true)
            @RequestBody LoginInfoRequestDTO requestDTO) {

        if (Objects.isNull(requestDTO)
                || Objects.isNull(requestDTO.getUsername())
                || Objects.isNull(requestDTO.getPassword())) {
            return Result.fail("请输入正确的用户名和密码");
        }
        String token = JwtUtil.generateToken(requestDTO.getUsername());
        long expireAt = System.currentTimeMillis();
        // 伪代码：校验用户名密码
        // boolean ok = authService.check(requestDTO);
        // if (!ok) return Result.fail("用户名或密码错误");

        return Result.success(new LoginRespDTO(token, expireAt));
    }
}
