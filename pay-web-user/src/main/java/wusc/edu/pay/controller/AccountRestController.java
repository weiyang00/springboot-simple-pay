package wusc.edu.pay.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wusc.edu.pay.facade.account.entity.Account;
import wusc.edu.pay.facade.account.service.AccountQueryFacade;
import wusc.edu.pay.facade.user.entity.UserInfo;
import wusc.edu.pay.facade.user.service.UserQueryFacade;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class AccountRestController {


    @Reference(version = "1.0.0")
    private UserQueryFacade userQueryFacade;


    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public UserInfo findOneCity( String userNo , String accountNo ) {
        System.out.println("starting -----------------" );
        System.out.println("userNo === " + userNo);
        System.out.println("accountNo == " + accountNo);
        UserInfo userInfo = null;
        if (null != accountNo){
            userInfo = userQueryFacade.getUserInfoByAccountNo(accountNo);
        } else {
            userInfo = userQueryFacade.getUserInfoByUserNo(userNo);
        }
        return userInfo;
    }



}
