/**
 * 
 */
package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FSpamMessageDao;
import com.communication.entity.FSpamMessage;
import com.communication.util.Order;
import com.communication.util.Property;

/**
 * @author Administrator
 *
 */
@Service
public class FSpamMessageService extends BaseService<FSpamMessage> {
	@Resource
	private void setDao(FSpamMessageDao dao) {
		super.setDao(dao);
	}

	public FSpamMessage queryByReportLogId(long reportLogId) {
		List<FSpamMessage>  list = getDao().findAll(Order.asc("id"), Property.eq("reportLogId", reportLogId));
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
