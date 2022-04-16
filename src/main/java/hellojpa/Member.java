package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Member {

  @Id
  private Long id;
  private String name;


  public Member() {

  }
}
