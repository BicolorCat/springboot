package sample.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/4/23
 * \* Time: 下午5:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DynamicDataSourceContextHolder  {


    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static List<String> dataSourceIds = new ArrayList<String>();


    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType(){
        return contextHolder.get();
    }

    public static void clearDataSourceType(){
        contextHolder.remove();
    }

    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }


}