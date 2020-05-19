package com.communication.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.communication.dao.FHouseholdBroadbandTariffDao;
import com.communication.entity.FHouseholdBroadbandTariff;
import com.communication.util.Order;
import com.communication.util.Property;

@Service
public class FHouseholdBroadbandTariffService extends BaseService<FHouseholdBroadbandTariff> {
	@Resource
	private void setDao(FHouseholdBroadbandTariffDao dao) {
		super.setDao(dao);
	}

	public FHouseholdBroadbandTariff queryByReportLogId(long reportLogId) {
		List<FHouseholdBroadbandTariff> list = getDao().findAll(Order.desc("id"),
				Property.eq("reportLogId", reportLogId));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
