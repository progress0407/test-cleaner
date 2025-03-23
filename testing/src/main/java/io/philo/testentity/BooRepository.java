package io.philo.testentity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooRepository extends JpaRepository<Boo, Long> {
}
