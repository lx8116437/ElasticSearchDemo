package com.es.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class GoodsVo {

    private String id;
    private String title;
    private String content;
    private String name;
    private String author;
    private String last_version;
}
