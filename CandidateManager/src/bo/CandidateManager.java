package bo;

import model.Candidate;

import java.util.ArrayList;

public class CandidateManager {
    private ArrayList<Candidate> listCandidate;
    private int lastId;

    public CandidateManager() {
        listCandidate = new ArrayList<>();
        lastId = 0;
    }

    public void addCandidate(Candidate c){
        c.setId(lastId + 1);
        listCandidate.add(c);
    }

    public int searchCandidateById(int Id) throws Exception{
        for(int i = 0; i < listCandidate.size(); i++){
            if(listCandidate.get(i).getId() == Id){
                return i;
            }
        }
        throw new Exception("Id not found");
    }

    public Candidate updateCandidate(int Id,Candidate c) throws Exception {
        int index = searchCandidateById(Id);
        if(index != -1){
            return listCandidate.set(index, c);
        }
        throw new Exception("Candidate not found");
    }

    public Candidate removeById(int Id) throws Exception {
        int index = searchCandidateById(Id);
        if(index != -1 ){
            return listCandidate.remove(index);
        }
        throw new Exception("Candidate does not exist!");
    }


}
