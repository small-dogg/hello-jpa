package hellojpa;

import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
//@Setter
public class Address {
  private String city;
  private String street;
  private String zipcode;

  public Address() {
  }

  public Address(String city, String street, String zipcode) {
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
  }

  //객체의 동등성을 비교해줌.
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(city, address.city) && Objects.equals(street,
        address.street) && Objects.equals(zipcode, address.zipcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, street, zipcode);
  }
}
