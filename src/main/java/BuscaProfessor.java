import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class BuscaProfessor {

    ProfessorService professorService;

    public BuscaProfessor(ProfessorService service){
        this.professorService = service;
    }

    public Professor buscaProfessor(int id){
        String professorJson = professorService.busca(id);
        JsonObject jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();

        return new Professor(
                jsonObject.get("nomeProfessor").getAsString(),
                jsonObject.get("horarioAtendimento").getAsString(),
                jsonObject.get("periodo").getAsString()
        );
    }

    public boolean verificaArrayListExistente(int id){
        boolean professorExistente = professorService.professorExistente(id);

        if(professorExistente){
            return true;
        }else{
            return false;
        }
    }

}
