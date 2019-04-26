package cn.xingyu.domain.entity;

import lombok.Data;

import java.util.List;


@Data
public class PermissionEVO {
  private Long id;
  private String name;
  private String type;
  private String url;
  private String percode;
  private Long parentid;
  private String parentids;
  private Long sort;
  private Boolean available;
  private List<PermissionEVO> children;


}
