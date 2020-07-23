package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.QuCheckbox;
import com.jfatty.zcloud.hospital.vo.OptionsForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  多选题 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface QuCheckboxMapper extends IBaseMapper<QuCheckbox> {

    List<OptionsForm> getOptionsForms(@Param("quId") String quId);


}
