package com.bolingcavalry.jdk8mavenspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bolingcavalry.jdk8mavenspringboot.entity.Customer;
import com.bolingcavalry.jdk8mavenspringboot.mapper.CustomerMapper;
import com.bolingcavalry.jdk8mavenspringboot.service.ICustomerService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-12-05
 */
@Service
@Transactional
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
