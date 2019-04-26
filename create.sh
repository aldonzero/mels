#!/usr/bin/env bash
pro_path=$(pwd)
echo ${pro_path}
java_path=${pro_path}"/src/main/java/"
file_name=$1

#创建文件
create_file(){
    file=$1
    if [ ! -f $file ];then
        echo "创建新${file}文件"
    else
         echo "删除原有文件,创建新${file}文件"
    rm -f ${file}
    touch ${file}
    fi
}


#创建controller文件
controller_path=${java_path}"cn/xingyu/api/controller/"
cd ${controller_path}
controller_file=$file_name"Controller.java"
create_file ${controller_file}
controller_content="package cn.xingyu.api.controller;\n
\n
import ch.qos.logback.classic.Logger;\n
import cn.xingyu.api.service.${file_name}Service;\n
import cn.xingyu.domain.entity.${file_name};\n
import org.slf4j.LoggerFactory;\n
import org.springframework.web.bind.annotation.RequestMapping;\n
import org.springframework.web.bind.annotation.RestController;\n
\n
@RestController\n
@RequestMapping(\"/${file_name,}\")\n
public class ${file_name}Controller extends BaseController<${file_name}> {\n
    \tprivate Logger logger = (Logger) LoggerFactory.getLogger(${file_name}Controller.class);\n
\n
    \tpublic ${file_name}Controller(${file_name}Service service) {\n
        \t\tsuper(service);\n
    \t}\n
}\n
";
echo -e ${controller_content}>> ${controller_file}


#创建mapper文件
mapper_path=${java_path}"cn/xingyu/infra/mapper/"
mapper_file=${file_name}Mapper.java
cd ${mapper_path}
mapper_file=${file_name}"Mapper.java"
create_file ${mapper_file}
mapper_content="package cn.xingyu.infra.mapper;\n
\n
import cn.xingyu.domain.entity.${file_name};\n
import tk.mybatis.mapper.common.Mapper;\n
\n
public interface ${file_name}Mapper extends Mapper<${file_name}> {\n
}\n
"
echo -e ${mapper_content}>>${mapper_file}

#创建service文件
service_path=${java_path}"cn/xingyu/api/service/"
cd ${service_path}
service_file=${file_name}"Service.java"
create_file ${service_file}
service_content="package cn.xingyu.api.service;\n
\n
import cn.xingyu.domain.entity.${file_name};\n
\n
public interface ${file_name}Service extends BaseService<${file_name}> {\n
}\n
"
echo -e ${service_content}>>${service_file}


#创建serviceimpl文件
serviceImpl_path=${java_path}"cn/xingyu/api/service/impl/"
cd ${serviceImpl_path}
serviceImpl_file=${file_name}"ServiceImpl.java"
create_file ${serviceImpl_file}
serviceImpl_content="package cn.xingyu.api.service.impl;\n
\n
import cn.xingyu.api.service.${file_name}Service;\n
import cn.xingyu.domain.entity.${file_name};\n
import org.springframework.stereotype.Service;\n
\n
@Service\n
public class ${file_name}ServiceImpl extends BaseServiceImpl<${file_name}>\n
        \timplements ${file_name}Service {
}\n
"
echo -e ${serviceImpl_content}>>${serviceImpl_file}



