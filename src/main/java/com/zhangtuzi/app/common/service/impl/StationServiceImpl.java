package com.zhangtuzi.app.common.service.impl;

import com.zhangtuzi.app.common.entity.Station;
import com.zhangtuzi.app.common.mapper.StationMapper;
import com.zhangtuzi.app.common.service.IStationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站点信息表 服务实现类
 * </p>
 *
 * @author zhangtuzi
 * @since 2021-01-27
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements IStationService {

}
