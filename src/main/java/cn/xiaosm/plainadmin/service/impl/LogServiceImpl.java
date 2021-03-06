/**
 * Copyright: 2019-2020，小树苗(www.xiaosm.cn)
 * FileName: OperatorServiceImpl
 * Author:   Young
 * Date:     2020/6/16 10:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * Young         修改时间           版本号             描述
 */
package cn.xiaosm.plainadmin.service.impl;

import cn.xiaosm.plainadmin.entity.Log;
import cn.xiaosm.plainadmin.entity.ResponseBody;
import cn.xiaosm.plainadmin.mapper.LogMapper;
import cn.xiaosm.plainadmin.service.LogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author Young
 * @create 2020/6/16
 * @since 1.0.0
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LogMapper logMapper;

    @Override
    public ResponseBody getById(Integer id) {
        return null;
    }

    @Override
    public boolean addEntity(Log log) {
        log.setCreateTime(new Date());
        this.addEntityAsync(log);
        logger.debug("记录日志=>{}", log.getTitle());
        return true;
    }

    @Override
    public boolean removeEntity(Log log) {
        return false;
    }

    @Override
    public boolean modifyEntity(Log log) {
        return false;
    }

    @Async
    public void addEntityAsync(Log log) {
        // 查询ip地址属于哪
        // http://ip-api.com/json/114.114.114.114?lang=zh-CN
        logMapper.insert(log);
    }

    @Override
    public Page<Log> listOfPage(Page<Log> page, QueryWrapper<Log> queryWrapper) {
        return this.page(page, queryWrapper);
    }
}