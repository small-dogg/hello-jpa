package hellojpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class Team {

  @Id
  @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;

  private String name;

//  @OneToMany(mappedBy = "team")
//  private List<Member> members = new ArrayList<>();
  @OneToMany
  @JoinColumn(name="TEAM_ID")
  private List<Member> members = new ArrayList<>();


//  public void addMember(Member member) {
//    member.setTeam(this);
//    members.add(member);
//  }

  @Override
  public String toString() {
    return "Team{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", members=" + members +
        '}';
  }
}
