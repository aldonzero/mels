package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.User;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl extends BaseServiceImpl<User>
        implements UserService {

    @Value("${jasypt.encryptor.password}")
    private String salt;

    @Override
    public Long insert(User user) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(salt);
        user.setCreateDate(new Date());
        user.setPassword(textEncryptor.encrypt("123456"));
        return super.insert(user);
    }


}
