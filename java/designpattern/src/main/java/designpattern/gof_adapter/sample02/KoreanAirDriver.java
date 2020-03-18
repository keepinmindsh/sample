package designpattern.gof_adapter.sample02;

public class KoreanAirDriver implements AirplanDriver {

    public void Flying() {
        System.out.println("대한항공 드라이버가 비행기를 운전한다.");
    }

    public void Driving() {
        System.out.println("대한항공 드라이버가 운전한다.");
    }
}
