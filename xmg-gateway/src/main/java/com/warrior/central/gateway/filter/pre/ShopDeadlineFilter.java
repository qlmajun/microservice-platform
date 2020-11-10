package com.warrior.central.gateway.filter.pre;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 门店有效期处理过滤器
 * @author mj
 * @date 2020/11/10
 */
@Component
public class ShopDeadlineFilter extends ZuulFilter {

  @Value("${shop.deadline.filter.open}")
  private boolean openFilter;

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return FORM_BODY_WRAPPER_FILTER_ORDER - 2;
  }

  @Override
  public boolean shouldFilter() {
    return openFilter;
  }

  @Override
  public Object run() throws ZuulException {
    return null;
  }
}
