package com.spring.memo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.memo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	//findBy + 필드명 
	//상품이름으로 검색
	 List<Item> findByItemNm(String itemNm);
	 
	 //상품명 or 상품상세설명
     //findBy + 필드명 + Or + 필드명
	 List<Item>	findByItemNmOrItemDetail(String itemNm,String ItemDetail);

	 //특정가격 이하인 상품 조회
	 List<Item> findByPriceLessThan(int price);

	 //특정가격 이하인 상품 조회 후 내림차순 정렬
	 List<Item> findByPriceLessThanOrderByPriceDesc(int price);

}
