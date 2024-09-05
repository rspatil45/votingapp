package com.rspatil45.votingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lead_candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private int candidateId;
    @Column(name = "candidate_name")
    private String candidateName;
    @Column(name = "no_of_votes")
    private int noOfVotes;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getNoOfVotes() {
        return noOfVotes;
    }

    public void setNoOfVotes(int noOfVotes) {
        this.noOfVotes = noOfVotes;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId=" + candidateId +
                ", candidateName='" + candidateName + '\'' +
                ", noOfVotes=" + noOfVotes +
                '}';
    }
}
