package com.lotus.sys.service.impl;

import com.lotus.sys.dao.jdbc.AreaDaoJDBC;
import com.lotus.sys.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired //自动装配
    private AreaDaoJDBC areaDaoJDBC;


    @Override
    public List<Map<String,Object>> getChinaMap(){
        List<Map<String,Object>> mapList = null;

        mapList = areaDaoJDBC.getChinaMapJdbc();

        return mapList;
    }

    @Override
    public List<Map<String, Object>> getProvincesJDBC() {
        List<Map<String,Object>> mapList = null;

        mapList = areaDaoJDBC.getProvincesJdbc();

        return mapList;
    }


}
