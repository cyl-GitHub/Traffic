package com.colin.controller;

import com.colin.bean.Admin;
import com.colin.bean.Title;
import com.colin.bean.User;
import com.colin.service.TitleService;
import com.colin.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/title")
public class TitleController {
    @Autowired
    TitleService titleService;

    @Autowired
    UserService userService;

    //管理员查询所有试题
    @RequestMapping(value = "/title")
    public String title(@Param("pageNumber") Integer pageNumber, Model model, HttpSession session) {

        int pageNumber1 = 1;

        if (pageNumber != null)
            pageNumber1 = pageNumber;
        int pageCount = 3;
        int totalPage;
        Admin adminLogin = (Admin) session.getAttribute("adminLogin");
        Integer count = titleService.selectCount();

        if (count % pageCount == 0) {
            totalPage = count / pageCount;
        } else {
            totalPage = count / pageCount + 1;
        }

        if (pageNumber1 <= 0) {
            pageNumber1 = 1;
        } else if (pageNumber1 > totalPage) {
            pageNumber1 = totalPage;
        }

        if (pageNumber1 < 1) {
            pageNumber1 = 1;
        }
        if (totalPage < 1) {
            totalPage = 1;
        }

        List<Title> titles = titleService.selectAllTitle((pageNumber1 - 1) * pageCount, pageCount);
        model.addAttribute("pageNumber", pageNumber1);
        model.addAttribute("titles", titles);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("adminLogin", adminLogin.getId());
        return "admin/title2";

    }


    //管理员查询所有试题
    @RequestMapping(value = "/title1")
    public String title1(@Param("pageNumber") Integer pageNumber, Model model, HttpSession session) {

        int pageNumber1 = 1;

        if (pageNumber != null)
            pageNumber1 = pageNumber;
        int pageCount = 3;
        int totalPage;
        Admin adminLogin = (Admin) session.getAttribute("adminLogin");
        Integer count = titleService.selectCount();

        if (count % pageCount == 0) {
            totalPage = count / pageCount;
        } else {
            totalPage = count / pageCount + 1;
        }

        if (pageNumber1 <= 0) {
            pageNumber1 = 1;
        } else if (pageNumber1 > totalPage) {
            pageNumber1 = totalPage;
        }

        if (pageNumber1 < 1) {
            pageNumber1 = 1;
        }
        if (totalPage < 1) {
            totalPage = 1;
        }

        List<Title> titles = titleService.selectAllTitle((pageNumber1 - 1) * pageCount, pageCount);
        model.addAttribute("pageNumber", pageNumber1);
        model.addAttribute("titles", titles);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("adminLogin", adminLogin.getId());
        return "admin/title";

    }


    @RequestMapping(value = "selectTitle")
    public String selectTitle(@Param("pageNumber") Integer pageNumber, @Param("cla") String cla, Model model, HttpSession session) {

        if (cla.equals("全部")) {
            return "forward:/title/title";
        }

        int pageNumber1 = 1;
        if (pageNumber != null)
            pageNumber1 = pageNumber;
        int pageCount = 2;
        int totalPage;
        Admin adminLogin = (Admin) session.getAttribute("adminLogin");

        //查询 某一章节的 题目数量
        Integer count = titleService.selectClassCount("科目四", cla, "小车");

        if (count % pageCount == 0) {
            totalPage = count / pageCount;
        } else {
            totalPage = count / pageCount + 1;
        }

        if (pageNumber1 <= 0) {
            pageNumber1 = 1;
        } else if (pageNumber1 > totalPage) {
            pageNumber1 = totalPage;
        }

        if (pageNumber1 < 1) {
            pageNumber1 = 1;
        }
        if (totalPage < 1) {
            totalPage = 1;
        }
        List<Title> titles = titleService.selectClassTitle((pageNumber1 - 1) * pageCount, pageCount, cla);
        model.addAttribute("pageNumber", pageNumber1);
        model.addAttribute("titles", titles);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("adminLogin", adminLogin.getId());
        model.addAttribute("cla", cla);
        return "admin/title";

    }


