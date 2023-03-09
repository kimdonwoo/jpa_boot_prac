package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Repository는 Entity를 찾아주는 애
// 주입 받은 EntityManager의 메소드 공부
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        //em.persist() 쓰면 저장
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    // sql은 테이블을 대상으로 쿼리를 하는데 얘는 엔티티 객체를 대상으로 쿼리를 함
    // entity Member를 조회
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name= :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
