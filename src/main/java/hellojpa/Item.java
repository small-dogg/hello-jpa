package hellojpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
//DiscriminatorColumn이 없어도 DTYPE이 기본으로 작성됨
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="DISCRIMINATOR")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
public abstract class Item {

  @Id @GeneratedValue
  private Long id;

  private String name;
  private int price;
}

