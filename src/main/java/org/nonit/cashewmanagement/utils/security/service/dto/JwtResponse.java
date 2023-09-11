package org.nonit.cashewmanagement.utils.security.service.dto;

import org.nonit.cashewmanagement.entity.StatusEnum;
import org.nonit.cashewmanagement.entity.RoleEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private String username;
    private RoleEnum role;
    private String type = "Bearer";
    private StatusEnum status;

    public JwtResponse(String token, String username, RoleEnum role, StatusEnum status) {
        this.token = token;
        this.username = username;
        this.role = role;
        this.status = status;
    }
}
