package com.scrubele.Repository;

import com.scrubele.domain.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {

}
