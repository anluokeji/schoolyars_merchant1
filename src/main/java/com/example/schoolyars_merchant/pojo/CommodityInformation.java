package com.example.schoolyars_merchant.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * 实体类
 * @author zf
 *
 */

@TableName(value = "commodity_information")
public class CommodityInformation {
    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;//商品主键

    @TableField("inventory")
    private String inventory;//商品库存

    @TableField("commodity_price")
    private BigDecimal commodityPrice;//商品价格

    @TableField("commodity_introduce")
    private String commodityIntroduce;//商品介绍

    @TableField("commodity_name")
    private String commodityName;//商品名称

    @TableField("commodity_picture")
    private String commodityPicture;//商品图片

    @TableField("commodity_status")
    private Boolean commodityStatus;//商品状态

    @TableField("merchant_id")
    private Integer merchantId;//商家id

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityIntroduce() {
        return commodityIntroduce;
    }

    public void setCommodityIntroduce(String commodityIntroduce) {
        this.commodityIntroduce = commodityIntroduce;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture;
    }

    public Boolean getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Boolean commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;

    }
}
