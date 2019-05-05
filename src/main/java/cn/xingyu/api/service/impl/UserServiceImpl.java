package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User>
        implements UserService {

    @Override
    public Long insert(User user) {
        user.setCreateDate(new Date());
        return super.insert(user);
    }


}
