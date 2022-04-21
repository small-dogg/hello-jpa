package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();
    try {
//      member 생성
//      Member member = new Member();
//      member.setId(2L);
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
//      Member memberA = new Member(301L,"memberA");
//      Member memberB = new Member(302L,"memberB");
//      Member memberC = new Member(303L,"memberC");
//      em.persist(memberA);
//      em.persist(memberB);
//      em.persist(memberC);

      //jqpl을 중간에서 실행하게되면, 위의 memberA~C 대상들이 플러시 되어, 쿼리를 수행할 수 있도록 함
//      TypedQuery<Member> select_m_from_member_m = em.createQuery("select m from Member m",
//          Member.class);

      //플러시 모드 옵션
//      em.setFlushMode(FlushModeType.AUTO);
      //FlushModeType.AUTO : 커밋이나 쿼리를 실행할 때 플러시 (기본값)
//      em.setFlushMode(FlushModeType.COMMIT);
      //FlushModeType.COMMIT : 커밋할 때만 플러시

      //플러시는!
      //영속성 컨텍스트를 비우는 것이 아닌
      //영속성 컨텍스트의 변경내용을 데이터베이스에 동기화 하는 것이다.
      // 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면 됨.

      /**
       * select
       *             member0_.id as id1_0_,
       *             member0_.name as name2_0_
       *         from
       *             Member member0_
       */
//      List<Member> result = em.createQuery("select m from Member as m", Member.class)
//          .getResultList();

//      for (Member member : result) {
//        System.out.println("member.getName() = " + member.getName());
//      }

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
//      Member member = em.find(Member.class, 150L);
//      member.setName("AAAAA");

      //준영속 상태로 만드는 방법
      //영속성 컨텍스트 안에 있는 member를 준영속 상태로 만듬
//      em.detach(member);

      //영속성 컨텍스트안에 있는 내용을 통째로 비움
//      em.clear();

      //영속성 컨텍스트를 종료함
//      em.close();
      //---

//      Member member = new Member();
//      member.setId(2L);
//      member.setUsername("B");
//      member.setRoleType(RoleType.ADMIN);

      // GenerationType.IDENTITY는 commit 시점에 쿼리를 날리는 일반적인 경우와 달리
      // persist 호출 시점에 INSERT 쿼리를 날린다.
//      Member member = new Member();
//      member.setUsername("C");
//      System.out.println("--------------");
//      em.persist(member);
//      System.out.println("--------------");

      // GenerationType.SEQUENCE는 쿼리는 전송하기 이전에 현재의 시퀀스 값을 얻기 위해 시퀀스 조회 쿼리를 요청함
//      Member member = new Member();
//      member.setUsername("C");
//
//      System.out.println("-------------");
//      em.persist(member);
//      System.out.println("-------------");

      // 위의 문제점은 매 요청마다 시퀀스 및 테이블의 시퀀스를 획득하기 위해, 네트워킹을 수행해야한다는 점이다.
      // 이러한 문제점을 해결하기 위해, JPA에서는 initialValue와 allocationSize를 작성하여, 시퀀스를 처음에만 조회하고
      // 재할당 시점에만 반복 조회하도록 함.
      // initialValue를 1로 그리고 allocationSize를 50으로하면, 최초 한번 조회 후 50번까지는 메모리에서 값을 가져다 입력하고
      // 51번째 다시 재조회하는 식.

      //##연관관계 매핑 기초
      //객체를 테이블에 맞춰 모델링하면 발생하는 문제
//      Team team = new Team();
//      team.setName("TeamA");
      //영속화하면 ID가 들어옴.
//      em.persist(team);
//
//      Member member = new Member();
//      member.setUsername("member1");
      //setTeam이 아닌 setTeamId를 하니.. 객체지향스럽지 못하지..
//      member.setTeamId(team.getId());

      //객체 지향 모델링
//      member.setTeam(team);
//      em.persist(member);
//
//      em.flush();
//      em.clear();
//
//      Member findMember = em.find(Member.class, member.getId());

//      Team findTeam = findMember.getTeam();
//      System.out.println("findTeam = " + findTeam);
//
//      //객체 지향 모델링(연관관계 수정)
//      Team newTeam = em.find(Team.class, 100L);
//      findMember.setTeam(newTeam);

//      List<Member> members = findMember.getTeam().getMembers();
//      for (Member member1 : members) {
//        System.out.println("member1.getUsername() = " + member1.getUsername());//역방향 조회
//      }

      //양방향 매핑시 가장 많이 하는 실수
      //주인에 값을 넣지 않고, 주인이 아닌 곳에 값을 넣음
      //순수한 객체 관계를 고려하면 항상 양쪽다 값을 입력해야 한다.
//      Team team = new Team();
//      team.setName("TeamA");
//      em.persist(team);
//
//      Member member = new Member();
//      member.setUsername("member1");
//      member.changeTeam(team);//**
//      em.persist(member);
//
//
//      team.addMember(member);//**
//
//      em.flush();
//      em.clear();
//
//      Team findTeam = em.find(Team.class, team.getId());
//      List<Member> members = findTeam.getMembers();
//
//      for (Member m : members) {
//        System.out.println("m.getUsername() = " + m.getUsername());
//      }

//      Member member = new Member();
//      member.setUsername("member1");
//
//      em.persist(member);
//
//      Team team = new Team();
//      team.setName("teamA");
//
//      team.getMembers().add(member);
//      em.persist(team);

//      Movie movie = new Movie();
//      movie.setActor("bbb");
//      movie.setDirector("aaa");
//      movie.setName("바람과함께사라지다");
//      movie.setPrice(10000);
//
//      em.persist(movie);
//
//      em.flush();
//      em.clear();
//
//      Movie findMovie = em.find(Movie.class, movie.getId());
//      System.out.println("findMovie = " + findMovie);
//
//      //TABLE_PER_CLASS 의 문제점
//      Item findItem = em.find(Item.class, movie.getId());
//      System.out.println("findItem = " + findItem);

      //MappedSuperclass 적용
//      Member member = new Member();
//      member.setUsername("kim");
//      member.setCreatedBy("kim");
//      member.setCreatedDate(LocalDateTime.now());

      //##Proxy

//      Member member1 = new Member();
//      member1.setUsername("member1");
//      em.persist(member1);

//      Member member2 = new Member();
//      member2.setUsername("member2");
//      em.persist(member2);

//      em.flush();
//      em.clear();

//      em.getReference(Member.class, member1.getId());
//      System.out.println("member.getClass() = " + member1.getClass());
//      System.out.println("member.getId() = " + member1.getId());
//      System.out.println("member.getUsername() = " + member1.getUsername());

//      Member m1 = em.find(Member.class, member1.getId());
//      Member m2 = em.getReference(Member.class, member2.getId());

//      logic(m1, m2);

//      Member m1 = em.find(Member.class, member1.getId());
//      System.out.println("m1.getClass() = " + m1.getClass());
//
//      Member reference = em.getReference(Member.class, member1.getId());
//      System.out.println("reference.getClass() = " + reference.getClass());
//
//      //JPA는 한 트랜잭션안에서 동일한 데이터에 대해서 항상 동일성을 보장해줌.
//      //reference는 영속성 컨텍스트에 이미 실제 데이터가있으면 실 데이터를 반환해줌.
//      System.out.println("a == a: " + (m1 == reference));

//      Member referenceMember = em.getReference(Member.class, member1.getId());
//      System.out.println("referenceMember.getClass() = " + referenceMember.getClass());
//
//      Member findMember = em.find(Member.class, member1.getId());
//      System.out.println("findMember.getClass() = " + findMember.getClass());
//
//      //위에서 reference를 호출한 객체가 있으면 이후 find로 호출한 동일 대상도 Proxy로 맵핑해줌
//      //동일성을 보장해주어야하기때문에...
//      System.out.println("a == a: " + (referenceMember == findMember));

//      Member refMember = em.getReference(Member.class, member1.getId());
//      System.out.println("refMember.getClass() = " + refMember.getClass());//Proxy

//      em.detach(refMember);
      // 또는
//      em.close();
      // 또는
//      em.clear();

      //영속성 컨텍스트가 더이상 관리하지 않아, Proxy 객체를 더이상사용할 수 없음
//      System.out.println("refMember.getUsername() = " + refMember.getUsername());

//      Member refMember = em.getReference(Member.class, member1.getId());
//      System.out.println("refMember.getClass() = " + refMember.getClass());//Proxy

      //프록시 인스턴스의 초기화 여부 확인
//      System.out.println(emf.getPersistenceUnitUtil().isLoaded(refMember));
//
//      refMember.getUsername();
//      System.out.println(emf.getPersistenceUnitUtil().isLoaded(refMember));

      //프록시 클래스 확인 방법
//      System.out.println("refMember.getClass() = " + refMember.getClass());

      //프록시 강제 초기화 (참고) Hibernate에서 제공하는거임. JPA는 강제 초기화가 없음.
//      Hibernate.initialize(refMember);

      //### 즉시 로딩과 지연 로딩

      //즉시 로딩 및 지연로딩 Member 클래스 확인.
//      Team team1 = new Team();
//      team1.setName("teamA");
//      em.persist(team1);
//      Team team2 = new Team();
//      team2.setName("teamB");
//      em.persist(team2);
//
//      Member member1 = new Member();
//      member1.setUsername("member1");
//      member1.setTeam(team1);
//      em.persist(member1);
//
//      Member member2 = new Member();
//      member2.setUsername("member1");
//      member2.setTeam(team2);
//      em.persist(member2);
//
//      em.flush();
//      em.clear();

//      Member m = em.find(Member.class, member1.getId());
//
//      System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
//
//      System.out.println("=============================");
//      m.getTeam().getName();//지연 로딩의 경우 초기화
//      System.out.println("=============================");

//      List<Member> members = em.createQuery("select m from Member m", Member.class)
//          .getResultList();

      //SQL 번역시
      //1. select * from Member
      //2. select * from Team where TEAM_ID = xxx

      //이후에 배울 fetch join 예시
//      List<Member> members = em.createQuery("select m from Member m join fetch m.team",
//          Member.class).getResultList();


      // 영속성 전이 Cascade
      // 소유자가 하나, 단일 소유자일 때 사용. 즉, 자식의 부모가 딱 하나일때.
//      Child child1 = new Child();
//      child1.setName("child1");
//      Child child2 = new Child();
//      child2.setName("child2");
//
//      Parent parent = new Parent();
//      parent.addChild(child1);
//      parent.addChild(child2);

      //모두 영속화하기 위해 3가지를 모두 persist 메서드를 사용해야한다. ->Parent 클래스에 cascade
//      em.persist(child1);
//      em.persist(child2);
//      em.persist(parent);

      // 고아 객체: 부모 엔티티와 연관관계가 끊어진 자식 엔티티를 자동으로 삭제
      // 참조하는 곳이 하나일 때 사용해야함!
      // 부모를 제거하면 자식도 함께 제거됨.
//      Child child1 = new Child();
//      child1.setName("child1");
//      Child child2 = new Child();
//      child2.setName("child2");
//
//      Parent parent = new Parent();
//      parent.addChild(child1);
//      parent.addChild(child2);
//
//      em.persist(child1);
//      em.persist(child1);
//      em.persist(parent);
//
//      em.flush();
//      em.clear();
//
//      Parent findParent = em.find(Parent.class, parent.getId());
//      findParent.getChildList().remove(0);//delete * from Child where CHILD_ID=getChildList(0)
//      em.remove(findParent);//findParent의 Children에 해당하는 Child도 모두 제거됨

      //값 타입

//      Address address = new Address("city", "street", "10000");
//
//      Member member1 = new Member();
//      member1.setUsername("member1");
//      member1.setHomeAddress(address);
//      em.persist(member1);
//
//
//      Address address2 = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//      Member member2 = new Member();
//      member2.setUsername("member1");
//      member2.setHomeAddress(address1);
//      member2.setHomeAddress(address2);
//      em.persist(member2);
      //임베디드 타입처럼 직접 정의한 값 타입과 같은 객체를 같이 사용하면 공유 참조로 인해 업데이트문이 2번 작성됨.
      // 참조값을 직접 대입하기 때문..-> 값을 복사해서 사용해야함
      //불변객체로 만드는 것이 일반적 -> setter를 없애거나, private으로 접근제어자 수정
//      member1.getHomeAddress().setCity("Suwon");
//      Address newAddress = new Address("Suwon", address.getStreet(), address.getZipcode());
//      member2.setHomeAddress(newAddress);
//      Member member = new Member();
//      member.setUsername("memeber1");
//      member.setHomeAddress(new Address("homeCity","street","10000"));
//
//      member.getFavoirteFoods().add("치킨");
//      member.getFavoirteFoods().add("족발");
//      member.getFavoirteFoods().add("피자");
//
//      member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
//      member.getAddressHistory().add(new AddressEntity("old2","street","10000"));
//
//      em.persist(member);
//
//      em.flush();
//      em.clear();
//
//      System.out.println("-------------START-----------------");
//      Member findMember = em.find(Member.class, member.getId());
//      System.out.println("-------------START-----------------");
//      for (String f : findMember.getFavoirteFoods()) {
//        System.out.println(f);
//      }
//      for (AddressEntity a : findMember.getAddressHistory()){
//        System.out.println(a.getAddress().getCity());
//      }
//
//      //값 타입 이기때문에 변경하려면 뺏다가 넣어야함.
//      //cascade + 고아객체 처럼 동작함.
//      findMember.getFavoirteFoods().remove("치킨");
//      findMember.getFavoirteFoods().add("한식");
//
//      findMember.getAddressHistory().remove(new AddressEntity("old1","street","10000"));
//      findMember.getAddressHistory().add(new AddressEntity("newCity1","street","10000"));

      //## 객체지향 쿼리 언어1 - 기본 문법

      //JPQL
//      List<Member> resultList = em.createQuery(
//          "SELECT m FROM Member m WHERE m.username like '%kim%'",
//          Member.class
//      ).getResultList();

      //Criteria - 다루기 어려움
      //객체 지향적으로 쿼리를 작성할 수 있고, 구문 오류를 방지할 수 있음
      //동적쿼리를 작성하기 용이함
      //유지보수가 어려움.. 가독성이 떨어짐
//      CriteriaBuilder cb = em.getCriteriaBuilder();
//      CriteriaQuery<Member> query = cb.createQuery(Member.class);

      //루트 클래스 (조회를 시작할 클래스)
//      Root<Member> m = query.from(Member.class);

      //쿼리 생성
//      CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//      List<Member> resultList = em.createQuery(cq).getResultList();

      //NativeQuery
//      List select_member_id_from_member = em.createNativeQuery("select MEMBER_ID from MEMBER", ㅡ드ㅠㄷㄱ)
//          .getResultList();

      //flush -> commit, query 날라갈 때 flush가 기본적으로 동작함


      //**

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }
    emf.close();

  }

  private static void logic(Member m1, Member m2) {
//    System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass()));
    System.out.println("m1 == m2 : " + (m1 instanceof Member));
    System.out.println("m1 == m2 : " + (m2 instanceof Member));

  }
}
