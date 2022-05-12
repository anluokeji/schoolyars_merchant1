package com.example.schoolyars_merchant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolyars_merchant.pojo.MerInformation;

import java.util.List;

/**
 * @author zf
 * 商家信息
 */
public interface MerInformationDao extends BaseMapper<MerInformation> {

    //查询商家信息及商品信息
    List<MerInformation> selectByName(String MerchantName);
}
