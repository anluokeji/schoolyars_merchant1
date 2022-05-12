package com.example.schoolyars_merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.JsonResult;
import com.example.schoolyars_merchant.dao.MerInformationDao;
import com.example.schoolyars_merchant.pojo.CommodityInformation;
import com.example.schoolyars_merchant.pojo.MerInformation;
import com.example.schoolyars_merchant.service.CommodityInformationService;
import com.example.schoolyars_merchant.service.MerInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zf
 * 商家信息逻辑实现
 */

@Service
public class MerInformationServiceImpl extends ServiceImpl<MerInformationDao, MerInformation> implements MerInformationService {

    @Autowired
    private MerInformationDao merInformationDao;

    @Autowired
    private CommodityInformationService commodityInformationService;

    JsonResult objectJsonResult = new JsonResult();

    //删除商家信息
    @Override
    public JsonResult deleteOne(int MerchantId) {
        Integer integer = merInformationDao.deleteById(MerchantId);
        if (integer.equals(1)) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            return objectJsonResult;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return objectJsonResult;
        }

    }

    //新增商家信息
    @Override
    public JsonResult insertOne(MerInformation merInformation) {


        Integer integer = merInformationDao.insert(merInformation);
        if (integer != 0) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            return objectJsonResult;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return objectJsonResult;
        }
    }

    //修改商家信息
    @Override
    public JsonResult updateOne(MerInformation merInformation) {
        int i = merInformationDao.updateById(merInformation);

//        Integer integer = merInformationDao.update(merInformation);
        if (i != 0) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            return objectJsonResult;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            return objectJsonResult;
        }
    }

    //分页查询商家及商家信息下面的商品信息
    @Override
    public IPage<MerInformation> pageMerInfo(Integer current, Integer size, MerInformation merInformation) {
        QueryWrapper<MerInformation> wrapper = new QueryWrapper<>();
        if (null != merInformation) {
            wrapper.like(null != merInformation, "merchant_name", merInformation.getMerchantName());
        }
        Page<MerInformation> objectPage = new Page<>(current, size);
        IPage<MerInformation> rspage = this.page(objectPage, wrapper);
        if (rspage.getSize() != 0) {
            for (MerInformation record : rspage.getRecords()) {
                List<CommodityInformation> commodityInformations = commodityInformationService.listByMerchantId(record.getMerchantId());
                record.setCommodityInformations(commodityInformations);
            }

        }
        return rspage;
    }
}

