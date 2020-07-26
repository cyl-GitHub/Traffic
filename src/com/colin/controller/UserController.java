package com.colin.controller;

import com.colin.bean.User;
import com.colin.service.TitleService;
import com.colin.service.UserService;
import com.colin.util.MD5;
import com.colin.util.ParamCheck;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TitleService titleService;

    @RequestMapping(value = "register")
    public String register() {
        return "user/register";
    }

    //  注册
    @RequestMapping(value = "doRegister")
    @ResponseBody
    public Map<String, Object> doRegister(@RequestBody User user, HttpServletRequest request) {

        String idCard = "^[1-9]\\d{5}(18|19|2([0-9]))\\d{2}(0[0-9]|10|11|12)([0-2][1-9]|30|31)\\d{3}[0-9Xx]$";
        Boolean b = ParamCheck.ParamCheck(user.getId(), user.getName(), user.getPassword(), user.getTelephone());
        String telephone = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
        String code = user.getCode();
        Map<String, Object> map = new HashMap<>();

        if (b) {
            boolean matches = user.getId().matches(idCard);
            boolean matches1 = user.getTelephone().matches(telephone);

            if (!matches) {
                map.put("result", "身份证号格式错误");
                return map;
            }

            if (!matches1) {
                map.put("result", "手机号格式错误");
                return map;
            }


            String sessionCode = request.getSession().getAttribute("code").toString();
            if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode) && code.equalsIgnoreCase(sessionCode)) {

                // String stringMD5 = MD5.stringMD5(user.getPassword());
                User userLogin = userService.selectUser(user);
                if (userLogin != null) {
                    map.put("result", "用户已存在");
                    return map;
                } else {
                    user.setPassword(MD5.stringMD5(user.getPassword()));
                    userService.insertUser(user);
                    map.put("result", "success");
                    return map;
                }

            } else {
                map.put("result", "验证码错误");
                return map;
            }

        } else {
            map.put("result", "信息不可为空");
            return map;
        }
    }

    @RequestMapping("login")
    public String login(HttpSession session) {
        //清除session缓存信息
        session.invalidate();
        return "user/login";
    }

    //  登录
    @RequestMapping("/doLogin")
    @ResponseBody
    public Map doLogin(@RequestBody User user, HttpSession session, HttpServletRequest request) {

        String idCard = "^[1-9]\\d{5}(18|19|2([0-9]))\\d{2}(0[0-9]|10|11|12)([0-2][1-9]|30|31)\\d{3}[0-9Xx]$";
        Boolean b = ParamCheck.ParamCheck(user.getId(), user.getName(), user.getPassword());

        String code = user.getCode();

        Map<String, Object> map = new HashMap<>();

        if (b) {
            boolean matches = user.getId().matches(idCard);
            if (matches) {
                //String code = request.getParameter("code");
                // 验证验证码
                String sessionCode = request.getSession().getAttribute("code").toString();
                //String sessionCode = code;
                if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode) && code.equalsIgnoreCase(sessionCode)) {

                    String stringMD5 = MD5.stringMD5(user.getPassword());
                    User userLogin = userService.selectUser(user);
                    if (userLogin != null && userLogin.getPassword().equals(stringMD5)) {
                        session.setAttribute("userLogin", userLogin);

                        map.put("result", "success");
                        return map;
                    } else {
                        map.put("result", "用户信息错误");
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

    @RequestMapping(value = "changePasssword1")
    public String changePassword1() {
        return "user/changePassword";
    }

    //修改密码
    @RequestMapping(value = "changePassword")
    @ResponseBody
    public Map changePassword(@RequestParam(value = "password", required = false) String password,
                              @RequestParam(value = "newPassword", required = false) String newPassword, HttpSession session) {
        User userLogin = (User) session.getAttribute("userLogin");
        String stringMD5 = MD5.stringMD5(password);
        Map<String, String> map = new HashMap<>();
        if (userLogin.getPassword().equals(stringMD5)) {
            map.put("result", "success");
            userLogin.setPassword(MD5.stringMD5(newPassword));
            userService.changePassword(userLogin);
            session.setAttribute("userLogin", userLogin);
        } else {
            map.put("result", "原密码错误");
        }
        return map;
    }

    @RequestMapping(value = "replaceAvatar")
    public String replaceAvatar() {
        return "/user/replaceAvatar";
    }

    @RequestMapping(value = "doReplaceAvatar")
    @ResponseBody
    public Map doReplaceAvatar(@RequestParam(value = "file", required = false) MultipartFile file,
                               HttpSession session) throws IOException {
        User userLogin = (User) session.getAttribute("userLogin");
        Map map = new HashMap();
        String absolutePath = null;
        if (file != null && !file.isEmpty()) {
            String str = file.getOriginalFilename();
            String str1 = str.substring(str.lastIndexOf(".") + 1);
            File file1 = new File("D:/学习/编译器/文件/Traffic Regulation Examination System_1/web/avatar", userLogin.getId() + "." + str1);
            FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
            String name = file1.getName();
            absolutePath = "/avatar/" + name;
            userLogin.setAvatar(absolutePath);
            userService.replaceAvatar(userLogin);
            map.put("result", "成功");
        } else {
            map.put("result", "未选择文件");
        }
        return map;
    }

    //总页面
    @RequestMapping(value = "userTotalPage")
    public String userTotalPage() {
        return "user/userTotalPage";
    }

    //导航栏
    @RequestMapping(value = "userNavigation")
    public String userNavigation() {
        return "user/userNavigation";
    }

    //用户  我的信息
    @RequestMapping(value = "myInformation")
    public String myInformation(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userLogin");

        DecimalFormat decimalFormat = new DecimalFormat("0.0");//这里有几个0就保留几位，如果小数不足位,会以0补足.

//科四
        Integer titleCarFourthCount = titleService.selectCarFourthCount();
        Integer userCar4RightCount = titleService.selectUserTitleCount(user.getId(), 1, "科目四", "小车");
        Integer userCar4WrongCount = titleService.selectUserTitleCount(user.getId(), 0, "科目四", "小车");
        Integer weizuo4 = titleCarFourthCount - userCar4RightCount - userCar4WrongCount;
        Integer score4 = userService.selectBestScore(user.getId(), "科目四", "小车");
        if (score4 == null) {
            score4 = 0;
        }

        String rightRate4;
        String wrongRate4;
        String weizuoRate4;
        if (titleCarFourthCount == 0) {
            rightRate4 = "0.0";
            wrongRate4 = "0.0";
            weizuoRate4 = "0.0";
        } else {
            rightRate4 = decimalFormat.format((float) userCar4RightCount / titleCarFourthCount * 100);
            wrongRate4 = decimalFormat.format((float) userCar4WrongCount / titleCarFourthCount * 100);
            weizuoRate4 = decimalFormat.format((float) weizuo4 / titleCarFourthCount * 100);
        }


//科一
        Integer titleCarFirstCount = titleService.selectCarFirstCount();
        Integer userCar1RightCount = titleService.selectUserTitleCount(user.getId(), 1, "科目一", "小车");
        Integer userCar1WrongCount = titleService.selectUserTitleCount(user.getId(), 0, "科目一", "小车");
        Integer weizuo1 = titleCarFirstCount - userCar1RightCount - userCar1WrongCount;

        Integer score1 = userService.selectBestScore(user.getId(), "科目一", "小车");
        if (score1 == null) {
            score1 = 0;
        }

        String rightRate1;
        String wrongRate1;
        String weizuoRate1;
        if (titleCarFirstCount == 0) {
            rightRate1 = "0.0";
            wrongRate1 = "0.0";
            weizuoRate1 = "0.0";
        } else {
            rightRate1 = decimalFormat.format((float) userCar1RightCount / titleCarFirstCount * 100);
            wrongRate1 = decimalFormat.format((float) userCar1WrongCount / titleCarFirstCount * 100);
            weizuoRate1 = decimalFormat.format((float) weizuo1 / titleCarFirstCount * 100);
        }

        //科四做题详情
        model.addAttribute("userCar4RightCount", userCar4RightCount);
        model.addAttribute("userCar4WrongCount", userCar4WrongCount);
        model.addAttribute("titleCarFourthCount", titleCarFourthCount);
        model.addAttribute("rightRate4", rightRate4);
        model.addAttribute("wrongRate4", wrongRate4);
        model.addAttribute("weizuo4", weizuo4);
        model.addAttribute("weizuoRate4", weizuoRate4);
        model.addAttribute("score4", score4);

        //科一做题详情
        model.addAttribute("userCar1RightCount", userCar1RightCount);
        model.addAttribute("userCar1WrongCount", userCar1WrongCount);
        model.addAttribute("titleCarFirstCount", titleCarFirstCount);
        model.addAttribute("rightRate1", rightRate1);
        model.addAttribute("wrongRate1", wrongRate1);
        model.addAttribute("weizuo1", weizuo1);
        model.addAttribute("weizuoRate1", weizuoRate1);
        model.addAttribute("score1", score1);
        model.addAttribute("user", user);

        Map map = new HashMap();
        map.put("name", "正确");
        map.put("value", userCar1RightCount);


        return "user/myInformation";
    }

    @RequestMapping(value = "testUser")
    public String test(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userLogin");
        model.addAttribute("user", user);
        return "testUser";
    }

}
