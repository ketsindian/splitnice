package com.splitnice.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SplitResponse {

    public SplitResponse(boolean status,String message){
        this.message=message;
        this.status=status;
    }
    public SplitResponse(boolean status){
        this.status=status;
    }
    private boolean status;
    private String message;
}
