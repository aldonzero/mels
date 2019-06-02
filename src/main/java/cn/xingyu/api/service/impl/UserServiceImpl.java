package cn.xingyu.api.service.impl;

import cn.xingyu.api.service.UserService;
import cn.xingyu.domain.entity.Machinery;
import cn.xingyu.domain.entity.User;
import cn.xingyu.domain.entity.UserRole;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
        user.setPassword(textEncryptor.encrypt(user.getPassword()));
        return super.insert(user);
    }

    @Override
    public Example getExample(Example e, User user) {
        Example.Criteria criteria = e.createCriteria();
        if (user.getName() != null && user.getName().length() != 0){
            criteria.andLike("name","%"+user.getName()+"%");
        }
        if (user.getPhone() != null && user.getPhone().length() != 0){
            criteria.andLike("phone","%"+user.getPhone()+"%");
        }
        return super.getExample(e,user);
    }



}
