package com.rspatil45.votingapp.dao;

import com.rspatil45.votingapp.entity.Candidate;

import java.util.List;

public interface LeadCandidateDAO {
    List<Candidate> loadAllCandidates();
    Candidate getCandidateById(int candidateId);
    void updateCandidate(Candidate candidate);
}
