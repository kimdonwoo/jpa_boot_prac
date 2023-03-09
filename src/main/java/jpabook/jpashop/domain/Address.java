package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    // 값 타입은 변경 불가능하게 설계해야 한다
    // @Setter를 제거하고 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자
    // @Embeddable은 자바 기본생성자를 public이나 protected로 설정해야 한다
    // 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 때 리플렉션 같은 기술을 사용할 수 있도록
    // 지원해야하기 때문이다.

    private String city;
    private String street;
    private String zipcode;

    protected Address(){
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
