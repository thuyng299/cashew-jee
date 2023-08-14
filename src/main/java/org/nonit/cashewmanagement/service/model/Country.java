package org.nonit.cashewmanagement.service.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

    private Long id;

    @NotBlank
    private String name;

    private Long regionId;

    private String regionName;
}
