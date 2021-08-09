package pl.filipwlodarczyk.SPRINGSECURITY.auth;

import java.util.Optional;

public class FakeApplictionUserDaoService implements ApplicationUserDao{
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return Optional.empty();
    }
}