    @RequestMapping(value = "selectTitle1")
    public String selectTitle1(@Param("pageNumber3") Integer pageNumber3, @Param("cla3") String cla3, Model model, HttpSession session) {

        if (cla3.equals("全部")) {
            return "forward:/title/title";
        }

        int pageNumber1 = 1;
        if (pageNumber3 != null)
            pageNumber1 = pageNumber3;
        int pageCount = 2;
        int totalPage;
        Admin adminLogin = (Admin) session.getAttribute("adminLogin");

        //查询 某一车型的 题目数量
        Integer count = titleService.selectClassCount1(cla3);

        if (count % pageCount == 0) {
            totalPage = count / pageCount;
        } else {
            totalPage = count / pageCount + 1;
        }

        if (pageNumber1 <= 0) {
            pageNumber1 = 1;
        } else if (pageNumber1 > totalPage) {
            pageNumber1 = totalPage;
        }

        if (pageNumber1 < 1) {
            pageNumber1 = 1;
        }
        if (totalPage < 1) {
            totalPage = 1;
        }
        List<Title> titles = titleService.selectClassTitle1((pageNumber1 - 1) * pageCount, pageCount, cla3);
        model.addAttribute("pageNumber3", pageNumber1);
        model.addAttribute("titles", titles);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("adminLogin", adminLogin.getId());
        model.addAttribute("cla3", cla3);
        return "admin/title";

    }


    @RequestMapping(value = "selectTitle2")
    public String selectTitle2(@Param("pageNumber3") Integer pageNumber3, Model model, HttpSession session, HttpServletRequest request) {
        String cla3 = null;
        String cla2 = null;
        String cla1 = null;
        cla3 = request.getParameter("cla3");
        cla2 = request.getParameter("cla2");
        cla1 = request.getParameter("cla1");

        if (cla3.equals("全部")) {
            return "forward:/title/title";
        }

        int pageNumber1 = 1;

        if (pageNumber3 != null)
            pageNumber1 = pageNumber3;

        int pageCount = 2;
        int totalPage;
        Admin adminLogin = (Admin) session.getAttribute("adminLogin");

        //查询 某一车型的 题目数量
        Integer count = titleService.selectClassCount2(cla3, cla1, cla2);


        if (count % pageCount == 0) {
            totalPage = count / pageCount;
        } else {
            totalPage = count / pageCount + 1;
        }

        if (pageNumber1 <= 0) {
            pageNumber1 = 1;
        } else if (pageNumber1 > totalPage) {
            pageNumber1 = totalPage;
        }

        if (pageNumber1 < 1) {
            pageNumber1 = 1;
        }
        if (totalPage < 1) {
            totalPage = 1;
        }
        List<Title> titles = titleService.selectClassTitle2((pageNumber1 - 1) * pageCount, pageCount, cla3, cla1, cla2);

        model.addAttribute("pageNumber3", pageNumber1);
        model.addAttribute("titles", titles);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("adminLogin", adminLogin.getId());
        model.addAttribute("cla3", cla3);
        model.addAttribute("cla1", cla1);
        model.addAttribute("cla2", cla2);
        return "admin/title2";

    }


    @RequestMapping(value = "selectClass3")
    @ResponseBody
    public Map selectClass3() {
        Map map = new HashMap();
        List<String> class3 = titleService.selectClass3();
        map.put("class3", class3);
        return map;
    }


    @RequestMapping(value = "selectClass1")
    @ResponseBody
    public Map selectClass1(@RequestParam("class3") String class3) {
        Map map = new HashMap();
        List<String> class1 = titleService.selectClass1(class3);
        map.put("class1", class1);
        return map;
    }


    @RequestMapping(value = "selectClass2")
    @ResponseBody
    public Map selectClass2(@RequestParam String class3, @RequestParam String class1) {
        Map map = new HashMap();
        List<String> class2 = titleService.selectClass2(class3, class1);
        map.put("class2", class2);
        return map;
    }


