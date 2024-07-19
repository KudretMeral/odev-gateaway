package com.vehicle.microservice_gateaway.security;

import com.vehicle.microservice_gateaway.entity.AplUser;
import com.vehicle.microservice_gateaway.service.IAplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private IAplUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        AplUser user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Böyle bir kullanıcı bulunmamaktadır:" + username));

        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword());
    }


}
