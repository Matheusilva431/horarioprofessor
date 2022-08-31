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
}
