package com.huxl.rpc.seralization.httpRPC;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huxl
 * @createDate 2017/10/30 17:02
 */
public class ServiceProvider extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        Map<String,Object> services = new HashMap<>();
        BaseService sayHelloService = new SayHelloService();
        services.put("com.huxl.seralization.httpRPC.SayHelloService",sayHelloService);
        //基本参数
        String serviceName = req.getParameter("service");
        String format = req.getParameter("format");

        Map parameters = req.getParameterMap();
        BaseService service = (BaseService) services.get(serviceName);
        Object result = service.execute(parameters);

        //生成json结果集
        JsonResult jsonResult = new JsonResult();
        jsonResult.setResult(result);
        jsonResult.setMessage("success");
        jsonResult.setResultCode(200);

        String json = JSON.toJSONString(jsonResult).toString();
        resp.getWriter().write(json);
        }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
}
