package dev.melis.travelplanapp.service.authentication;

import dev.melis.travelplanapp.support.result.CrudResult;

public interface AuthenticationService {

    CrudResult authenticate(AuthenticationServiceRequest request);
}
