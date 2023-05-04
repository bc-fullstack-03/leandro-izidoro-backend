package com.sysmap.demo.services.security;

import java.util.UUID;

public interface IJwtService extends JwtService {
    String generateToken(UUID userId);

}
