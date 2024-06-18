package org.example.IPL.Dashboard.Repository;

import org.example.IPL.Dashboard.Model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}


