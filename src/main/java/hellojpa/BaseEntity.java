package hellojpa;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter @Getter
public abstract class BaseEntity {
  private String createdBy;
  private LocalDateTime createdDate;
  private String lastModifiedBy;
  private LocalDateTime lastModifiedDate;
}
