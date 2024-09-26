package drivenPort.drivenJpa.candidate;

import entity.abstracts.PageBase;
import entity.candidate.Candidate;

import java.util.UUID;

public interface CandidateRepository {
    Candidate create(Candidate candidate);

    Candidate update(UUID uuid, Candidate candidate);

    PageBase<Candidate> index(Integer page, Integer size);

    Candidate show(UUID uuid);

    void delete(UUID uuid);
}
