package com.example.schoolyars_merchant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.JsonResult;
import com.example.schoolyars_merchant.dao.CommodityInformationDao;
import com.example.schoolyars_merchant.pojo.CommodityInformation;
import com.example.schoolyars_merchant.service.CommodityInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zf
 * <p>
 * 商品信息逻辑实现
 */

@Service
public class CommodityInformationServiceImpl extends ServiceImpl<CommodityInformationDao, CommodityInformation> implements CommodityInformationService {

    @Autowired
    private CommodityInformationDao commodityInformationDao;

    //删除商品信息
    @Override
    public JsonResult deleteOne(int commodityId) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        Integer byId = commodityInformationDao.deleteById(commodityId);
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

    //增加商品信息
    @Override
    public JsonResult insertOne(CommodityInformation commodityInformation) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        Integer insert = commodityInformationDao.insert(commodityInformation);
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

    //更新商品信息
    @Override
    public JsonResult updateOne(CommodityInformation commodityInformation) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        Integer update = commodityInformationDao.updateById(commodityInformation);
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

    //分页查询商品信息
    @Override
    public IPage<CommodityInformation> pageCommodityInfo(Integer current, Integer size, CommodityInformation commodityInformation) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        QueryWrapper<CommodityInformation> wrapper = new QueryWrapper<>();
        wrapper.like("commodity_name", commodityInformation.getCommodityName());
        Page<CommodityInformation> Page = new Page<>(current, size);
        IPage<CommodityInformation> rspage = this.page(Page, wrapper);
        if (rspage!=null){
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            objectJsonResult.setData(rspage);
            return rspage;
        }else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            objectJsonResult.setData(rspage);
            return rspage;
        }
    }

    /**
     * @param merchantId
     * @return
     * @author zf
     * 通过商家id获取商品信息
     */
    @Override
    public List<CommodityInformation> listByMerchantId(Integer merchantId) {
        QueryWrapper<CommodityInformation> wrapper = new QueryWrapper<>();
        wrapper.eq("merchant_id", merchantId);
        List<CommodityInformation> list = this.list(wrapper);
        return list;
    }


    /**
     * 通过id批量删除商品信息
     *
     * @param idsList
     * @return
     */

    @Override
    public boolean removeIds(List<Long> idsList) {
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        boolean b = this.removeIds(idsList);
        if (b == true) {
            objectJsonResult.setCode(200);
            objectJsonResult.setMessage("操作成功");
            objectJsonResult.setData(b);
            return b;
        } else {
            objectJsonResult.setCode(500);
            objectJsonResult.setMessage("操作失败");
            objectJsonResult.setData(b);
            return b;

        }
    }
}
