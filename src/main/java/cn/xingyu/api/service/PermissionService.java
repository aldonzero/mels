package cn.xingyu.api.service;

import cn.xingyu.domain.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PermissionService extends BaseService<Permission> {

  List<String> listCode(Long userId);
 }

