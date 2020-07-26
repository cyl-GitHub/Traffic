package com.colin.service.impl;

import com.colin.bean.Title;
import com.colin.mapper.TitleMapper;
import com.colin.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    TitleMapper titleMapper;


    @Override
    public List<Title> selectAllTitle(int pageBegin, int pageCount) {
        return titleMapper.selectAllTitle(pageBegin, pageCount);
    }

    @Override
    public void insertTitle(Title title) {
        titleMapper.insertTitle(title);
    }

    @Override
    public Integer selectCount() {
        return titleMapper.selectCount();
    }

    @Override
    public Integer selectClassCount(String class1, String class2, String class3) {
        return titleMapper.selectClassCount(class1, class2, class3);
    }

    @Override
    public Integer selectClassCount1(String class3) {
        return titleMapper.selectClassCount1(class3);
    }

    @Override
    public void deleteTitle(int id) {
        titleMapper.deleteTitle(id);
    }

    @Override
    public List<Title> selectClassTitle(int pageBegin, int pageCount, String cla) {
        return titleMapper.selectClassTitle(pageBegin, pageCount, cla);
    }

    @Override
    public List<Title> selectClassTitle1(int pageBegin, int pageCount, String cla3) {
        return titleMapper.selectClassTitle1(pageBegin, pageCount, cla3);
    }

    @Override
    public Title selectTitle(String id) {
        return titleMapper.selectTitle(id);
    }

    @Override
    public void updateTitle(Title title) {
        titleMapper.updateTitle(title);
    }

    @Override
    public List<Title> selectRandTitle(String cla1, String cla3, int count) {
        return titleMapper.selectRandTitle(cla1, cla3, count);
    }

    @Override
    public Integer selectCarFirstCount() {
        return titleMapper.selectCarFirstCount();
    }

    @Override
    public Integer selectCarFourthCount() {
        return titleMapper.selectCarFourthCount();
    }

    @Override
    public List<Title> selectTitlesBycla3cla1(String class3, String class1) {
        return titleMapper.selectTitlesBycla3cla1(class3, class1);
    }

    @Override
    public void insertShouCang(String uid, int tid) {
        titleMapper.insertShouCang(uid, tid);
    }

    @Override
    public void deleteShouCang(String uid, int tid) {
        titleMapper.deleteShouCang(uid, tid);
    }

    @Override
    public Boolean collection(String uid, Integer tid) {
        Integer collectionCount = titleMapper.collection(uid, tid);
        if (collectionCount > 0) {
            return true;
        } else {
            return false;
        }

    }


    @Override
    public Integer selectUserTitleCount(String uid, int right, String class1, String class3) {
        return titleMapper.selectUserTitleCount(uid, right, class1, class3);
    }

    @Override
    public Integer selectCollectionCount(String uid, String class1, String class3) {

        return titleMapper.selectCollectionCount(uid, class1, class3);
    }

    @Override
    public List<Title> selectScTitlesBycla3cla1(String uid, String class1, String class3) {
        return titleMapper.selectScTitlesBycla3cla1(uid, class1, class3);
    }

    @Override
    public void answerrecord(String uid, Integer tid, int right) {
        titleMapper.answerrecord(uid, tid, right);

    }

    @Override
    public void deleteAnswerrecord(String uid, Integer tid) {
        titleMapper.deleteAnswerrecord(uid, tid);
    }

    @Override
    public List<Title> selectTitlesBycla123(String class1, String class2, String class3) {
        return titleMapper.selectTitlesBycla123(class1, class2, class3);
    }

    @Override
    public List<Title> selectRandTitleByCla123(String class1, String class2, String class3) {
        return titleMapper.selectRandTitleByCla123(class1, class2, class3);
    }

    @Override
    public void deleteCollection(int id) {
        titleMapper.deleteCollection(id);
    }

    @Override
    public void deleteAnswerrecord1(int id) {
        titleMapper.deleteAnswerrecord1(id);
    }

    @Override
    public void answerCount(Integer id, int i) {
        if (i == 0) {
            titleMapper.answerCount(id);
        } else if (i == 1) {
            titleMapper.answerCount1(id);
        }
    }

    @Override
    public List<Title> selectNdTitlesBycla13(String class1, String class3, int count) {
        return titleMapper.selectNdTitlesBycla13(class1, class3, count);
    }

    @Override
    public List<Title> selectQzTitlesByclassm13(int multiple, String class1, String class3, int count) {
        return titleMapper.selectQzTitlesByclassm13(multiple, class1, class3, count);

    }

    @Override
    public Integer selectWrongCount(String uid, String class1, String class3) {

        return titleMapper.selectWrongCount(uid, class1, class3);
    }

    @Override
    public List<Title> selectWrongTitles(String uid, String class1, String class3) {
        return titleMapper.selectWrongTitles(uid, class1, class3);
    }

    @Override
    public List<String> selectClass3() {
        return titleMapper.selectClass3();
    }

    @Override
    public List<String> selectClass1(String class3) {

        return titleMapper.selectClass1(class3);

    }

    @Override
    public List<String> selectClass2(String class3, String class1) {
        return titleMapper.selectClass2(class3, class1);
    }

    @Override
    public Integer selectClassCount2(String cla3, String cla1, String cla2) {
        if (cla1.equals("全部")) {
            return titleMapper.selectClassCount1(cla3);

        } else {
            if (cla2.equals("全部")) {
                return titleMapper.selectClassCount2(cla3, cla1);
            } else {
                return titleMapper.selectClassCount3(cla3, cla1, cla2);
            }
        }
    }

    @Override
    public List<Title> selectClassTitle2(int pageBegin, int pageCount, String cla3, String cla1, String cla2) {

        if (cla1.equals("全部")) {
            return titleMapper.selectClassTitle1(pageBegin, pageCount, cla3);
        } else {

            if (cla2.equals("全部")) {
                return titleMapper.selectClassTitle2(pageBegin, pageCount, cla3, cla1);
            } else {
                return titleMapper.selectClassTitle3(pageBegin, pageCount, cla3, cla1, cla2);
            }
        }
    }
}
