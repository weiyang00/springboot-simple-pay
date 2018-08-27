package wusc.edu.pay.core.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import wusc.edu.pay.common.core.dao.BaseDao;
import wusc.edu.pay.common.core.tk.TplDataService;
import wusc.edu.pay.facade.user.entity.MemberInfo;
import wusc.edu.pay.facade.user.entity.MerchantAction;


/**
 * 
 * @描述: 商户权限管理--权限功能点表数据访问层接口 .
 * @作者: WuShuicheng .
 * @创建时间: 2013-8-6,下午3:40:26 .
 * @版本: 1.0 .
 */
@Mapper
public interface MerchantActionDao extends TplDataService<MerchantAction> {

	/**
	 * 根据实体ID集字符串获取获取对象列表.
	 * @param ids .
	 * @return 
	 */
	List<MerchantAction> listByIds(String ids);

	/**
	 * @param merType
	 * @return
	 */
	List<MerchantAction> listMerActionByMerType(String merType);

}
