import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaProfessor {
    @Mock
    private ProfessorService service;
    private BuscaProfessor buscaProfessor;

    @Before
    public void setup(){
        buscaProfessor = new BuscaProfessor(service);
        Mockito.when(service.busca(12)).thenReturn(ProfessorConst.rosimara);
        Mockito.when(service.busca(17)).thenReturn(ProfessorConst.renan);
        Mockito.when(service.busca(25)).thenReturn(ProfessorConst.chris);
    }

    @Test
    public void testeBuscaProfessorRosimara(){
        Professor rosimara = buscaProfessor.buscaProfessor(12);
        assertEquals("Rosimara", rosimara.getNomeProfessor());
        assertEquals("Segunda-feira 17:30-19:30", rosimara.getHorarioAtendimento());
        assertEquals("Noturno", rosimara.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorRenan(){
        Professor renan = buscaProfessor.buscaProfessor(17);
        assertEquals("Renan", renan.getNomeProfessor());
        assertEquals("Quarta-feira 18:30-19:50", renan.getHorarioAtendimento());
        assertEquals("Noturno", renan.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorChris(){
        Professor chris = buscaProfessor.buscaProfessor(25);
        assertEquals("Christopher", chris.getNomeProfessor());
        assertEquals("Sexta-feira 15:30-16:50", chris.getHorarioAtendimento());
        assertEquals("Diurno", chris.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorRosimarafail(){
        Professor rosimara = buscaProfessor.buscaProfessor(12);
        assertEquals("Rosimara", rosimara.getNomeProfessor());
        assertEquals("Segunda 17:30-19:30", rosimara.getHorarioAtendimento());
        assertEquals("Noturno", rosimara.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorRenanfail(){
        Professor renan = buscaProfessor.buscaProfessor(17);
        assertEquals("Renan", renan.getNomeProfessor());
        assertEquals("Quarta-feira 18:30-19:50", renan.getHorarioAtendimento());
        assertEquals("Diurno", renan.getPeriodo());
    }

    @Test
    public void testeBuscaProfessorChrisfail(){
        Professor chris = buscaProfessor.buscaProfessor(25);
        assertEquals("Chris", chris.getNomeProfessor());
        assertEquals("Sexta-feira 15:30-16:50", chris.getHorarioAtendimento());
        assertEquals("Diurno", chris.getPeriodo());
    }
}
