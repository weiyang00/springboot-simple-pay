package wusc.edu.pay.core.user.dao;

import org.apache.ibatis.annotations.Mapper;
import wusc.edu.pay.common.core.dao.BaseDao;
import wusc.edu.pay.common.core.tk.TplDataService;
import wusc.edu.pay.facade.user.entity.MerchantAction;
import wusc.edu.pay.facade.user.entity.MerchantFile;


/***
 * 商户资质文件的Dao接口类
 * 
 * @author huangbin
 * 
 */
@Mapper
public interface MerchantFileDao extends TplDataService<MerchantFile> {

	/***
	 * 根据商户编号查询资质文件信息
	 * @param merchantNo
	 * @return
	 */
	MerchantFile getByMerchantNo(String merchantNo);
	
	
	
}
