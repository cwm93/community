/**
 * 
 */
package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FZyzsmzDao;
import com.communication.entity.FZyzsmz;
import com.communication.util.Order;
import com.communication.util.Property;

/**
 * @author Administrator
 *
 */
@Service
public class FZyzsmzService extends BaseService<FZyzsmz> {
	
	@Resource
	private void setDao(FZyzsmzDao dao){
		super.setDao(dao);
	}

	public FZyzsmz queryByReportLogId(long reportLogId) {
		List<FZyzsmz> list = getDao().findAll(Order.desc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
