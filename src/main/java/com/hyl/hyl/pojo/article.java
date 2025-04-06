package com.hyl.hyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class article {
    private String date;
    private Integer id;
    private String articleName;
    private String articleContent;
    private String articleGroup ;
    private String articleAuthor;
}
