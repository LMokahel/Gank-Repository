package dontnag.gankdetector.report;

import dontnag.gankdetector.common.GankService;
import dontnag.gankdetector.report.dto.Report;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends GankService<Report> {

    public ReportService(ReportRepository repository) {
        super(repository);
    }
}
