package designpattern.gof_abstractFactory.sample005;

public class ReportCreator {

    public static Report createJasperReport(){
        return new Jasper();
    }

    public static Report createOpenReport(){
        return new OpenReport();
    }

    public static Report createCreateReport(){
        return new CreateReport();
    }
}
