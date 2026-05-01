package dontnag.gankdetector.member.dto;

public record GetMembersByUsernameRequest(long limit, long offset, String username) {
}
