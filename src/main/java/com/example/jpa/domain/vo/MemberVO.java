package com.example.jpa.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;






@Entity     //이제부터 jpa가 관리한다는걸 알리는 어노테이션 , 물론 springContainer에서도 관리가 된다.
@Table(name = "TBL_MEMBER")     //RDB 테이블 명을 작성한다.
@SequenceGenerator(name = "SEQ_MEMBER", allocationSize = 1)     //시퀀스 만들어줘야함, 시퀀스 컬럼 이름하고 insert할 때 마다 몇씩 증가하는지 작성
//setter는 만들지 않는다 !
@Getter     //Setter를 사용하는 것 보다 Builder pattern을 사용하는 것이 객체의 일관성에 더 좋다(Setter로 초기화를 하면 아직 다 초기화 되지 않은 상태에서 객체가 만들어지기 때문)
@ToString
@NoArgsConstructor      //기본생성자 주입, JPA 의 Entity를 사용할 떄에는 기본 생성자가 반드시 필요하다.
public class MemberVO {
    @Id     //해당 pk위에 작성하는 어노테이션, 없으면 오류남
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER")   //위에서 만든 시퀀스 제너레이터 설정. 시퀀스를 사용할 필드에 사용함.
    @Column(name = "MEMBER_NUMBER") //@Culumn() 어떤 컬럼과 매핑하는지 작성, RDB에서 선언된 컬럼명을 작성하여 클래스의 필드와 연결해준다.
    private Long memberNumber;
    @Column(name = "MEMBER_ID")
    private String memberId;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name = "MEMBER_BIRTH")
    private String memberBirth;


//  @builder는 생성자로 초기화를 진행할 때 간결한 소스코드로 초기화를 진행할 수 있다.
//  하지만 클래스에 @builder를 사용하게 되면 @NoArgsConstructor와 같이 사용할 때 오류가 발생한다.
//  그렇다고 해서 @AllArgsConstructor를 사용하게 되면 변수의 순서를 변경할 때 생성자의 입력 값 순서도 변경되므로
//  다른 개발자가 찾기 힘든 오류가 발생할 수도 있다.
//  따라서 Buider를 사용할 때에는 직접 생성자를 선언하여 생성자에 @Builder를 붙여준다.
    @Builder    //모든 애들이 초기화 되어야지만 메모리에 올라간다 (널값을 허용하지 x)
    public MemberVO(Long memberNumber, String memberId, String memberName, String memberBirth) {
        this.memberNumber = memberNumber;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberBirth = memberBirth;
    }
}














