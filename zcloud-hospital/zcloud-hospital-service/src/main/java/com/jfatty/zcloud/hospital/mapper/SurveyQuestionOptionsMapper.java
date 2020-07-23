package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.hospital.entity.AnCheckbox;
import com.jfatty.zcloud.hospital.entity.AnFillblank;
import com.jfatty.zcloud.hospital.entity.AnRadio;
import com.jfatty.zcloud.hospital.entity.QuestionAnswer;

import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/5/28
 * @email jfatty@163.com
 */
public interface SurveyQuestionOptionsMapper {


    //批量保存填空 数据
    int insertAnFillblanks(List<AnFillblank> list);

    //批量保存单选数据
    int insertAnRadios(List<AnRadio> list);

    //批量保存多选数据
    int insertAnCheckboxes(List<AnCheckbox> list);

    //批量删除填空 数据
    int deleteAnFillblanks(List<AnFillblank> list);

    //批量删除单选数据
    int deleteAnRadios(List<AnRadio> list);

    //批量删除多选数据
    int deleteAnCheckboxes(List<AnCheckbox> list);

    //批量删除 题目答案 数据
    int deleteQuestionAnswers(List<QuestionAnswer> list);

    //批量保存 题目答案 数据
    int insertQuestionAnswers(List<QuestionAnswer> list);


}
