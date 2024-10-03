package io.github.felipedemacedo.sorveteria.rest;

import io.github.felipedemacedo.sorveteria.rest.domain.metrics.UserMetrics;
import io.github.felipedemacedo.sorveteria.rest.domain.model.User;
import io.github.felipedemacedo.sorveteria.rest.domain.repository.UserRepository;
import io.github.felipedemacedo.sorveteria.rest.dto.CreateUserRequest;
import io.github.felipedemacedo.sorveteria.rest.dto.ResponseError;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Set;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private UserRepository repository;
    private Validator validator;
    private UserMetrics userMetrics;

    @Inject
    public UserResource(UserRepository repository, Validator validator, UserMetrics userMetrics) {
        this.repository = repository;
        this.validator = validator;
        this.userMetrics = userMetrics;
    }

    @POST
    @Transactional
    public Response createUser( CreateUserRequest userRequest ){

        Set<ConstraintViolation<CreateUserRequest>> violations = validator.validate(userRequest);

        if (!violations.isEmpty()){
            ResponseError responseError = ResponseError.createFromValidation(violations);
            return Response.status(406).entity(responseError).build();
        }

        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getName());

        repository.persist(user);
        userMetrics.userCreated();

        return Response.status(Response.Status.CREATED.getStatusCode())
                .entity(user)
                .build();
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<User> query = repository.findAll();
        return Response.ok(query.list()).build();
    }

}
