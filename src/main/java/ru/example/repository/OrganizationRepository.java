package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
