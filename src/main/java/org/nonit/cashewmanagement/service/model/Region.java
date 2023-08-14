package org.nonit.cashewmanagement.service.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

}
