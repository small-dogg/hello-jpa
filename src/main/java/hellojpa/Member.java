package hellojpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(
//    name = "MEMBER_SEQ_GENERATOR",
//    sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//    initialValue = 1, allocationSize = 1)
//@TableGenerator
//    (name = "MEMBER_SEQ_GENERATOR",
//    table = "MY_SEQUENCES",
//    pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member extends BaseEntity{


  //  @GeneratedValue(strategy = GenerationType.TABLE,
//      generator = "MEMBER_SEQ_GENERATOR")
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE,
//      generator = "MEMBER_SEQ_GENERATOR")
  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String username;

//  @ManyToOne(fetch = FetchType.LAZY)
  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)//읽기 전용
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  @OneToOne
  @JoinColumn(name = "LOCKER_ID")
  private Locker locker;

  @Embedded
  private Period period;

  @Embedded
  private Address homeAddress;

  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
  @Column(name="FOOD_NAME")
  private Set<String> favoirteFoods = new HashSet<>();

//  @ElementCollection
//  @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name="MEMBER_ID")
  private List<AddressEntity> addressHistory = new ArrayList<>();

//  @ManyToMany
//  @JoinTable(name = "MEMBER_PRODUCT")
//  private List<Product> products = new ArrayList<>();

  @OneToMany(mappedBy = "members")
  private List<MemberProduct> memberProducts = new ArrayList<>();

//  @Column(name = "TEAM_ID")
//  private Long teamId;

//  @ManyToOne//관계가 무엇인지
//  @JoinColumn(name = "TEAM_ID")//조인하는 컬럼이 무엇인지
//  private Team team;

  //연관관계 편의 메서드
//  public void changeTeam(Team team) {
//    this.team = team;
//    team.getMembers().add(this);
//  }

  @Override
  public String toString() {
    return "Member{" +
        "id=" + id +
        ", username='" + username + '\'' +
//        ", team=" + team +
        '}';
  }

  //  private Integer age;
//
//  @Enumerated(EnumType.STRING)
//  private RoleType roleType;
//
//  @Temporal(TemporalType.TIMESTAMP)
//  private Date createdDate;
//
//  @Temporal(TemporalType.TIMESTAMP)
//  private Date lastModifiedDate;
//
//  private LocalDate testLocalDate;
//  private LocalDateTime testLocalDateTime;
//
//  @Lob
//  private String description;
//  //Getter, Setter…


}