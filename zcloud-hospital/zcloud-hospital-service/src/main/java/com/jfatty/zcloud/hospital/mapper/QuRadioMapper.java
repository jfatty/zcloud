package com.jfatty.zcloud.hospital.mapper;

import com.jfatty.zcloud.base.mapper.IBaseMapper;
import com.jfatty.zcloud.hospital.entity.QuRadio;
import com.jfatty.zcloud.hospital.vo.OptionsForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  单选题 Mapper 接口
 * </p>
 *
 * @author jfatty
 * @since 2020-04-30
 */
public interface QuRadioMapper extends IBaseMapper<QuRadio> {

    List<OptionsForm> getOptionsForms(@Param("quId") String quId);

}
