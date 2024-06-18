package org.example.IPL.Dashboard.Service;

import org.example.IPL.Dashboard.Model.Match;
import org.example.IPL.Dashboard.Repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    public void saveAll(List<Match> matches) {
        matchRepository.saveAll(matches);
    }
}


