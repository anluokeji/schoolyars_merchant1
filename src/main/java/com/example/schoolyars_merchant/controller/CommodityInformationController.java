package com.example.schoolyars_merchant.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.JsonResult;
import com.example.schoolyars_merchant.pojo.CommodityInformation;
import com.example.schoolyars_merchant.service.CommodityInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author zf
 * 控制层
 * 商品信息
 */
@RestController
@RequestMapping("/commdityinfo")
public class CommodityInformationController {

    @Autowired
    private CommodityInformationService commodityInformationService;


    /**
     * 通过id删除一条商品信息
     *
     * @param commodityId
     * @return
     */
    @DeleteMapping("/delete/{commodityId}")
    public JsonResult deleteById(@PathVariable("commodityId") int commodityId) {
        JsonResult jsonResult = commodityInformationService.deleteOne(commodityId);
        return jsonResult;
    }

    /**
     * 通过id批量删除
     *
     * @param commodityIds
     * @return
     */
    @DeleteMapping("/ids/{commodityIds}")
    public JsonResult deleteByIds(@PathVariable("commodityIds") Long commodityIds) {
        List<Long> idsList = Arrays.asList(commodityIds);
        boolean b = commodityInformationService.removeIds(idsList);
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        objectJsonResult.setData(b);
        return objectJsonResult;
    }


    /**
     * 新增商品信息
     *
     * @param commodityInformation
     * @return
     */
    @PostMapping("/insert")
    public JsonResult insert(@RequestBody CommodityInformation commodityInformation) {
        return commodityInformationService.insertOne(commodityInformation);
    }

    /**
     * 更新商品信息
     *
     * @param commodityInformation
     * @return
     */
    @PutMapping("/update")
    public JsonResult update(@RequestBody CommodityInformation commodityInformation) {
        return commodityInformationService.updateOne(commodityInformation);
    }

    /**
     * 分页查询商品信息
     *
     * @param current
     * @param size
     * @param commodityInformation
     * @return
     */
    @PostMapping("/page/{current}/{size}")
    public JsonResult pageCommodityInfo(@PathVariable("current") Integer current,
                                        @PathVariable("size") Integer size,
                                        @RequestBody(required = false) CommodityInformation commodityInformation) {
        IPage<CommodityInformation> commodityInformationIPage = commodityInformationService.pageCommodityInfo(current, size, commodityInformation);
        JsonResult<Object> objectJsonResult = new JsonResult<>();
        objectJsonResult.setData(commodityInformationIPage);
        return objectJsonResult;
    }

}
