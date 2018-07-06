package com.lotus.sys.controller;

import com.lotus.sys.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    @RequestMapping("/getChinaMap")
    public List<Map<String, Object>> getChinaMap(){

        logger.info("getChinaMap");

        return areaService.getChinaMap();
    }


    @RequestMapping("/getProvincesJDBC")
    public List<Map<String, Object>> getProvincesJDBC(){

        logger.info("getProvincesJDBC");

        return areaService.getProvincesJDBC();
    }








}
