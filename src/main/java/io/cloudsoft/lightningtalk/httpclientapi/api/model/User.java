package io.cloudsoft.lightningtalk.httpclientapi.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class User {
    private Integer code;
    private String name;
    private String job;
    private Date creationDate;
}
