import java.util.ArrayList;

public class MockProfessorService implements  ProfessorService{

    @Override
    public String busca(int id){

        if (id == 4){
            return ProfessorConst.rosimara;
        }
        else if (id == 6){
            return ProfessorConst.renan;
        }
        else if (id == 10){
            return ProfessorConst.chris;
        }
        else if(id < 0){
            return ProfessorConst.inexistente;
        }
        else{
            return ProfessorConst.padrao;
        }
    }

    @Override
    public boolean professorExistente(int id) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(6);
        list.add(10);

        for (int i=0; i < list.size(); i++){
            return list.get(i).equals(id) || list.get(i).equals(id);
        }

        return false;
    }
}
