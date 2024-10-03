package io.github.felipedemacedo.sorveteria.rest.domain.metrics;

import org.eclipse.microprofile.metrics.annotation.Metered;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UserMetrics {

    @Metered(name = "users_created", description = "Número de usuários criados.")
    public void userCreated() {
        // Método para registrar criação de usuário
    }
}
