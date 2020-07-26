package com.colin.service;

import com.colin.bean.Title;

import java.util.List;

public interface TitleService {

    //查询所有的题目具体信息
    List<Title> selectAllTitle(int pageBegin, int pageCount);

    //管理员添加题目
    void insertTitle(Title title);

    //查询题库题目总数量
    Integer selectCount();

    //根据题目类别查询题目数量
    Integer selectClassCount(String class1, String class2, String class3);

    Integer selectClassCount1(String class3);


    //管理员删除题目
    void deleteTitle(int id);

    //根据题目类别查询所有题目具体信息分页
    List<Title> selectClassTitle(int pageBegin, int pageCount, String cla);

    List<Title> selectClassTitle1(int pageBegin, int pageCount, String cla3);

    //根据题目id查询题目具体信息
    Title selectTitle(String id);

    //管理员更新题目
    void updateTitle(Title title);

    //根据类别随机抽取一定数量的题目并返回具体信息
    List<Title> selectRandTitle(String cla1, String cla3, int count);

    //查询小车科一题目数量
    Integer selectCarFirstCount();

    //查询小车科四题目数量
    Integer selectCarFourthCount();

    List<Title> selectTitlesBycla3cla1(String class3, String class1);

    //收藏
    void insertShouCang(String uid, int tid);

    //取消收藏
    void deleteShouCang(String id, int id1);

    //检测是否收藏
    Boolean collection(String uid, Integer tid);

    //查某用户以往做对/做错的题数
    Integer selectUserTitleCount(String uid, int right, String class1, String class3);

    Integer selectCollectionCount(String uid, String class1, String class3);

    List<Title> selectScTitlesBycla3cla1(String uid, String class1, String class3);

    void answerrecord(String uid, Integer tid, int right);

    void deleteAnswerrecord(String uid, Integer tid);

    List<Title> selectTitlesBycla123(String class1, String class2, String class3);

    List<Title> selectRandTitleByCla123(String class1, String class2, String class3);

    void deleteCollection(int id);

    void deleteAnswerrecord1(int id);


    void answerCount(Integer id, int i);

    List<Title> selectNdTitlesBycla13(String class1, String class3, int count);


    List<Title> selectQzTitlesByclassm13(int multiple, String class1, String class3, int count);

    Integer selectWrongCount(String uid, String class1, String class3);

    List<Title> selectWrongTitles(String uid, String class1, String class3);

    List<String> selectClass3();

    List<String> selectClass1(String class3);

    List<String> selectClass2(String class3, String class1);

    Integer selectClassCount2(String cla3, String cla1, String cla2);

    List<Title> selectClassTitle2(int i, int pageCount, String cla3, String cla1, String cla2);

}
