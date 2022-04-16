package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
      //JPA에서 가장 중요한 2가지
      // 객체와 관계형 데이터벵시ㅡ 매핑하기
      // 영속성 컨텍스트
      //  - JPA를 이해하는데 가장 중요한 용어
      //  - 엔티티를 영구 저장하는 환경 이라는 뜻
      //  - EntityManager.persist(entity);

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
      //---

      //플러시
      //em.flush() - 직접 호출
      //tx.commit() - 트랜잭션 커밋 시점에 플러시 자동 호출
      //JPQL 쿼리 실행 - JPQL 쿼리 실행 시점에 플러시 자동 호출
//      Member member = new Member(200L, "member200");
//      em.persist(member);

      //트랜잭션 커밋 이전에 "쓰기 지연 SQL 저장소"에 있는 즉, 변경점이 존재하는 대상들을 데이터베이스에 사전 반영
//      em.flush();

//      System.out.println("=====================");

      //JPQL
      Member memberA = new Member(301L,"memberA");
      Member memberB = new Member(302L,"memberB");
      Member memberC = new Member(303L,"memberC");
      em.persist(memberA);
      em.persist(memberB);
      em.persist(memberC);

      //jqpl을 중간에서 실행하게되면, 위의 memberA~C 대상들이 플러시 되어, 쿼리를 수행할 수 있도록 함
      TypedQuery<Member> select_m_from_member_m = em.createQuery("select m from Member m",
          Member.class);

      //플러시 모드 옵션
//      em.setFlushMode(FlushModeType.AUTO);
      //FlushModeType.AUTO : 커밋이나 쿼리를 실행할 때 플러시 (기본값)
//      em.setFlushMode(FlushModeType.COMMIT);
      //FlushModeType.COMMIT : 커밋할 때만 플러시

      //플러시는!
      //영속성 컨텍스트를 비우는 것이 아닌
      //영속성 컨텍스트의 변경내용을 데이터베이스에 동기화 하는 것이다.
      // 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면 됨.

      tx.commit();

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

      //--- 준영속 상태 ---
      // 영속 -> 준영속
      // 영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
      // 영속성 컨텍스트가 제공하는 기능을 사용 못함

      //영속
      Member member = em.find(Member.class, 150L);
      member.setName("AAAAA");

      //준영속 상태로 만드는 방법
      //영속성 컨텍스트 안에 있는 member를 준영속 상태로 만듬
      em.detach(member);

      //영속성 컨텍스트안에 있는 내용을 통째로 비움
      em.clear();

      //영속성 컨텍스트를 종료함
      em.close();


      System.out.println("================");
      tx.commit();
      //---


    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();

  }
}