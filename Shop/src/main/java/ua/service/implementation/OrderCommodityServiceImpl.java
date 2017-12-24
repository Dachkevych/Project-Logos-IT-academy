package ua.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.OrderCommodity;
import ua.repository.OrderCommodityRepository;
import ua.service.OrderCommodityService;

@Service
public class OrderCommodityServiceImpl extends CrudServiceImpl<OrderCommodity, Integer>implements OrderCommodityService{

	@Autowired
	public OrderCommodityServiceImpl(OrderCommodityRepository repository) {
		super(repository);
	}
}
