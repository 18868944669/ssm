package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {
    /**
     * 保存日志
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     * 查询所有日志
     * @param page
     * @param size
     * @return
     */

    List<SysLog> findAll(Integer page, Integer size)throws Exception;
}
