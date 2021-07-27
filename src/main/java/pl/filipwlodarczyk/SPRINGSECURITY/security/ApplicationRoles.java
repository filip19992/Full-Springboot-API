package pl.filipwlodarczyk.SPRINGSECURITY.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.filipwlodarczyk.SPRINGSECURITY.security.ApplicationPermissions.*;

public enum ApplicationRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_WRITE, STUDENT_READ)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<ApplicationPermissions> applicationPermissions;

    ApplicationRoles(Set<ApplicationPermissions> applicationPermissions) {
        this.applicationPermissions = applicationPermissions;
    }

    public Set<ApplicationPermissions> getApplicationPermissions() {
        return applicationPermissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getApplicationPermissions().stream()
                .map(applicationPermissions1 -> new SimpleGrantedAuthority(applicationPermissions1.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
