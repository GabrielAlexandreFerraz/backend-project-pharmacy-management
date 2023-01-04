package com.api.projectpharmacy.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ExceptionDto {
    private int status;
    private String message;
    private String error;
    private Throwable cause;

}
