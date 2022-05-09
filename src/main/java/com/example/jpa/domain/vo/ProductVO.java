package com.example.jpa.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TBL_PRODUCT")

@SequenceGenerator(name = "SEQ_PRODUCT", allocationSize = 1)
@Getter
@ToString
@NoArgsConstructor
public class ProductVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT")
    @Column(name = "PRODUCT_NUMBER")
    private Long productNumber;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_PRICE")
    private Long productPrice;
    @Column(name = "PRODUCT_STOCK")
    private Long productStock;


//    일대다 단방향에는 심각한 문제가 있다.
//    주문을 추가할 때에는 orderVO = OrderVO.builder().orderCount(3).build();로 작성하고
//    상품에 주문을 추가할 때에는 productVo.getOrders().add(orderVO);로 작성하게된다.

//    주문 추가는 INSERT쿼리가 잘 실행되지만, 상품 추가시 상품을 INSERT후 주문을 UPDATE하게 된다.
//    상품에 대한 데이터는 직접 지정할 수 있으나, 주문에 있는 FK(PRODUCT_NUMBER)는 상품이 주가된 후
//    join및 update쿼리를 실행해야 한다. 개발자 입장에서 추가할 때 왜 UPDATE가 되는지에 의문이 들 수 있으니
//    일대다 (1:N)단방향이 필요할 경우에는 차라리 다대일(1:N)양방향으로 연관관계를 맺는것이 좋다.
//    -따라서 현업에서는 일대다 (1:N)는 최대한 사용하지 말자 !


//    일대다 단방향
//    @OneToMany
//    @JoinColumn(name = "ORDER_NUMBER")
//    List<OrderVO> orders = new ArrayList<>();



//  다대일의 역 방향인 일대다 (1:n)는 연관관계 주인을 일(1)로 설정해야한다.
//  다대일 양방향
//  양방향일 경우 연관관계 대상 객체의 이름을 mappedBy로 작성하게 되면 알아서 역방향으로 설정된다.
//  이 때 연관관계의 주인을 mappedBy로 대상 객체인 productVO로 설정해준다.
    @OneToMany(mappedBy = "productVO")
    List<OrderVO> orders = new ArrayList<>();


    @Builder
    public ProductVO(Long productNumber, String productName, Long productPrice, Long productStock) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
