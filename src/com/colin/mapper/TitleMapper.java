package com.colin.mapper;

import com.colin.bean.Title;

import java.util.List;

public interface TitleMapper {

    List<Title> selectAllTitle(int pageBegin, int pageCount);

    void insertTitle(Title title);

    Integer selectCount();

    void deleteTitle(int id);

    Integer selectClassCount(String class1, String class2, String class3);

    Integer selectClassCount1(String class3);

    List<Title> selectClassTitle(int pageBegin, int pageCount, String cla);

    List<Title> selectClassTitle1(int pageBegin, int pageCount, String cla3);

    Title selectTitle(String id);

    void updateTitle(Title title);

    List<Title> selectRandTitle(String cla1, String cla3, int count);

    Integer selectCarFirstCount();

    Integer selectCarFourthCount();

    List<Title> selectTitlesBycla3cla1(String class3, String class1);

    void insertShouCang(String uid, int tid);

    void deleteShouCang(String uid, int tid);

    Integer collection(String uid, Integer tid);

    Integer selectUserTitleCount(String uid, int right, String class1, String class3);

    Integer selectCollectionCount(String uid, String class1, String class3);

    List<Title> selectScTitlesBycla3cla1(String uid, String class1, String class3);

    void answerrecord(String uid, Integer tid, int right);

    void deleteAnswerrecord(String uid, Integer tid);

    List<Title> selectTitlesBycla123(String class1, String class2, String class3);

    List<Title> selectRandTitleByCla123(String class1, String class2, String class3);

    void deleteCollection(int id);

    void deleteAnswerrecord1(int id);

    void answerCount(Integer id);

    void answerCount1(Integer id);

    List<Title> selectNdTitlesBycla13(String class1, String class3, int count);


    List<Title> selectQzTitlesByclassm13(int multiple, String class1, String class3, int count);

    Integer selectWrongCount(String uid, String class1, String class3);

    List<Title> selectWrongTitles(String uid, String class1, String class3);

    List<String> selectClass3();

    List<String> selectClass1(String class3);

    List<String> selectClass2(String class3, String class1);

    Integer selectClassCount2(String cla3, String cla1);

    Integer selectClassCount3(String cla3, String cla1, String cla2);

    List<Title> selectClassTitle2(int pageBegin, int pageCount, String cla3, String cla1);

    List<Title> selectClassTitle3(int pageBegin, int pageCount, String cla3, String cla1, String cla2);

}
