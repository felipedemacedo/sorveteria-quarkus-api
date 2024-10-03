package io.github.felipedemacedo.sorveteria.rest.domain.repository;

import io.github.felipedemacedo.sorveteria.rest.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
