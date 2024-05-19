package com.bolingcavalry.jdk8mavenspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bolingcavalry.jdk8mavenspringboot.entity.Goods;
import com.bolingcavalry.jdk8mavenspringboot.mapper.GoodsMapper;
import com.bolingcavalry.jdk8mavenspringboot.service.IGoodsService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * InnoDB free: 9216 kB; (`providerid`) REFER `warehouse/bus_provider`(`id`) 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-12-06
 */
@Service
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {


}
