package com.example.schoolyars_merchant.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.JsonResult;
import com.example.schoolyars_merchant.pojo.CommodityInformation;

import java.util.List;

/**
 * 商品
 *
 * @author zf
 */


public interface CommodityInformationService extends IService<CommodityInformation> {

    JsonResult deleteOne(int commodityId);//通过id删除商家信息

    JsonResult insertOne(CommodityInformation commodityInformation);//增加商家信息

    JsonResult updateOne(CommodityInformation commodityInformation);//修改商家信息

    //分页查询商品信息
    IPage<CommodityInformation> pageCommodityInfo(Integer current, Integer size, CommodityInformation commodityInformation);

    //通过商家id获取商品信息
    List<CommodityInformation> listByMerchantId(Integer merchantId);

    //通过id批量删除商品信息
    boolean removeIds(List<Long> idsList);

}
