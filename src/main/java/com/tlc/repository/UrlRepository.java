package com.tlc.repository;

import com.tlc.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for postgresql CRUD operations
 */
@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByUrl(String url);
    Optional<UrlEntity> findByDeepLink(String deepLink);
}
