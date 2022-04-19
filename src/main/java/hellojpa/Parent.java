package hellojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Parent {
  @Id
  @GeneratedValue
  @Column(name = "PARENT_ID")
  private Long id;

  private String name;

//Cascade
//  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
//고아 객체
//  @OneToMany(mappedBy = "parent", orphanRemoval = true)
  //부모 엔티티를 통해서 자식의 생명주기를 관리할 수 있음
  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Child> childList = new ArrayList<>();

  public void addChild(Child child) {
    childList.add(child);
    child.setParent(this);
  }
}
