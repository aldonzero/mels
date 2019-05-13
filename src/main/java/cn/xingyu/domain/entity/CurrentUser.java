package cn.xingyu.domain.entity;

import lombok.Data;

@Data
public class CurrentUser {
    private String name;
    private String avatar;
    private Long userid;
    private String email;
    private String phone;
    private String signature;
    private String title;
    private String group;
}
