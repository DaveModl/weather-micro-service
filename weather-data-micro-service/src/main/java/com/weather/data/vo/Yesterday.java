package com.weather.data.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Yesterday implements Serializable {
    private static final long serialVersionUID = 6868472631363401060L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
