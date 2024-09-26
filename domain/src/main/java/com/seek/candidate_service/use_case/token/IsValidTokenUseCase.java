package com.seek.candidate_service.use_case.token;

import entity.userDetails.UserDetails;

public interface IsValidTokenUseCase {
    Boolean isValidToken(String token, UserDetails userDetails);
}
