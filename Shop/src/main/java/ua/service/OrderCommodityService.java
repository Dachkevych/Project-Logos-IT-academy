package ua.service;

import ua.entity.OrderCommodity;

public interface OrderCommodityService extends CrudService<OrderCommodity, Integer>{

	public void save(OrderCommodity orderCommodity);
	
}
