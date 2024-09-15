package com.incubationplatform.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lcf
 * @since 2019-03-28
 */
public class File extends Model<File> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 原文件名
     */
    private String originalName;

    /**
     * 名字
     */
    private String name;

    /**
     * 文件功能分类
     */
    private String classification;

    /**
     * 文件路径
     */
    private String url;

    /**
     * 所属者
     */
    private String belongId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBelongId() {
        return belongId;
    }

    public void setBelongId(String belongId) {
        this.belongId = belongId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public static final String ID = "id";

    public static final String ORIGINAL_NAME = "original_name";

    public static final String NAME = "name";

    public static final String CLASSIFICATION = "classification";

    public static final String URL = "url";

    public static final String BELONG_ID = "belong_id";

    public static final String CREATE_TIME = "create_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "File{" +
        "id=" + id +
        ", originalName=" + originalName +
        ", name=" + name +
        ", classification=" + classification +
        ", url=" + url +
        ", belongId=" + belongId +
        ", createTime=" + createTime +
        "}";
    }
}
