package com.microservices.search.repository;

import com.microservices.search.model.SearchAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("searchAd")
public interface SearchAdRepository extends JpaRepository<SearchAd, Long> {
    SearchAd findById(long id);
}
