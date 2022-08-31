import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteBuscaProfessor {

    ProfessorService service;
    BuscaProfessor buscaProfessor;

    @Before
    public void setup(){
        service = new MockProfessorService();
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testeBuscaProfessorRosimara(){
        Professor rosimara = buscaProfessor.buscaProfessor(4);
        assertEquals("Rosimara", rosimara.getNomeProfessor());
        assertEquals("Segunda-feira 17:30-19:30", rosimara.getHorarioAtendimento());
        assertEquals("7°", rosimara.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorRenan(){
        Professor renan = buscaProfessor.buscaProfessor(6);
        assertEquals("Renan", renan.getNomeProfessor());
        assertEquals("Quarta-feira 18:30-19:50", renan.getHorarioAtendimento());
        assertEquals("6°", renan.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorChris(){
        Professor chris = buscaProfessor.buscaProfessor(10);
        assertEquals("Christopher", chris.getNomeProfessor());
        assertEquals("Sexta-feira 15:30-16:50", chris.getHorarioAtendimento());
        assertEquals("8°", chris.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorfail(){
        Professor inexistente = buscaProfessor.buscaProfessor(-10);
        assertEquals("Inexistente", inexistente.getNomeProfessor());
        assertEquals("Inexistente", inexistente.getHorarioAtendimento());
        assertEquals("Inexistente", inexistente.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorfail2(){
        Professor inexistente = buscaProfessor.buscaProfessor(-4);
        assertEquals("Inexistente", inexistente.getNomeProfessor());
        assertEquals("Inexistente", inexistente.getHorarioAtendimento());
        assertEquals("Inexistente", inexistente.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorpadrao(){
        Professor renan = buscaProfessor.buscaProfessor(17);
        assertEquals("Teams", renan.getNomeProfessor());
        assertEquals("Indeterminado", renan.getHorarioAtendimento());
        assertEquals("1° ao 10°", renan.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorValido(){
        boolean professorValido = buscaProfessor.verificaArrayListExistente(10);
        assertTrue(professorValido);

    }

    @Test
    public void testeBuscaProfessorInvalidofail(){
        boolean professorValido = buscaProfessor.verificaArrayListExistente(-10);
        assertTrue(!professorValido);

    }
}
