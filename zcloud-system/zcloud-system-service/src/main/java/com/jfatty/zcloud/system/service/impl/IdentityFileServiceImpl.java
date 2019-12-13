package com.jfatty.zcloud.system.service.impl;

import com.jfatty.zcloud.system.entity.IdentityFile;
import com.jfatty.zcloud.system.mapper.IdentityFileMapper;
import com.jfatty.zcloud.system.service.IdentityFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jfatty
 * @since 2019-12-13
 */
@Slf4j
@Service
public class IdentityFileServiceImpl extends BaseSystemServiceImpl<IdentityFile, IdentityFileMapper> implements IdentityFileService {

    private IdentityFileMapper identityFileMapper ;

    @Autowired
    public void setIdentityFileMapper(IdentityFileMapper identityFileMapper) {
        super.setBaseMapper(identityFileMapper);
        this.identityFileMapper = identityFileMapper;
    }
}
