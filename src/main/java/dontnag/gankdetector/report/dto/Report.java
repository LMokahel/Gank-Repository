package dontnag.gankdetector.report.dto;

import dontnag.gankdetector.report.ReportStatus;

public record Report(long id, long guild_id, long member_id, String description, ReportStatus status, String evidence, String date_created) {
}
