package com.incubationplatform.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcf
 * @since 2019-06-26
 */
public class Sort extends Model<Sort> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类的id
     */
    private String itemId;

    /**
     * 分类类别
     */
    private String classification;

    /**
     * 顺序 1-10 
     */
    private Integer order_num;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public static final String ID = "id";

    public static final String ITEM_ID = "item_id";

    public static final String CLASSIFICATION = "classification";

    public static final String ORDER = "order_num";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Sort{" +
        "id=" + id +
        ", itemId=" + itemId +
        ", classification=" + classification +
        ", order_num=" + order_num +
        "}";
    }
}
