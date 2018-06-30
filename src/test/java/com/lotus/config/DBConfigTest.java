package com.lotus.config;

import com.lotus.AppStratup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBConfigTest {

    @Autowired
    private MyDataSourceProperties  dataSourceProperties ;

    @Value("${custom.datasource.names}")
    private String[] names;

    @Test
    public void dbConfigTest(){

        Arrays.stream(dataSourceProperties.getNames()).forEach(System.out::println);
    }

    @Test
    public void namesTest(){
        Arrays.stream(names).forEach(System.out::println);
    }

}

