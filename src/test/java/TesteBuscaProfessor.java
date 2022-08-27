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
    }

    @Test
    public void testeBuscaProfessorRosimara(){
        Mockito.when(service.busca(12)).thenReturn(ProfessorConst.rosimara);
        Professor rosimara = buscaProfessor.buscaProfessor(12);
        assertEquals("Rosimara", rosimara.getNomeProfessor());
    }
}
