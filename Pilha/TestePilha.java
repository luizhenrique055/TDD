package Pilha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestePilha {

    private Pilha p;

    @Before
    public void inicializaPilha() {

        p = new Pilha(10);

    }

    @Test
    public void pilhaVazia() {

        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());

    }

    @Test
    public void empilhaUmElemento() {

        p.empilha("Primeiro");

        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("Primeiro", p.topo());

    }

    @Test
    public void empilhaEDesempilha() {

        p.empilha("Primeiro");
        p.empilha("Segundo");

        assertEquals(2, p.tamanho());
        assertEquals("Segundo", p.topo());

        Object desempilhado = p.desempilha();

        assertEquals(1, p.tamanho());
        assertEquals("Primeiro", p.topo());
        assertEquals("Segundo", desempilhado);

    }

    // somente uma linha de codigo pode dar erro
    @Test(expected = PilhaVaziaException.class)
    public void removeDaPilhaVazia() {
        p.desempilha();
    }

    // varias linhas de codigo podem dar erro
    @Test
    public void adicionaNaPilhaCheia() {

            for (int i = 0; i < 10; i++) {
                p.empilha("Elemento" + i);
            }
            try {
                p.empilha("Oieee");
                Assertions.assertThrows(PilhaCheiaException.class, () -> {
                });
            } catch (PilhaCheiaException e) {

            }

   

    }

}
