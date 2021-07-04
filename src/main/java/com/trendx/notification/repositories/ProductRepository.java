package com.trendx.notification.repositories;

import com.trendx.notification.entities.Product;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CouchbaseRepository<Product, String> {
}
