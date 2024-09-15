package com.incubationplatform.service;

import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Sort;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcf
 * @since 2019-06-26
 */
public interface ISortService extends IService<Sort> {
    public ServerResponse toTop(String classification, String projectId);

    public ServerResponse addSort(Sort sort);

    public ServerResponse delSort(String classification,String projectId);

    public ServerResponse getSorts(String classification);
}
