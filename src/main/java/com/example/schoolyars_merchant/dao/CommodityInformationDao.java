package com.example.schoolyars_merchant.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.schoolyars_merchant.pojo.CommodityInformation;

import java.util.List;

/**
 * @author zf
 * 商品信息
 */

public interface CommodityInformationDao extends BaseMapper<CommodityInformation> {
List<CommodityInformation> selectByName(String commodityName);

}
