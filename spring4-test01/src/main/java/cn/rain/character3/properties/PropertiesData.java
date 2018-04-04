package cn.rain.character3.properties;

import java.util.Properties;

/**
 * description: 演示为Properties属性注入值。
 * @author 任伟
 * @date 2018/4/4 16:32
 */
public class PropertiesData {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "PropertiesData{" +
                "properties=" + properties +
                '}';
    }
}
