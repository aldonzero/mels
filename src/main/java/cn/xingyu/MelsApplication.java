package cn.xingyu;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.xingyu.infra.mapper")
@SpringBootApplication
public class MelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MelsApplication.class, args);
    }

}
