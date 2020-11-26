package pojo;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 *
 **/
public class WebUtils {
    public static <T> T copyParamToBean(Map map, T bean){
        try {
            BeanUtils.populate(bean,map);
            return bean;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }
    public static int parseInt(String str,int defaultValue){
        if (str==null){
            return defaultValue;
        }else {
            return Integer.parseInt(str);
        }
    }
    public static double parseDouble(String str,double defaultValue){
        if (str==null||str==""){
            return defaultValue;
        }else {
            return Double.parseDouble(str);
        }
    }
}
