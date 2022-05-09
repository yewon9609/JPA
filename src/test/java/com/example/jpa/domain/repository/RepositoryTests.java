package com.example.jpa.domain.repository;

import com.example.jpa.domain.vo.MemberVO;
import com.example.jpa.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveMemBerTest(){
        String id = "syw1234";
        String name = "서예원";
        String birth = "2000-12-04";

        // 초기화 된 객체를 insert
        memberRepository.save(MemberVO.builder().memberId(id).memberName(name).memberBirth(birth).build());


    }


    //상품한개 추가
    @Test
    public void readMemberTest(){

        String name = "사과";
        Long price = 8000L;
        Long stock = 10L;

        // 초기화 된 객체를 insert
        productRepository.save(ProductVO.builder().productName(name).productPrice(price).productStock(stock).build());
    }









}
