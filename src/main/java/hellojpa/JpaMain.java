package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    try {
      //member 생성
//      Member member = new Member();
//      member.setId(1L);
//      member.setName("HelloA");
//      em.persist(member);
//---
      /**
       * 영속성 컨텍스트의 이점
       * 1차 캐시
       * 동일성(Identity) 보장
       * 트래잭션을 지원하는 쓰기 지연(transactional write-behind)
       * 변경 감지(Dirty Checking)
       * 지연 로딩(Lazy Loading)
       */

      //비영속
//      Member memberB = new Member();
//      memberB.setId(3L);
//      memberB.setName("HelloJPA");
//
      //영속
//      System.out.print("==== BEFORE ====");
//      em.persist(memberB);
      //준영속, 삭제
//      em.detach(memberB);
//      System.out.print("==== AFTER ====");
//---
      //영속성 컨텍스트의 1차 캐시에 의해 조회되는 findMember2
//      Member findMember1 = em.find(Member.class, 101L);
//      Member findMember2 = em.find(Member.class, 101L);

      //영속 엔티티의 동일성 보장
      // 1차 캐시로 반복 가능한 읽기(REPEATABLE READ) 등급의 트랜잭션 격ㄱ리 수준을
      // 데이터베이스가 아닌 애플리케이션 차원에서 제공
//      Member findMember1 = em.find(Member.class, 101L);
//      Member findMember2 = em.find(Member.class, 101L);
//      System.out.print(findMember1 == findMember2);

      //엔티티 등록
      //트랜잭션을 지원하는 쓰기 지연
//      Member findMember1 = em.find(Member.class, 101L);
//      Member findMember2 = em.find(Member.class, 101L);

      //쓰기지연 SQL 저장소에 INSERT 쿼리는 쌓아둠
//      em.persist(findMember1);
//      em.persist(findMember2);

//      Member member1 = em.find(Member.class, findMember1);
      //commit하는 순간에 findMember1과 findMember2가 저장된다.(flush)
//      tx.commit();
      //---

      //엔티티 수정
      //변경 감지
//      Member member2 = em.find(Member.class, 150L);
//      member2.setName("ZZZZZ");


      System.out.print("======================");

      /**
       * select
       *             member0_.id as id1_0_,
       *             member0_.name as name2_0_
       *         from
       *             Member member0_
       */
      List<Member> result = em.createQuery("select m from Member as m", Member.class)
          .getResultList();

      for (Member member : result) {
        System.out.println("member.getName() = " + member.getName());
      }

      //member 수정
//      Member findMember = em.find(Member.class, 1L);
//      findMember.setName("HelloJPA");

      //member 삭제
//      Member findMember = em.find(Member.class, 1L);
//      em.remove(findMember);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();

  }
}
