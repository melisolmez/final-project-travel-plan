package dev.melis.travelplanapp.config;

import dev.melis.travelplanapp.model.User;
import dev.melis.travelplanapp.model.UserRole;

public record UserSession(
        String id,
        String username,
        UserRole role,
        User user
) {
}
