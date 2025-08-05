package com.devang.iam.services;

import com.devang.iam.models.AppUsers;
import com.devang.iam.models.ReturnDetails;
import com.devang.iam.repositories.MyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyRepository myRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUsers user = myRepo.findByUsername(username);
        if (user != null)
            return new ReturnDetails(user);
        else
            throw new UnsupportedOperationException("Method Unimplemented");
    }
}