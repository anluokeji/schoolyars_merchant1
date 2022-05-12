package com.example.receiving_address.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.JsonResult;
import com.example.receiving_address.pojo.ReceivingAddress;

import java.util.List;

public interface ReAddressService extends IService<ReceivingAddress> {


    JsonResult deleteOne(int takeId);//通过id删除收货地址信息

    JsonResult insertOne(ReceivingAddress receivingAddress);//新增收货地址信息

    JsonResult updateOne(ReceivingAddress receivingAddress);//更新收货地址信息

    List<ReceivingAddress> select();//查询收货信息

}
