package com.nineai.nineai.dao.reponsevo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRespDTO {
    private String token;
    private Long   expireAt;
}