    @RequestMapping(value = "/addTitle")
    public String addTitle() {
        return "admin/addTitle";
    }

    //管理员添加试题
    @RequestMapping(value = "/doAddTitle")
    @ResponseBody
    public Map doAddTitle(@RequestParam(value = "file", required = false) MultipartFile file,
                          @RequestParam(value = "content", required = false) String content,
                          @RequestParam(value = "key1", required = false) String key1,
                          @RequestParam(value = "key2", required = false) String key2,
                          @RequestParam(value = "key3", required = false) String key3,
                          @RequestParam(value = "key4", required = false) String key4,
                          @RequestParam(value = "key", required = false) String key,
                          @RequestParam(value = "multiple", required = false) Integer multiple,
                          @RequestParam(value = "score", required = false) Integer score,
                          @RequestParam(value = "class1", required = false) String class1,
                          @RequestParam(value = "class2", required = false) String class2,
                          @RequestParam(value = "class3", required = false) String class3,
                          @RequestParam(value = "analysis", required = false) String analysis,
                          HttpSession session) throws IOException {

        Map<String, String> map = new HashMap<>();

        if ("".equals(content) || "".equals(key1) || "".equals(key2) || "".equals(key)
                || "".equals(multiple) || "".equals(score) || "".equals(class1) || "".equals(class2)) {
            map.put("result", "信息不可为空,请检查后重新提交!");
            return map;
        }

        if (multiple == 0 && key.length() > 1) {
            map.put("result", "此题为单选,不可选择多个答案");
            return map;
        } else if (multiple == 1 && key.length() < 2
        ) {
            map.put("result", "此题为多选,不可选择单个答案");
            return map;
        }


        Admin adminLogin = (Admin) session.getAttribute("adminLogin");
        Title title;
        title = new Title(content, key1, key2, key3, key4, key, multiple, score, class1, class2, class3, adminLogin.getId());

        String absolutePath = null;

        if (file != null && !file.isEmpty()) {
            File file1 = new File("D:/学习/编译器/文件/Traffic Regulation Examination System_1/web/picture", file.getOriginalFilename());
            //File file1 = new File("http://60.205.226.115:8080/picture", file.getOriginalFilename());

            FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
            String name = file1.getName();
            absolutePath = "/picture/" + name;
            title.setPicture(absolutePath);
        } else {
            title.setPicture(null);
        }

        titleService.insertTitle(title);

        map.put("result", "添加成功");
        return map;
    }


    //管理员删除题目
    @RequestMapping(value = "/deleteTitle")
    public String deleteTitle(int id, int pageNumber) {
        titleService.deleteTitle(id);
        titleService.deleteCollection(id);
        titleService.deleteAnswerrecord1(id);
        return "forward:/title/title?pageNumber=" + pageNumber + "";
    }


    @RequestMapping(value = "updateTitle")
    public String updateTitle(String id, Model model) {
        Title title = titleService.selectTitle(id);
        model.addAttribute("updateTitle", title);
        return "admin/updateTitle";
    }

