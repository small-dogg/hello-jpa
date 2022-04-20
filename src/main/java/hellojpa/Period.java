package hellojpa;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Period {
  private LocalDateTime startDate;
  private LocalDateTime endDate;

}
