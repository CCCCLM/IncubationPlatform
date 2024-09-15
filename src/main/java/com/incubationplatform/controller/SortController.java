package com.incubationplatform.controller;


import com.incubationplatform.common.ServerResponse;
import com.incubationplatform.pojo.Sort;
import com.incubationplatform.service.ISortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcf
 * @since 2019-06-26
 */
@Controller
@RequestMapping("/sort")
public class SortController {


    @Autowired
    private ISortService iSortService;

    /**
     * 添加项目到分类排序中
     * @param classification
     * @param projectId
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse addSort(String classification,String projectId){
        Sort sort = new Sort();
        //todo 分类检查
        sort.setClassification(classification);
        sort.setItemId(projectId);
        return iSortService.addSort(sort);
    }

    @RequestMapping("/del")
    @ResponseBody
    public ServerResponse delSort(String classification,String projectId){
        return iSortService.delSort(classification, projectId);
    }

    @RequestMapping("/get")
    @ResponseBody
    public ServerResponse getSort(String classification){
        return iSortService.getSorts(classification);
    }
}

