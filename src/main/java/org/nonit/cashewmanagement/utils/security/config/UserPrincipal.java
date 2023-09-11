package org.nonit.cashewmanagement.utils.security.config;

import org.nonit.cashewmanagement.entity.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Principal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserPrincipal implements Principal {
    private String username;
    private RoleEnum role;

    @Override
    public String getName() {
        return username;
    }
}
