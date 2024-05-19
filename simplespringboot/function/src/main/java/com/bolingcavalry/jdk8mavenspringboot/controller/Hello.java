package com.bolingcavalry.jdk8mavenspringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bolingcavalry.jdk8mavenspringboot.Vo.SalesVo;
import com.bolingcavalry.jdk8mavenspringboot.common.DataGridView;
import com.bolingcavalry.jdk8mavenspringboot.entity.Customer;
import com.bolingcavalry.jdk8mavenspringboot.entity.Goods;
import com.bolingcavalry.jdk8mavenspringboot.entity.Sales;
import com.bolingcavalry.jdk8mavenspringboot.service.ICustomerService;
import com.bolingcavalry.jdk8mavenspringboot.service.IGoodsService;
import com.bolingcavalry.jdk8mavenspringboot.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Date;
import java.util.List;

/**
 * @Description: 来自模板的demo
 * @author: willzhao E-mail: zq2599@gmail.com
 * @date: 2021/3/7 15:24
 */
@RestController
public class Hello {
    @Autowired
    private ISalesService salesService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IGoodsService goodsService;

   /* @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello world, " + new Date();
    }*/
   @RequestMapping("loadAllSales")
   public DataGridView loadAllSales(SalesVo salesVo){
       IPage<Sales> page = (IPage<Sales>) new Page(salesVo.getPage(),salesVo.getLimit());
       QueryWrapper<Sales> queryWrapper = new QueryWrapper<Sales>();
       //根据客户进行模糊查询
       queryWrapper.eq(salesVo.getCustomerid()!=null&&salesVo.getCustomerid()!=0,"customerid",salesVo.getCustomerid());
       //根据商品模糊查询
       queryWrapper.eq(salesVo.getGoodsid()!=null&&salesVo.getGoodsid()!=0,"goodsid",salesVo.getGoodsid());
       //根据时间进行模糊查询
       queryWrapper.ge(salesVo.getStartTime()!=null,"salestime",salesVo.getStartTime());
       queryWrapper.le(salesVo.getEndTime()!=null,"salestime",salesVo.getEndTime());
       IPage<Sales> page1 = salesService.page(page, queryWrapper);
       List<Sales> records = page1.getRecords();
       for (Sales sales : records) {
           //设置客户姓名
           Customer customer = customerService.getById(sales.getCustomerid());
           if(null!=customer){
               sales.setCustomername(customer.getCustomername());
           }
           //设置商品名称
           Goods goods = goodsService.getById(sales.getGoodsid());
           if (null!=goods){
               //设置商品名称
               sales.setGoodsname(goods.getGoodsname());
               //设置商品规格
               sales.setSize(goods.getSize());
           }
       }
       return new DataGridView(page1.getTotal(),page1.getRecords());
   }
}
