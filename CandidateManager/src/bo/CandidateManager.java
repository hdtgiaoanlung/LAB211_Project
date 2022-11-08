package bo;

import model.Candidate;
import model.CandidateType;

import java.util.ArrayList;

public class CandidateManager {
    private ArrayList<Candidate> listCandidate;
    private int lastId;

    public CandidateManager() {
        listCandidate = new ArrayList<>();
        lastId = 0;
    }

    public CandidateManager(ArrayList<Candidate> listCandidate) {
        this.listCandidate = listCandidate;
    }

    public void addCandidate(Candidate c) {
        c.setId(lastId + 1);
        listCandidate.add(c);
    }

    public int searchCandidateById(int Id) throws Exception {
        for (int i = 0; i < listCandidate.size(); i++) {
            if (listCandidate.get(i).getId() == Id) {
                return i;
            }
        }
        throw new Exception("Id not found");
    }

    public ArrayList<Candidate> searchByNameAndType(String name, CandidateType type) {
        ArrayList<Candidate> ret = new ArrayList<>();
        for (Candidate c : listCandidate) {
            if (c.getType() == type &&
                    (c.getFirstName().toLowerCase().contains(name.toLowerCase())
                            || c.getLastName().toLowerCase().contains(name.toLowerCase()))) {
                ret.add(c);
            }
        }
        return ret;
    }

    public Candidate updateCandidate(int Id, Candidate c) throws Exception {
        int index = searchCandidateById(Id);
        if (index != -1) {
            return listCandidate.set(index, c);
        }
        throw new Exception("Candidate not found");
    }

    public Candidate removeById(int Id) throws Exception {
        int index = searchCandidateById(Id);
        if (index != -1) {
            return listCandidate.remove(index);
        }
        throw new Exception("Candidate does not exist!");
    }

    @Override
    public String toString() {
        String experienced = "\n==========EXPERIENCED CANDIDATE==========\n";
        String fresher = "\n==========FRESHER CANDIDATE==============\n";
        String intern = "\n==========INTERN CANDIDATE===============";
        for (Candidate c : listCandidate) {
            switch (c.getType()) {
                case Experienced:
                    experienced += c.getId() + "|" + c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                case Fresher:
                    fresher += c.getId() + "|" + c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
                case Intern:
                    intern += c.getId() + "|" + c.getFirstName() + " " + c.getLastName() + "\n";
                    break;
            }
        }
        return experienced + fresher + intern;
    }
}
