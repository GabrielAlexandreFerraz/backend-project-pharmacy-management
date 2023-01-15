package com.api.projectpharmacy.respostaPadrao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaPadrao<T> {
    private T status;
    private String mensagem;
    private T dados;

    public void setStatus(HttpStatus ok) {
    }

    public void setStatus() {
    }
}
