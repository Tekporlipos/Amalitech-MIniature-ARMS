package com.amalitech.payroll.filters;
import com.amalitech.payroll.model.Auth;
import com.amalitech.payroll.repository.AuthRepository;
import com.amalitech.payroll.service.FetchUserService;
import com.amalitech.payroll.utils.Constants;
import com.amalitech.payroll.utils.Methods;
import com.amalitech.payroll.utils.REQUESTS;
import lombok.Data;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;


@Service
@Data
public class AuthorizationFilter {
    private Auth auth;
    private final AuthRepository authRepository;
    public boolean isAuth(String token) {
        try {
            final long time = new Date().getTime();
            final Optional<Auth> getAuth = authRepository.findByTokenAndExpireGreaterThan(token, time);
            if(getAuth.isPresent()){
                auth = getAuth.get();
            }else{
                final Map<String, Object> user = (Map<String, Object>) this.getData(token, "user");
                if(user != null){
                    Auth authNew = new Auth();
                    authNew.setRole(String.valueOf(user.get("role")));
                    authNew.setToken(String.valueOf(token));
                    authNew.setExpire(time + 1000 * 60 * 60);
                    auth = authRepository.save(authNew);
                }
            }
        } catch (Exception ignored) {}
        System.out.println(auth);
        return auth != null && auth.getRole().length()>4;
    }

    public boolean isAdmin(String token){
        return this.isAuth(token) && this.auth.getRole().equals("admin");
}

    public Object getData(String auth, String path) throws IOException, ParseException {
        String stream = Methods.stream(Constants.URL + path, REQUESTS.GET.name(), auth);
        JSONParser parser = new JSONParser();
        return parser.parse(stream);
    }

}
