package com.jfatty.zcloud.system.api;

import com.jfatty.zcloud.system.entity.AccountUnique;
import com.jfatty.zcloud.system.interfaces.IAccountUnique;
import com.jfatty.zcloud.system.req.AccountUniqueReq;
import com.jfatty.zcloud.system.res.AccountUniqueRes;
import com.jfatty.zcloud.system.service.AccountUniqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author jfatty on 2019/11/13
 * @email jfatty@163.com
 */
@Slf4j
@RestController
@RequestMapping(value={"/api/accountUnique"})
public class ApiAccountUniqueController extends ApiBaseSystemController<AccountUnique,AccountUniqueReq,AccountUniqueRes>  implements IAccountUnique {

    private AccountUniqueService accountUniqueService ;

    @Autowired
    public void setAccountUniqueService(AccountUniqueService accountUniqueService) {
        super.setBaseService(accountUniqueService);
        this.accountUniqueService = accountUniqueService;
    }
}
