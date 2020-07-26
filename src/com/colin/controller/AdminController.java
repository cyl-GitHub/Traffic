package com.colin.controller;


import com.colin.bean.Admin;
import com.colin.service.AdminService;
import com.colin.util.MD5;
import com.colin.util.ParamCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    //总页面
    @RequestMapping(value = "/totalPage")
    public String totalPage() {
        return "admin/totalPage";
    }

    //导航栏
    @RequestMapping(value = "/navigation")
    public String navigation() {
        return "admin/navigation";
    }


    @RequestMapping(value = "/adminLogin")
    public String adminLogin(HttpSession session) {
        session.invalidate();
        return "admin/adminLogin";
    }

    //管理员登录
    @RequestMapping(value = "/adminDoLogin")
    @ResponseBody
    public Map adminDoLogin(@RequestBody Admin admin, HttpSession session, HttpServletRequest request) {

        String idCard = "^[1-9]\\d{5}(18|19|2([0-9]))\\d{2}(0[0-9]|10|11|12)([0-2][1-9]|30|31)\\d{3}[0-9Xx]$";
        Boolean b = ParamCheck.ParamCheck(admin.getId(), admin.getName(), admin.getPassword());

        String code = admin.getCode();

        Map<String, Object> map = new HashMap<>();


        if (b) {
            boolean matches = admin.getId().matches(idCard);
            if (matches) {

                String sessionCode = request.getSession().getAttribute("code").toString();

                if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode) && code.equalsIgnoreCase(sessionCode)) {
// TODO: 2019/12/19 MD5.stringMD5(admin.getPassword()); 
                    String stringMD5 = MD5.stringMD5(admin.getPassword());
                    Admin adminLogin = adminService.selectAdmin(admin);
                    if (adminLogin != null && adminLogin.getPassword().equals(stringMD5)) {
                        session.setAttribute("adminLogin", adminLogin);

                        map.put("result", "success");
                        return map;
                    } else {
                        map.put("result", "管理员信息错误");
                        return map;
                    }

                } else {
                    map.put("result", "验证码错误");
                    return map;
                }
            } else {
                map.put("result", "身份证号格式错误");
                return map;
            }
        } else {
            map.put("result", "信息不可为空");
            return map;
        }
    }

}
