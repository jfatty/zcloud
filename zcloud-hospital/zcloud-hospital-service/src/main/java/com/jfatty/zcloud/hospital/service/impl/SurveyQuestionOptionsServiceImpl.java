package com.jfatty.zcloud.hospital.service.impl;

import com.jfatty.zcloud.base.utils.StringUtils;
import com.jfatty.zcloud.base.utils.UUIDGenerator;
import com.jfatty.zcloud.hospital.dto.OptionsFormDTO;
import com.jfatty.zcloud.hospital.dto.QuestionFormDTO;
import com.jfatty.zcloud.hospital.entity.*;
import com.jfatty.zcloud.hospital.mapper.*;
import com.jfatty.zcloud.hospital.req.SurveyFormReq;
import com.jfatty.zcloud.hospital.res.SurveyFormRes;
import com.jfatty.zcloud.hospital.service.SurveyQuestionOptionsService;
import com.jfatty.zcloud.hospital.vo.OptionsForm;
import com.jfatty.zcloud.hospital.vo.QuestionForm;
import com.jfatty.zcloud.hospital.vo.SurveyForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author jfatty on 2020/5/27
 * @email jfatty@163.com
 */
@Slf4j
@Service
public class SurveyQuestionOptionsServiceImpl implements SurveyQuestionOptionsService {


    public static final String CHECKED_MARK = "checked" ; //选中标记

    @Autowired
    private SurveyDirectoryMapper surveyDirectoryMapper ;

    @Autowired
    private QuestionMapper questionMapper ;

    @Autowired
    private QuRadioMapper quRadioMapper ;

    @Autowired
    private QuCheckboxMapper quCheckboxMapper ;

    @Autowired
    private QuMultiFillblankMapper quMultiFillblankMapper ;

    @Autowired
    private AnRadioMapper anRadioMapper ;

    @Autowired
    private AnCheckboxMapper anCheckboxMapper ;

    @Autowired
    private AnFillblankMapper anFillblankMapper ;

    @Autowired
    private SurveyAnswerMapper surveyAnswerMapper ;

    @Autowired
    private SurveyQuestionOptionsMapper surveyQuestionOptionsMapper ;

    @Autowired
    private QuestionAnswerMapper questionAnswerMapper ;

    @Override
    public SurveyFormRes getSurveyForm(String surveyId, String answerId, String operator) {

        SurveyFormRes surveyFormRes = new SurveyFormRes();
        boolean isView = false ; //是否为回显
        if ( StringUtils.isNotEmptyAndBlank(answerId) ) {
            isView = true ;
        }

        SurveyForm surveyForm = null ;

        if ( isView ) {
            surveyForm = surveyDirectoryMapper.getSurveyFormWithAnswer(surveyId,answerId) ;
        } else {
            surveyForm = surveyDirectoryMapper.getSurveyForm(surveyId) ;
        }

        BeanUtils.copyProperties(surveyForm,surveyFormRes);

        List<QuestionFormDTO> questionFormDTOS = new ArrayList<QuestionFormDTO>();

        List<QuestionForm> questions = questionMapper.getQuestionForms(surveyId);

        for ( QuestionForm questionForm : questions  ) {
            QuestionFormDTO questionFormDTO = new QuestionFormDTO();
            String quId = questionForm.getId() ;
            Integer quType = questionForm.getQuType() ;
            if ( isView ) {
                String settings = questionAnswerMapper.getQuestionAnswer(surveyId,answerId,quId);
                if ( StringUtils.isNotEmptyAndBlank(settings) ) {
                    questionForm.setSettings(settings);
                }

            }

            List<OptionsForm> optionsForms = null ;
            List<OptionsFormDTO> optionsFormDTOS = new ArrayList<OptionsFormDTO>();
            if(quType == 1){//单选题 quItemId
                optionsForms = quRadioMapper.getOptionsForms(quId) ;
                for ( OptionsForm optionsForm : optionsForms ) {
                    OptionsFormDTO optionsFormDTO = new OptionsFormDTO();
                    if ( isView ) {
                        String remark = anRadioMapper.getOptionsFormsWithAnswer(surveyId,answerId,quId,optionsForm.getId()) ;
                        if ( StringUtils.isNotEmptyAndBlank(remark) ) {
                            optionsForm.setAnswer(CHECKED_MARK);
                            optionsForm.setRemark(remark);
                        }
                    }
                    BeanUtils.copyProperties(optionsForm,optionsFormDTO);
                    optionsFormDTOS.add(optionsFormDTO);
                }

            }else if (quType == 2){//复选题
                optionsForms = quCheckboxMapper.getOptionsForms(quId) ;
                for ( OptionsForm optionsForm : optionsForms ) {
                    OptionsFormDTO optionsFormDTO = new OptionsFormDTO();
                    if ( isView ) {
                        String remark = anCheckboxMapper.getOptionsFormsWithAnswer(surveyId,answerId,quId,optionsForm.getId()) ;
                        if ( StringUtils.isNotEmptyAndBlank(remark) ) {
                            optionsForm.setAnswer(CHECKED_MARK);
                            optionsForm.setRemark(remark);
                        }
                    }
                    BeanUtils.copyProperties(optionsForm,optionsFormDTO);
                    optionsFormDTOS.add(optionsFormDTO);
                }
            }else if (quType == 6){//复合填空题

            }else{
                OptionsFormDTO optionsFormDTO = new OptionsFormDTO();
                if ( isView ) {
                    AnFillblank answer = anFillblankMapper.getOptionsFormsWithAnswer(surveyId,answerId,quId);
                    if ( answer != null ) {
                        optionsFormDTO.setAnswer(answer.getAnswer());
                        optionsFormDTO.setRemark(answer.getId());
                    }
                }
                optionsFormDTOS.add(optionsFormDTO);
            }

            BeanUtils.copyProperties(questionForm,questionFormDTO);
            questionFormDTO.setOptionses(new ArrayList<OptionsFormDTO>(optionsFormDTOS));
            questionFormDTOS.add(questionFormDTO);
        }

        surveyFormRes.setQuestions(new ArrayList<QuestionFormDTO>(questionFormDTOS));
        return surveyFormRes;
    }

