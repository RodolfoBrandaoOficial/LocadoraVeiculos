package com.rodolfobrandao.aulajavacollectionsproject.models.json.response;

import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Calendar;

@Getter
@FieldDefaults(makeFinal = true)
public class ExceptionResponse {

    String error;
    LocalDateTime dataHora;
    String path;
    String message;
    int status;

    public ExceptionResponse(Exception ex) {
        this.status = 500;
        this.message = "Chegamos aqui. Tente novamente";
        this.path = ex.getStackTrace()[0].getFileName();
        this.error = ex.getMessage();
        this.dataHora = Calendar.getInstance().getTime().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
    }
}
