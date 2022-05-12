package com.example.receiving_address.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.JsonResult;
import com.example.receiving_address.dao.ReAddressDao;
import com.example.receiving_address.pojo.ReceivingAddress;
import com.example.receiving_address.service.ReAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReAddressServiceImpl extends ServiceImpl<ReAddressDao, ReceivingAddress> implements ReAddressService {
    @Autowired(required = true)
    private ReAddressDao reAddressDao;

    //删除收货地址信息
    @Override
    public JsonResult deleteOne(int takeId) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        Integer byId = reAddressDao.deleteById(takeId);
        if (0 != byId) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            return objectJsonResult;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return objectJsonResult;
        }

    }

    //新增收货地址信息
    @Override
    public JsonResult insertOne(ReceivingAddress receivingAddress) {

        JsonResult<Object> objectJsonResult = new JsonResult<>();
        Integer insert = reAddressDao.insert(receivingAddress);
        if (0 != insert) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            return objectJsonResult;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return objectJsonResult;
        }


    }

    //修改收货地址信息
    @Override
    public JsonResult updateOne(ReceivingAddress receivingAddress) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        Integer update = reAddressDao.updateById(receivingAddress);
        if (0 != update) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            return objectJsonResult;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return objectJsonResult;
        }

    }

    //查询收货信息
    @Override
    public List<ReceivingAddress> select() {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        List<ReceivingAddress> list = this.list();
        if (null != list) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            objectJsonResult.setData(list);
            return list;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return list;
        }

    }

}