    @Override
    public String edit(SurveyFormReq surveyFormReq) throws Exception {

        //是否为更新量表操作
        boolean isUpdateSurvey = false ;
        String surveyId = surveyFormReq.getSurveyId() ;

        String answerId = surveyFormReq.getAnswerId() ;

        //答案ID为空表示新增
        if( StringUtils.isEmptyOrBlank(answerId) ) {
            answerId = UUIDGenerator.uuid() ;
        } else {
            //不为空表示修改操作
            isUpdateSurvey = true ;
        }


        LocalDateTime bgAnDate = surveyFormReq.getBgAnDate() ;
        LocalDateTime endAnDate = surveyFormReq.getEndAnDate() ;
        String associationId = surveyFormReq.getAssociationId() ;
        String associationer = surveyFormReq.getAssociationer() ;
        String operator = surveyFormReq.getOperator() ;
        String openId = surveyFormReq.getOpenId() ;

        SurveyAnswer surveyAnswer = new SurveyAnswer() ;

        surveyAnswer.setId(answerId);
        surveyAnswer.setBgAnDate(bgAnDate);
        surveyAnswer.setEndAnDate(endAnDate);
        surveyAnswer.setSurveyId(surveyId);
        surveyAnswer.setAssociationId(associationId);
        surveyAnswer.setAssociationer(associationer);
        surveyAnswer.setOperator(operator);
        surveyAnswer.setOpenId(openId);

        //设置操作时间
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        surveyAnswer.setOperationTime(df.format(LocalDateTime.now()));

        List<QuestionFormDTO> questions = surveyFormReq.getQuestions() ;

        //填空题
        List<AnFillblank> anFillblanks = new ArrayList<AnFillblank>();

        //单选题
        List<AnRadio> anRadios = new ArrayList<AnRadio>();
        //多选题
        List<AnCheckbox> anCheckboxes = new ArrayList<AnCheckbox>();

        //题目答案集合
        List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();

        for ( QuestionFormDTO questionFormDTO : questions  ) {//题目迭代开始
            String quId = questionFormDTO.getId() ;
            Integer quType = questionFormDTO.getQuType() ;

            String settings = questionFormDTO.getSettings() ;
            //设置题目答案
            if(StringUtils.isNotEmptyAndBlank(settings)){
                questionAnswers.add(new QuestionAnswer(UUIDGenerator.uuid(),surveyId,answerId,quId,settings));
            }


            List<OptionsFormDTO>  optionses = questionFormDTO.getOptionses() ;
            for ( OptionsFormDTO optionsFormDTO : optionses ) { //选项迭代开始
                String answer = optionsFormDTO.getAnswer() ;
                String remark = optionsFormDTO.getRemark() ;
                String customize = optionsFormDTO.getCustomize() ;
                if(quType == 1){//单选题 quItemId
                    if (CHECKED_MARK.equals(answer)) {
                        String quItemId = optionsFormDTO.getId() ;
                        anRadios.add(new AnRadio(UUIDGenerator.uuid(),answerId,surveyId,"",quId,quItemId,customize));
                    }
                    log.error("题目迭代======================>[单选题]");
                    //AnRadio(String id, String belongAnswerId, String belongId, String otherText, String quId, String quItemId, String customize)
                    //anRadios.add(new AnRadio(UUIDBuild.getUUID(),surveyId,answerId,quId,answer.getName(),answer.getNote(),
                    //        score,quAnswerStatus,quAnswerStatusNote,question.isCheckAnValue()?answer.getNoteValue():""));
                } else if (quType == 2){//复选题
                    if (CHECKED_MARK.equals(answer)) {
                        String quItemId = optionsFormDTO.getId() ;
                        //AnCheckbox(String id, String belongAnswerId, String belongId, String otherText, String quId, String quItemId, String customize)
                        anCheckboxes.add(new AnCheckbox(UUIDGenerator.uuid(),answerId,surveyId,"",quId,quItemId,customize));
                    }
                    log.error("题目迭代======================>[复选题]");
                } else if (quType == 6){//复合填空题

                } else {//填空题

                    log.error("题目迭代======================>[填空题]");
                    //AnFillblank(String id, String answer, String answerNote, String belongAnswerId, String belongId, String quId, String customize)

                    anFillblanks.add(new AnFillblank(UUIDGenerator.uuid(),answer,"",answerId,surveyId,quId,customize));

                }


            }//选项迭代完成


            log.error("题目迭代======================>[{}]",questionFormDTO);



        }//题目迭代完成

        if ( isUpdateSurvey ) {
            surveyAnswerMapper.updateById(surveyAnswer);

            if ( !CollectionUtils.isEmpty(questionAnswers) ){
                surveyQuestionOptionsMapper.deleteQuestionAnswers(questionAnswers);
            }
            if ( !CollectionUtils.isEmpty(anFillblanks) ){
                surveyQuestionOptionsMapper.deleteAnFillblanks(anFillblanks);
            }
            if ( !CollectionUtils.isEmpty(anRadios) ) {
                surveyQuestionOptionsMapper.deleteAnRadios(anRadios) ;
            }

            if ( !CollectionUtils.isEmpty(anCheckboxes) ) {
                surveyQuestionOptionsMapper.deleteAnCheckboxes(anCheckboxes) ;
            }

        } else {
            //写入量表结果
            surveyAnswerMapper.insert(surveyAnswer) ;
        }


        //写入各类选项答案
        if ( !CollectionUtils.isEmpty(questionAnswers) ){
            surveyQuestionOptionsMapper.insertQuestionAnswers(questionAnswers);
        }
        if ( !CollectionUtils.isEmpty(anFillblanks) ){
            surveyQuestionOptionsMapper.insertAnFillblanks(anFillblanks);
        }
        if ( !CollectionUtils.isEmpty(anRadios) ) {
            surveyQuestionOptionsMapper.insertAnRadios(anRadios);
        }

        if ( !CollectionUtils.isEmpty(anCheckboxes) ) {
            surveyQuestionOptionsMapper.insertAnCheckboxes(anCheckboxes);
        }
        if ( isUpdateSurvey ) {
            return "修改成功" ;
        }
        return "保存成功" ;
    }

    @Override
    public List<SurveyForm> getSurveyForms(String menuId) {
        //设置操作时间
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(LocalDateTime.now()) ;
        return surveyDirectoryMapper.getSurveyForms(menuId,currentTime);
    }

    @Override
    public List<SurveyForm> getSurFormsByTypes(List<String> surveyTypes) {
        return surveyDirectoryMapper.getSurFormsByTypes(surveyTypes);
    }

    @Override
    public SurveyAnswer getMidSurveyAnswer(String surveyId, String operator, String startTime, String endTime) {
        return surveyAnswerMapper.getMidSurveyAnswer(surveyId,operator,startTime,endTime);
    }

    @Override
    public SurveyAnswer getMoreSurveyAnswer(String surveyId, String operator, String endTime) {
        return surveyAnswerMapper.getMoreSurveyAnswer(surveyId,operator,endTime) ;
    }
}
