package ru.netology.authservice;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();

        if (user.equals("Ivan") && password.equals("111")) {
            authoritiesList.addAll(List.of(new Authorities[]{Authorities.READ, Authorities.WRITE}));
        } else if (user.equals("Anton") && password.equals("222")) {
            authoritiesList.add(Authorities.READ);
        } else if (user.equals("Mike") && password.equals("333")) {
            authoritiesList.add(Authorities.DELETE);
        }

        return authoritiesList;
    }
}