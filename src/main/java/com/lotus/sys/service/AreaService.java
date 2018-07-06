package com.lotus.sys.service;

import java.util.List;
import java.util.Map;

public interface AreaService {

    public List<Map<String,Object>> getChinaMap();

    public List<Map<String,Object>> getProvincesJDBC();

}
