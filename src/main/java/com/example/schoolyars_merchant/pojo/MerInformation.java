package com.example.schoolyars_merchant.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

/**
 *实体类
 * @author  zf
 *
 */

@TableName(value = "merchant_information")
public class MerInformation implements Serializable {

    @TableId(value = "merchant_id", type = IdType.AUTO)//主键自增
    private Integer merchantId;//主键

    @TableField("merchant_name")
    private String merchantName;//商家名

    @TableField("merchant_address")
    private String merchantAddress;//商家地址

    @TableField("business_license")
    private String businessLicense;//营业执照

    @TableField("contacts")
    private String contacts;//联系人

    @TableField("contact_number")
    private String contactNumber;//联系电话

    @TableField("pavement_photos")
    private String cavementPhotos;//铺面照片

    @TableField("commodity_id")
    private int commodityId;//商品外键

    @TableField(exist = false)
    private List<CommodityInformation> commodityInformations;



    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCavementPhotos() {
        return cavementPhotos;
    }

    public void setCavementPhotos(String cavementPhotos) {
        this.cavementPhotos = cavementPhotos;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public List<CommodityInformation> getCommodityInformations() {
        return commodityInformations;
    }

    public void setCommodityInformations(List<CommodityInformation> commodityInformations) {
        this.commodityInformations = commodityInformations;
    }
}
