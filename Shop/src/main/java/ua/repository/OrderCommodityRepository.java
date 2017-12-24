package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.OrderCommodity;

public interface OrderCommodityRepository extends JpaRepository<OrderCommodity, Integer>{
	
	

}
