package com.jiangfengliu.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lhstack
 * @date 2021/8/22
 * @class PropertySourceUtils
 * @since 1.8
 */
public class PropertySourceUtils {

    public static Map<String, Object> parseYaml(InputStream in) {
        Yaml yaml = new Yaml();
        Map<String, Object> map = new HashMap<>();
        initSourceToMap("", yaml.loadAs(in, JSONObject.class), map);
        return map;
    }

    /**
     * 将数据扁平化
     */
    private static void initSourceToMap(String parentKey, JSONObject jsonObject, Map<String, Object> map) {
        jsonObject.forEach((k, v) -> {
            if (v instanceof Map<?, ?>) {
                if (parentKey == null || parentKey.isEmpty()) {
                    initSourceToMap(k, jsonObject.getJSONObject(k), map);
                } else {
                    initSourceToMap(parentKey + "." + k, jsonObject.getJSONObject(k), map);
                }
            } else {
                if (parentKey == null || parentKey.isEmpty()) {
                    map.put(k, v);
                } else {
                    map.put(parentKey + "." + k, v);
                }
            }
        });
    }

    public static Map<String, Object> parseJson(InputStream in) {
        Map<String, Object> map = new HashMap<>();
        try {
            byte[] bytes = IOUtils.toByteArray(in);
            initSourceToMap("", JSONObject.parseObject(new String(bytes, StandardCharsets.UTF_8)), map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}

