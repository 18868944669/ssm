package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    /**
     * 根据ID查询会员
     *
     * @param id
     * @return
     */
    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
