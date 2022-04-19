package hellojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Product {

  @Id @GeneratedValue
  private Long id;

  private String name;

  //편리해보이지만 실무에서는 사용 안함.
//  @ManyToMany(mappedBy = "products")
//  private List<Member> members = new ArrayList<>();

  @OneToMany(mappedBy = "products")
  private List<MemberProduct> memberProducts = new ArrayList<>();
}
