package com.island.community.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class AuthorizedRequestFilter extends ZuulFilter {
    @Override
    public String filterType() { //返回过滤器类型
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() { //同种类型的过滤器执行顺序
        return 0; //数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() { //是否执行该过滤器
        return true;
    }

    @Override
    public Object run() throws ZuulException { //过滤器逻辑实现
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("--->>> AuthorizedRequestFilter " + request.getMethod() + ", " + request.getRequestURI().toString());

        //请求参数中带有token则通过，否则不进行路由
        String token = request.getParameter("token"); //获取请求参数
        if(StringUtils.isNotBlank(token)){
            context.setSendZuulResponse(true); //对请求进行路由
            context.setResponseStatusCode(200);
            context.set("isSuccess", true);
        }
        else{
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.setResponseBody("请求异常，未发现token");
            context.set("isSuccess", false);
        }
        return null;
    }
}
