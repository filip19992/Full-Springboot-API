package pl.filipwlodarczyk.SPRINGSECURITY.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static pl.filipwlodarczyk.SPRINGSECURITY.security.ApplicationRole.*;

@Repository("fake")
public class FakeApplictionUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public FakeApplictionUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();

    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "Filip",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true,
                        ADMIN.getGrantedAuthorities()),
                new ApplicationUser(
                        "Maciek",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true,
                        ADMINTRAINEE.getGrantedAuthorities()),
                new ApplicationUser(
                        "Kuba",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true,
                        STUDENT.getGrantedAuthorities())

        );
        return applicationUsers;
    }
}