    //管理员更新题目
    @RequestMapping(value = "/doUpdateTitle")
    @ResponseBody
    public Map doUpdateTitle(@RequestParam(value = "file", required = false) MultipartFile file,
                             @RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "content", required = false) String content,
                             @RequestParam(value = "key1", required = false) String key1,
                             @RequestParam(value = "key2", required = false) String key2,
                             @RequestParam(value = "key3", required = false) String key3,
                             @RequestParam(value = "key4", required = false) String key4,
                             @RequestParam(value = "key", required = false) String key,
                             @RequestParam(value = "multiple", required = false) Integer multiple,
                             @RequestParam(value = "score", required = false) Integer score,
                             @RequestParam(value = "class1", required = false) String class1,
                             @RequestParam(value = "class2", required = false) String class2,
                             @RequestParam(value = "class3", required = false) String class3,
                             @RequestParam(value = "analysis", required = false) String analysis
    ) throws IOException {

        Map<String, String> map = new HashMap<>();

        if ("".equals(content) || "".equals(key1) || "".equals(key2) || "".equals(key)
                || "".equals(multiple) || "".equals(score) || "".equals(class1) || "".equals(class2)) {
            map.put("result", "信息不可为空,请检查后重新提交!");
            return map;
        }

        if (multiple == 0 && key.length() > 1) {
            map.put("result", "此题为单选,不可选择多个答案");
            return map;
        } else if (multiple == 1 && key.length() < 2
        ) {
            map.put("result", "此题为多选,不可选择单个答案");
            return map;
        }

        Title title;
        title = new Title(id, content, key1, key2, key3, key4, key, multiple, score, class1, class2, class3, analysis);

        String absolutePath = null;

        if (file != null && !file.isEmpty()) {
            File file1 = new File("D:/学习/编译器/文件/Traffic Regulation Examination System_1/web/picture", file.getOriginalFilename());

            // File file1 = new File("/picture", file.getOriginalFilename());

            FileUtils.copyInputStreamToFile(file.getInputStream(), file1);
            String name = file1.getName();
            absolutePath = "/picture/" + name;
            title.setPicture(absolutePath);
        } else {
            title.setPicture(null);
        }

        titleService.updateTitle(title);

        map.put("result", "更新成功");
        return map;
    }


    //检查登录状态
    public void checkLogin(HttpSession session) {
        User userLogin = new User();

        userLogin = (User) session.getAttribute("userLogin");

        if (userLogin == null) {
            JOptionPane.showMessageDialog(null, "身份信息已过期,请返回到登录界面重新录入!", "提示", JOptionPane.ERROR_MESSAGE);
        }
    }


    //小车科一模拟测试分类
    @RequestMapping(value = "/mockTest")
    public String mockTest(HttpSession session) {
        checkLogin(session);
        return "car/first/mockTest";
    }

    //小车科四模拟测试分类
    @RequestMapping(value = "/mockTest1")
    public String mockTest1() {
        return "car/fourth/mockTest1";
    }


    // TODO: 2020/2/15  begin


    //科目一
    //小车科一顺序练习
    @RequestMapping("carFirstSx")
    public String carFirstSx(HttpSession session) {
        //查询小车科目一试题总数量
        Integer carTitlesCount = titleService.selectCarFirstCount();
        session.setAttribute("carTitlesCount", carTitlesCount);

        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息
        carTitles = titleService.selectTitlesBycla3cla1("小车", "科目一");
        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/first/sx";
    }

    @RequestMapping("carFirstSj")
    public String carFirstSj(HttpSession session) {
        //查询小车科目一试题总数量
        Integer carTitlesCount = titleService.selectCarFirstCount();
        session.setAttribute("carTitlesCount", carTitlesCount);

        List<Title> carTitles = new ArrayList<>();

        //随机获取所有题目
        carTitles = titleService.selectRandTitle("科目一", "小车", carTitlesCount);

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);
        return "/car/first/sj";
    }

    //小车科四收藏
    @RequestMapping("scCar1")
    public String scCar1(HttpSession session) {

        User userLogin = (User) session.getAttribute("userLogin");

        //查询小车科目一试题收藏总数量
        Integer carTitlesCount = titleService.selectCollectionCount(userLogin.getId(), "科目一", "小车");

        if (carTitlesCount == 0) {
            JOptionPane.showMessageDialog(null, "科目一暂无收藏!", "提示", JOptionPane.ERROR_MESSAGE);
            return "forward:/user/myInformation";
        }

        session.setAttribute("carTitlesCount", carTitlesCount);

        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息
        carTitles = titleService.selectScTitlesBycla3cla1(userLogin.getId(), "科目一", "小车");
        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/first/shoucang";

    }

    //小车科目四章节练习
    @RequestMapping(value = "carFirstZj")
    public String carFirstZj(HttpSession session) {
        //查询 某一章节的 题目数量
        Integer count1 = titleService.selectClassCount("科目一", "道路交通安全法律、法规和规章", "小车");
        Integer count2 = titleService.selectClassCount("科目一", "交通信号及其含义", "小车");
        Integer count3 = titleService.selectClassCount("科目一", "安全行车、文明驾驶知识", "小车");
        Integer count4 = titleService.selectClassCount("科目一", "机动车驾驶操作相关基础知识", "小车");


        session.setAttribute("count1", count1);
        session.setAttribute("count2", count2);
        session.setAttribute("count3", count3);
        session.setAttribute("count4", count4);

        return "/car/first/zj";
    }

    @RequestMapping(value = "carFirstZjSx")
    public String carFirstZjSx(HttpSession session, HttpServletRequest request) {
        String class2 = request.getParameter("class2");

        Integer carTitlesCount = titleService.selectClassCount("科目一", class2, "小车");
        session.setAttribute("carTitlesCount", carTitlesCount);


        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息
        carTitles = titleService.selectTitlesBycla123("科目一", class2, "小车");
        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/first/zj1";
    }

    @RequestMapping(value = "carFirstZjSj")
    public String carFirstZjSj(HttpSession session, HttpServletRequest request) {
        String class2 = request.getParameter("class2");

        Integer carTitlesCount = titleService.selectClassCount("科目一", class2, "小车");
        session.setAttribute("carTitlesCount", carTitlesCount);


        List<Title> carTitles = new ArrayList<>();

        //随机获取所有题目
        carTitles = titleService.selectRandTitleByCla123("科目一", class2, "小车");

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/first/zj1";
    }


    //小车科目一难点练习
    @RequestMapping(value = "carFirstNd")
    public String carFirstNd(HttpSession session) {
        //设置小车科目一难点试题总数量
        session.setAttribute("carTitlesCount", 10);

        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息、
        carTitles = titleService.selectNdTitlesBycla13("科目一", "小车", 10);

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/first/nd";
    }

    @RequestMapping("carFirstQz")
    public String carFirstQz(HttpSession session) {

        //设置小车科目一全真模拟试题总数量
        session.setAttribute("carTitlesCount", 100);

        List<Title> carTitles = new ArrayList<>();

        //随机抽取题目组成全真模拟
        carTitles = titleService.selectQzTitlesByclassm13(0, "科目一", "小车", 45);
        List<Title> carTitles1 = titleService.selectQzTitlesByclassm13(1, "科目一", "小车", 5);
        carTitles.addAll(carTitles1);

        for (Title t : carTitles
        ) {
            t.setScore1(0);
        }

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);


        return "/car/first/qz";
    }


    //科目四
    //小车科四顺序练习
    @RequestMapping("carFourthSx")
    public String carFourthSx(HttpSession session) {
        //查询小车科目四试题总数量
        Integer carTitlesCount = titleService.selectCarFourthCount();
        session.setAttribute("carTitlesCount", carTitlesCount);

        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息
        carTitles = titleService.selectTitlesBycla3cla1("小车", "科目四");
        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/fourth/sx";
    }

    @RequestMapping("carFourthSj")
    public String carFourthSj(HttpSession session) {
        //查询小车科目四试题总数量
        Integer carTitlesCount = titleService.selectCarFourthCount();
        session.setAttribute("carTitlesCount", carTitlesCount);

        List<Title> carTitles = new ArrayList<>();

        //随机获取所有题目
        carTitles = titleService.selectRandTitle("科目四", "小车", carTitlesCount);

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);
        return "/car/fourth/sj";
    }

    //小车科四收藏
    @RequestMapping("scCar4")
    public String scCar4(HttpSession session) {

        User userLogin = (User) session.getAttribute("userLogin");

        //查询小车科目四试题收藏总数量
        Integer carTitlesCount = titleService.selectCollectionCount(userLogin.getId(), "科目四", "小车");

        if (carTitlesCount == 0) {
            JOptionPane.showMessageDialog(null, "无收藏题目!", "提示", JOptionPane.ERROR_MESSAGE);
            return "forward:/user/myInformation";
        }

        session.setAttribute("carTitlesCount", carTitlesCount);

        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息
        carTitles = titleService.selectScTitlesBycla3cla1(userLogin.getId(), "科目四", "小车");
        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/fourth/shoucang";

    }

    //小车科目四章节练习
    @RequestMapping(value = "carFourthZj")
    public String carFourthZj(HttpSession session) {
        //查询 某一章节的 题目数量
        Integer count1 = titleService.selectClassCount("科目四", "道路交通安全法律、法规和规章", "小车");
        Integer count2 = titleService.selectClassCount("科目四", "交通信号及其含义", "小车");
        Integer count3 = titleService.selectClassCount("科目四", "安全行车、文明驾驶知识", "小车");
        Integer count4 = titleService.selectClassCount("科目四", "高速公路、山区道路、桥梁、隧道、夜间、恶劣气象和复杂条件下驾驶知识", "小车");
        Integer count5 = titleService.selectClassCount("科目四", "出现爆胎、转向失控、制动失灵等紧急情况时临危处置知识", "小车");
        Integer count6 = titleService.selectClassCount("科目四", "机动车总体构造和主要安全装置常识，日常检查和维护基本知识", "小车");
        Integer count7 = titleService.selectClassCount("科目四", "发生交通事故后的自救、急救等基本知识，以及常见危险化学品等知识", "小车");

        session.setAttribute("count1", count1);
        session.setAttribute("count2", count2);
        session.setAttribute("count3", count3);
        session.setAttribute("count4", count4);
        session.setAttribute("count5", count5);
        session.setAttribute("count6", count6);
        session.setAttribute("count7", count7);

        return "/car/fourth/zj";
    }

    @RequestMapping(value = "carFourthZjSx")
    public String carFourthZjSx(HttpSession session, HttpServletRequest request) {
        String class2 = request.getParameter("class2");

        Integer carTitlesCount = titleService.selectClassCount("科目四", class2, "小车");
        session.setAttribute("carTitlesCount", carTitlesCount);


        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息
        carTitles = titleService.selectTitlesBycla123("科目四", class2, "小车");
        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/fourth/zj1";
    }

    @RequestMapping(value = "carFourthZjSj")
    public String carFourthZjSj(HttpSession session, HttpServletRequest request) {
        String class2 = request.getParameter("class2");

        Integer carTitlesCount = titleService.selectClassCount("科目四", class2, "小车");
        session.setAttribute("carTitlesCount", carTitlesCount);


        List<Title> carTitles = new ArrayList<>();

        //随机获取所有题目
        carTitles = titleService.selectRandTitleByCla123("科目四", class2, "小车");

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/fourth/zj1";
    }


    //小车科目四难点练习
    @RequestMapping(value = "carFourthNd")
    public String carFourthNd(HttpSession session) {
        //查询小车科目四试题总数量
        session.setAttribute("carTitlesCount", 10);

        List<Title> carTitles = new ArrayList<>();
        //根据提供的信息查找所有题目信息、
        carTitles = titleService.selectNdTitlesBycla13("科目四", "小车", 10);

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);


        return "/car/fourth/nd";
    }

    @RequestMapping("carFourthQz")
    public String carFourthQz(HttpSession session) {


        //查询小车科目四试题总数量
        session.setAttribute("carTitlesCount", 50);

        List<Title> carTitles = new ArrayList<>();

        //随机抽取题目组成全真模拟
        carTitles = titleService.selectQzTitlesByclassm13(0, "科目四", "小车", 45);
        List<Title> carTitles1 = titleService.selectQzTitlesByclassm13(1, "科目四", "小车", 5);
        carTitles.addAll(carTitles1);

        for (Title t : carTitles
        ) {
            t.setScore1(0);
        }

        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);


        return "/car/fourth/qz";
    }

    @RequestMapping("carWrong")
    public String carWrong(HttpServletRequest request, HttpSession session) {
        String class1 = request.getParameter("class1");

        User userLogin = (User) session.getAttribute("userLogin");

        Integer carTitlesCount = titleService.selectWrongCount(userLogin.getId(), class1, "小车");
        session.setAttribute("carTitlesCount", carTitlesCount);

        if (carTitlesCount == 0) {
            JOptionPane.showMessageDialog(null, "科目一暂无收藏!", "提示", JOptionPane.ERROR_MESSAGE);
            return "forward:/user/myInformation";
        }

        List<Title> carTitles = new ArrayList<>();
        carTitles = titleService.selectWrongTitles(userLogin.getId(), class1, "小车");


        session.setAttribute("carTitles", carTitles);

        Integer rightCount = 0;
        Integer wrongCount = 0;
        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        return "/car/wrong";
    }


    //通用功能

    //查询当前总题数
    @RequestMapping("getCarTitlesCount")
    @ResponseBody
    public Map getCarTitlesCount(HttpSession session) {
        Integer carTitlesCount = (Integer) session.getAttribute("carTitlesCount");
        Map map = new HashMap();
        map.put("carTitlesCount", carTitlesCount);
        return map;
    }

    //获取某一道题
    @RequestMapping("getCarTitle")
    @ResponseBody
    public Map getCarTitle(@RequestParam int id1, HttpSession session) {
        List<Title> carTitles = (List<Title>) session.getAttribute("carTitles");

        Integer rightCount = (Integer) session.getAttribute("rightCount");
        Integer wrongCount = (Integer) session.getAttribute("wrongCount");

        User userLogin = (User) session.getAttribute("userLogin");

        Integer carTitlesCount = (Integer) session.getAttribute("carTitlesCount");

        //判断此道题是否被收藏
        Boolean col = titleService.collection(userLogin.getId(), carTitles.get(id1 - 1).getId());
        carTitles.get(id1 - 1).setCollection(col);

        Map map = new HashMap();

        session.setAttribute("rightCount", rightCount);
        session.setAttribute("wrongCount", wrongCount);

        session.setAttribute("carTitles", carTitles);
        map.put("carTitle", carTitles.get(id1 - 1));
        map.put("qid", id1);
        map.put("carTitlesCount", carTitlesCount);
        map.put("rightCount", rightCount);
        map.put("wrongCount", wrongCount);

        return map;
    }

    //获取上一道或下一道题
    @RequestMapping(value = "/changeCarTitle")
    @ResponseBody
    public Map changeCarTitle(@RequestParam int id, @RequestParam String ud, HttpSession session) {

        List<Title> carTitles = (List<Title>) session.getAttribute("carTitles");
        Map map = new HashMap<>();

        User userLogin = (User) session.getAttribute("userLogin");
        Integer rightCount = (Integer) session.getAttribute("rightCount");
        Integer wrongCount = (Integer) session.getAttribute("wrongCount");

        Integer carTitlesCount = (Integer) session.getAttribute("carTitlesCount");

        if (ud.equals("up")) {

            //判断上道题是否被收藏
            Boolean col = titleService.collection(userLogin.getId(), carTitles.get(id - 2).getId());
            carTitles.get(id - 2).setCollection(col);

            Title carTitle = carTitles.get(id - 2);

            map.put("carTitle", carTitle);
            map.put("qid", id - 1);
        } else if (ud.equals("down")) {

            //判断上道题是否被收藏
            Boolean col = titleService.collection(userLogin.getId(), carTitles.get(id).getId());
            carTitles.get(id).setCollection(col);

            Title carTitle = carTitles.get(id);
            map.put("carTitle", carTitle);
            map.put("qid", id + 1);
        }

        session.setAttribute("carTitles", carTitles);

        map.put("carTitlesCount", carTitlesCount);
        map.put("rightCount", rightCount);
        map.put("wrongCount", wrongCount);
        return map;
    }

    //检查某一道题
    @RequestMapping("checkCarTitle")
    @ResponseBody
    public Map checkCarTitle(@RequestParam int id, @RequestParam String key, HttpSession session) {
        List<Title> carTitles = (List<Title>) session.getAttribute("carTitles");
        Map map = new HashMap<>();
        User userLogin = (User) session.getAttribute("userLogin");

        Integer rightCount = (Integer) session.getAttribute("rightCount");
        Integer wrongCount = (Integer) session.getAttribute("wrongCount");


        Integer carTitlesCount = (Integer) session.getAttribute("carTitlesCount");

        if (carTitles.get(id - 1).getKeyNow() != null) {
            map.put("carTitle", carTitles.get(id - 1));
            map.put("result", "此题已作答");
        } else {

            if (key != null && key != "") {
                Title carTitles1 = carTitles.get(id - 1);
                carTitles1.setKeyNow(key);
                if (carTitles1.getKey().equals(key)) {
                    //此题得分为2
                    carTitles1.setScore1(2);
                    rightCount++;

                    // 记录做题信息
                    titleService.deleteAnswerrecord(userLogin.getId(), carTitles1.getId());
                    titleService.answerrecord(userLogin.getId(), carTitles1.getId(), 1);
                    titleService.answerCount(carTitles1.getId(), 1);
                    map.put("result", "答题正确");

                } else {
                    //此题得分为0
                    carTitles1.setScore1(0);
                    wrongCount++;
                    titleService.deleteAnswerrecord(userLogin.getId(), carTitles1.getId());
                    titleService.answerrecord(userLogin.getId(), carTitles1.getId(), 0);
                    titleService.answerCount(carTitles1.getId(), 0);
                    map.put("carTitle", carTitles1);
                    map.put("result", "答题错误");
                }
                session.setAttribute("rightCount", rightCount);
                session.setAttribute("wrongCount", wrongCount);
                carTitles.set(id - 1, carTitles1);
            } else {
                map.put("result", "未答题");
            }
        }


        session.setAttribute("carTitles", carTitles);

        map.put("carTitlesCount", carTitlesCount);
        map.put("rightCount", rightCount);
        map.put("wrongCount", wrongCount);
        return map;
    }


    //收藏
    @RequestMapping("shoucang")
    @ResponseBody
    public Map shoucang(@RequestParam int id, HttpSession session) {
        User userLogin = (User) session.getAttribute("userLogin");

        List<Title> carTitles = (List<Title>) session.getAttribute("carTitles");
        titleService.insertShouCang(userLogin.getId(), carTitles.get(id - 1).getId());
        Map map = new HashMap();
        map.put("result", "收藏成功");
        return map;
    }

    //取消收藏
    @RequestMapping("noshoucang")
    @ResponseBody
    public Map noshoucang(@RequestParam int id, HttpSession session) {
        User userLogin = (User) session.getAttribute("userLogin");
        List<Title> carTitles = (List<Title>) session.getAttribute("carTitles");
        titleService.deleteShouCang(userLogin.getId(), carTitles.get(id - 1).getId());
        Map map = new HashMap();
        map.put("result", "取消收藏成功");
        return map;
    }

    // TODO: 2020/2/15 over


    @RequestMapping("carFirstTestOver")
    @ResponseBody
    public Map carFirstTestOver(@RequestParam int id1, HttpSession session) {
        List<Title> carTitles = new ArrayList<>();
        carTitles = (List<Title>) session.getAttribute("carTitles");


        int score = 0;
        for (Title t : carTitles
        ) {
            score += t.getScore1();
        }

        User userLogin = (User) session.getAttribute("userLogin");

        userService.insertTestRecord(userLogin.getId(), "科目一", "小车", score);


        session.setAttribute("score", score);

        Map map = new HashMap();
        map.put("score", score);

        return map;
    }


    @RequestMapping("carFourthTestOver")
    @ResponseBody
    public Map carFourthTestOver(@RequestParam int id1, HttpSession session) {
        List<Title> carTitles = new ArrayList<>();
        carTitles = (List<Title>) session.getAttribute("carTitles");


        int score = 0;
        for (Title t : carTitles
        ) {
            score += t.getScore1();
        }

        User userLogin = (User) session.getAttribute("userLogin");

        userService.insertTestRecord(userLogin.getId(), "科目四", "小车", score);


        session.setAttribute("score", score);

        Map map = new HashMap();
        map.put("score", score);

        return map;
    }


}


