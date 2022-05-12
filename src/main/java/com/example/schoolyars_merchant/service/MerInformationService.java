package com.example.schoolyars_merchant.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.JsonResult;
import com.example.schoolyars_merchant.pojo.MerInformation;

/**
 * @author zf
 * 商家
 */
public interface MerInformationService extends IService<MerInformation> {

    JsonResult deleteOne(int MerchantId);//通过id删除商家信息

    JsonResult insertOne(MerInformation merInformation);//增加商家信息

    JsonResult updateOne(MerInformation merInformation);//修改商家信息

    //查询商家信息及商品信息
    IPage<MerInformation> pageMerInfo(Integer current, Integer size, MerInformation merInformation);
}
