package wusc.edu.pay.core.account.dao;

import org.apache.ibatis.annotations.Mapper;
import wusc.edu.pay.common.core.dao.BaseDao;
import wusc.edu.pay.common.core.tk.TplDataService;
import wusc.edu.pay.facade.account.entity.Account;

@Mapper
public interface AccountDao extends TplDataService<Account> {

	/**
	 * 生成账户编号20位
	 * 
	 * @param accountType
	 * @return
	 */
	public String buildAccountNo(String accountType);

	/**
	 * 根據帳戶編號獲取帳戶信息
	 * 
	 * @param accountNo
	 * @return
	 */
	public Account getByAccountNo(String accountNo);

	/**
	 * 获取账户实体
	 * 
	 * @param userNo
	 * @param accountType
	 * @param isPessimist
	 *            是否乐观锁
	 * @return
	 */
	public Account getByUserNo_IsPessimist(String userNo, boolean isPessimist);



}
