package com.huxl.seralization.httpRPC;

import java.util.Map;

/**
 * @author huxl
 * @createDate 2017/10/30 16:56
 */
public interface BaseService {
    Object execute(Map<String,Object> args);
}
