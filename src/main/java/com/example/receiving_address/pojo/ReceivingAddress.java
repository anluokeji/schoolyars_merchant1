package com.example.receiving_address.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @author zf
 *
 */
@TableName(value = "receiving_address")
public class ReceivingAddress {
    @TableId(value = "take_id", type = IdType.AUTO)
    private Integer takeId;//主键

    @TableField(value = "contact_name")
    private String contactName;//联系人

    @TableField("contact_phone")
    private String contactPhone;//联系电话

    @TableField("address")
    private String address;//联系地址

    public Integer getTakeId() {
        return takeId;
    }

    public void setTakeId(Integer takeId) {
        this.takeId = takeId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ReceivingAddress{" +
                "takeId=" + takeId +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public ReceivingAddress(Integer takeId, String contactName, String contactPhone, String address) {
        this.takeId = takeId;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.address = address;
    }
}
