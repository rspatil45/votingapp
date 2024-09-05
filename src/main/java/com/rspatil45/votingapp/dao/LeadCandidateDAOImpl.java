package com.rspatil45.votingapp.dao;

import com.rspatil45.votingapp.entity.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LeadCandidateDAOImpl implements LeadCandidateDAO{

    private final EntityManager entityManager;
    private final Session session;

    @Autowired
    public LeadCandidateDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
        this.session = entityManager.unwrap(Session.class);
    }
    @Override
    public List<Candidate> loadAllCandidates() {
        Query<Candidate> candidateQuery = session.createQuery("from Candidate", Candidate.class);
        List<Candidate> allCandidates = candidateQuery.getResultList();
        return allCandidates;
    }

    @Override
    public Candidate getCandidateById(int candidateId) {
        Candidate candidate = session.get(Candidate.class, candidateId);
        return candidate;
    }

    @Override
    @Transactional
    public void updateCandidate(Candidate candidate) {
        entityManager.merge(candidate);
    }


}
