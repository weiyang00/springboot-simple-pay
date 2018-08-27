package wusc.edu.pay.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wusc.edu.pay.facade.account.entity.Account;
import wusc.edu.pay.facade.account.service.AccountQueryFacade;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class AccountRestController {

    @Reference(version = "1.0.0")
    AccountQueryFacade accountQueryFacade;

    @RequestMapping(value = "/api/account", method = RequestMethod.GET)
    public Account findOneCity(@RequestParam(value = "accountNo", required = true) String accountNo) {
        System.out.println("accountNo === " + accountNo);
        return accountQueryFacade.getAccountByAccountNo(accountNo);
    }



}
