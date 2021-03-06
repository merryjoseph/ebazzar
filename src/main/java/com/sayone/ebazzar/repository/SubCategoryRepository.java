package com.sayone.ebazzar.repository;

import com.sayone.ebazzar.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {

    SubCategoryEntity findBySubCategoryName(String subCategoryName);


}
