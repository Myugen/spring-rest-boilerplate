package ninja.mcabsan.boilerplate.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public class UsernameAuditorAware implements AuditorAware<String> {

    private static final String DEFAULT_USER = "anonymousUser";

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = DEFAULT_USER;

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of(username);
        }

        if (authentication.getPrincipal() instanceof String) {
            username = (String) authentication.getPrincipal();
        }
        if (authentication.getPrincipal() instanceof User) {
            username = ((User) authentication.getPrincipal()).getUsername();
        }

        return Optional.of(username);
    }
}
