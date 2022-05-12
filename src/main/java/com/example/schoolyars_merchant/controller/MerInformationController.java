package com.example.schoolyars_merchant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.JsonResult;
import com.example.schoolyars_merchant.pojo.MerInformation;
import com.example.schoolyars_merchant.service.CommodityInformationService;
import com.example.schoolyars_merchant.service.MerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zf
 * 控制层
 * 商家信息
 */

@RestController
@RequestMapping("/merinformation")
public class MerInformationController {
    @Resource
    private MerInformationService merInformationService;
    @Autowired
    private CommodityInformationService commodityInformationService;


    /**
     * 删除商家信息
     *
     * @param MerchantId
     * @return
     */

    @DeleteMapping("/delete/{MerchantId}")
    public JsonResult deleteById(@PathVariable("MerchantId") int MerchantId) {

        JsonResult jsonResult = merInformationService.deleteOne(MerchantId);
        return jsonResult;
    }

    /**
     * 新增商家信息
     *
     * @param merInformation
     * @return
     */

    @PostMapping("/insert")
    public JsonResult insert(@RequestBody MerInformation merInformation) {

        return merInformationService.insertOne(merInformation);

    }


    /**
     * 更新商家信息
     *
     * @param merInformation
     * @return
     */

    @PutMapping("/update")
    public JsonResult update(@RequestBody MerInformation merInformation) {
        return merInformationService.updateOne(merInformation);
    }


    /**
     * 分页查询商家信息及商家商品信息
     *
     * @param current
     * @param size
     * @param merInformation
     * @return
     */
    @PostMapping("/pageMerInfo/{current}/{size}")
    public JsonResult pageMerInfo(@PathVariable("current") Integer current,
                                  @PathVariable("size") Integer size,
                                  @RequestBody(required = false) MerInformation merInformation) {
        IPage<MerInformation> merInformationIPage = merInformationService.pageMerInfo(current, size, merInformation);
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        objectJsonResult.setData(merInformationIPage);
        return objectJsonResult;
    }

}
