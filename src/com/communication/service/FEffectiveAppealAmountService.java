package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FEffectiveAppealAmountDao;
import com.communication.entity.FEffectiveAppealAmount;
import com.communication.util.Order;
import com.communication.util.Property;
/**
 * 有效申诉量统计情况
 **/
@Service
public class FEffectiveAppealAmountService extends BaseService<FEffectiveAppealAmount> {
	
	@Resource
	private void setDao(FEffectiveAppealAmountDao dao) {
		super.setDao(dao);
	}

	public FEffectiveAppealAmount queryByReportLogId(long reportLogId) {
		List<FEffectiveAppealAmount> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
