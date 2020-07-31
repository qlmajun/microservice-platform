package com.warrior.central.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.warrior.central.common.model.PageResult;

import java.util.List;
import java.util.Map;

/**
 * mybatis-plus 代码自动生成接口声明
 */
public interface SysGeneratorService extends IService {

    PageResult queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

    byte[] generatorCode(String[] tableNames);
}
