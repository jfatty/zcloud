package com.jfatty.zcloud.hospital.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 描述 动态数据源
 *
 * @author jfatty on 2019/12/10
 * @email jfatty@163.com
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

}
