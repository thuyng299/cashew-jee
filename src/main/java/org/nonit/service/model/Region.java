package org.nonit.service.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    private Long id;

    @NotBlank
    private String name;

}
