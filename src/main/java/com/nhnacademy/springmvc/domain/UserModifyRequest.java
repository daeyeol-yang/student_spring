package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class UserModifyRequest {
    @NotNull
    @Size(max = 50)
    String name;

    @Min(0)
    int age;
}
