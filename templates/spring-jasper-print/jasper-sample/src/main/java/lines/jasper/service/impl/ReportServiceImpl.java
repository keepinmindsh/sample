package lines.jasper.service.impl;

import com.github.javafaker.Faker;
import lines.jasper.model.ReportData;
import lines.jasper.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ReportServiceImpl implements ReportService {

    final Faker faker = new Faker();
    final Random random = new Random();

    // For ease we are not making the database interaction here.
    // Readers can inject the dao layer here to make the real-time database interactions.
    @Override
    public List<ReportData> findAll() {
        final List<ReportData> reportData = new ArrayList<>();
        // Creating a list of employees using the "faker" object.
        for(int count=0; count<21; count++) {
            reportData.add(new ReportData(
                        random.nextInt(30 + 1),
                        faker.name().fullName(),
                        faker.job().title(),
                        faker.job().field()
                    )
            );
        }
        return reportData;
    }
}
