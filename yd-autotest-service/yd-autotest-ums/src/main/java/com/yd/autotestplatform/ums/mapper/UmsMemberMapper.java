package com.yd.autotestplatform.ums.mapper;

import com.yd.autotestplatform.ums.entity.UmsMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author yangdang
 * @since 2021-06-21
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {
    @Select("select password from ums_member where username = #{name}")
    UmsMember selectByName(String name);
}
