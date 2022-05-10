package com.example.jpa.domain.repository;

import com.example.jpa.domain.vo.OrderVO;
import com.example.jpa.domain.vo.ProductVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<OrderVO, Long> {

//  상품 정보로 주문 테이블의 데이터를 삭제할 때에는 연관관계를 맺고 있기 때문에
//  하나의 컬럼이 아닌 객체 전체로 삭제해야 한다.
    @Transactional
    void deleteByProductVO(ProductVO productVO);




}
