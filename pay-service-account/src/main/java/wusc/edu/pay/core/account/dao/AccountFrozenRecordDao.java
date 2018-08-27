package wusc.edu.pay.core.account.dao;

import org.apache.ibatis.annotations.Mapper;
import wusc.edu.pay.common.core.dao.BaseDao;
import wusc.edu.pay.facade.account.entity.AccountFrozenRecord;

@Mapper
public interface AccountFrozenRecordDao extends BaseDao<AccountFrozenRecord> {

}
