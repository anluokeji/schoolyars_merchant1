package com.example.receiving_address.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.JsonResult;
import com.example.receiving_address.pojo.ReceivingAddress;
import com.example.receiving_address.service.ReAddressService;
import com.example.schoolyars_merchant.pojo.CommodityInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/readdress")
public class ReAddressController {
    @Autowired(required = true)
    private ReAddressService reAddressService;

    /**
     * 删除收货地址
     *
     * @param takeId
     * @return
     */

    @DeleteMapping("/delete/{takeId}")
    public JsonResult deleteById(@PathVariable("takeId") int takeId) {

        JsonResult jsonResult = reAddressService.deleteOne(takeId);
        return jsonResult;
    }

    /**
     * 新增收货地址
     *
     * @param receivingAddress
     * @return
     */

    @PostMapping("/insert")
    public JsonResult insert(@RequestBody ReceivingAddress receivingAddress) {
        return reAddressService.insertOne(receivingAddress);
    }


    /**
     * 更新收货地址
     *
     * @param receivingAddress
     * @return
     */

    @PutMapping("/update")
    public JsonResult update(@RequestBody ReceivingAddress receivingAddress) {
        return reAddressService.updateOne(receivingAddress);
    }

    //查询收货信息
    @PostMapping("/select")
    public JsonResult select() {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        objectJsonResult.setData(reAddressService.select());
        return objectJsonResult;

    }
}
