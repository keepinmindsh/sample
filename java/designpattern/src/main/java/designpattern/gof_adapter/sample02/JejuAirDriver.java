package designpattern.gof_adapter.sample02;

public class JejuAirDriver implements AirplanDriver {
    public void Flying() {
        System.out.println("제주에어 드라이버가 비행기를 운전한다.");
    }

    public void Driving() {
        System.out.println("제주에어 드라이버가 운전한다.");
    }
}
