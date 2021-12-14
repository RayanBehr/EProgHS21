import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComputerTest {
    
    @Test
    public void testGibHinweis() {
        assertEquals("ist", neuerComputerMit("hallo").gibHinweis(new String("hallo")));
        assertEquals("beginnt mit und endet mit", neuerComputerMit("halloh").gibHinweis("h"));
        assertEquals("beginnt mit und endet mit", neuerComputerMit("hallohoh").gibHinweis("h"));
        assertEquals("beginnt mit", neuerComputerMit("hallo").gibHinweis("h"));
        assertEquals("endet mit", neuerComputerMit("alloh").gibHinweis("h"));
        assertEquals("enthält", neuerComputerMit("oha!").gibHinweis("h"));
        assertEquals("enthält nicht", neuerComputerMit("bla").gibHinweis("h"));
        
        assertEquals("beginnt mit und endet mit", neuerComputerMit("susosu").gibHinweis("su"));
        assertEquals("beginnt mit und endet mit", neuerComputerMit("sususu").gibHinweis("su"));
        assertEquals("beginnt mit", neuerComputerMit("hallo").gibHinweis("ha"));
        assertEquals("endet mit", neuerComputerMit("alloh").gibHinweis("oh"));
        assertEquals("enthält", neuerComputerMit("ohaha!").gibHinweis("hah"));
        assertEquals("enthält nicht", neuerComputerMit("ja").gibHinweis("nein"));
    }
    
    private Computer neuerComputerMit(String wort) {
        Computer computer = new Computer();
        computer.neuesSpiel(new String[]{wort});
        return computer;
    }
}
