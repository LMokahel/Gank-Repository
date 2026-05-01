package dontnag.gankdetector.member.dto;

import dontnag.gankdetector.member.Role;

public record Member(long id, String username, String password, Role role, String date_created, boolean valid) {

    public String safeRole(){
        if(this.role == null) return null;
        return role.toString();
    }
}
