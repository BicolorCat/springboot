package sample.version;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: biColor
 * \* Date: 17/5/9
 * \* Time: 下午4:48
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private final static String VERSION = "version";

    private float apiVersion;

    public ApiVersionCondition(float apiVersion){
        this.apiVersion = apiVersion;
    }

    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.getApiVersion());
    }

    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        float version = Float.valueOf(request.getParameter(VERSION));
        if(version >= this.apiVersion) // 如果请求的版本号大于配置版本号， 则满足
            return this;
        return null;
    }

    public int compareTo(ApiVersionCondition other, HttpServletRequest httpServletRequest) {
        // 优先匹配最新的版本号
        if (apiVersion == other.getApiVersion())
        {
            return 0;
        }
        return other.getApiVersion() - apiVersion > 0 ? 1 : -1;
    }

    public float getApiVersion(){
        return apiVersion;
    }
}