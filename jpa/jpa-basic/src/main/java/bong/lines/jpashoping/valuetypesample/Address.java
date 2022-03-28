package bong.lines.jpashoping.valuetypesample;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(length = 50)
    private String city;
    @Column(length = 250)
    private String street;
    @Column(length = 250)
    private String zipcode;

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        // Proxy 일 때도 정상동작하려면 getter 를 사용하도록 해야한다.
        // Proxy가 많이 사용되지 않을 경우에는 그냥해도 되지만 그냥 equals & hashcode는 무조건 짜라
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
