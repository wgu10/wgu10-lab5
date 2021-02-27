/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.wgu10;

import edu.iit.sat.itmd4515.wgu10.domain.Pet;
import edu.iit.sat.itmd4515.wgu10.domain.PetType;
import java.time.LocalDate;
import java.time.Month;
import javax.persistence.RollbackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ganGuwen
 */
public class PetJPATest extends AbstractJPATest {


    // example "sunny day" test - expecting success
    @Test
    public void testCreateShouldPass() {
        // create an entity
        Pet cat = new Pet("Fluffy", LocalDate.of(2020, Month.DECEMBER, 12), PetType.FELINE);
        tx.begin();
        em.persist(cat);
        tx.commit();

        // assert success
        assertNotNull(cat.getId());
        assertTrue(cat.getId() >= 1l);

        // clean up after yourself
        tx.begin();
        em.remove(cat);
        tx.commit();
    }


    // example "rainy day" test - expecting failure
    @Test
    public void testCreateShouldFail() {
        // create an entity
        Pet cat = new Pet("TESTPET", LocalDate.of(2020, Month.DECEMBER, 12), PetType.FELINE);

        assertThrows(RollbackException.class, () -> {
            tx.begin();
            em.persist(cat);
            tx.commit();
        });
    }

    @Test
    public void testRead() {
        // find a pet from the database
        Pet test = em
                .createNamedQuery("Pet.findPetByName", Pet.class)
                .setParameter("NAME", "TESTPET")
                .getSingleResult();
        
        assertNotNull(test);
        assertEquals("TESTPET", test.getName());
    }

    @Test
    public void testUpdate() {
        // find a pet from the database
        Pet test = em
                .createNamedQuery("Pet.findPetByName", Pet.class)
                .setParameter("NAME", "TESTPET")
                .getSingleResult();

        // update something about this, but be careful - the afterEach em.remove
        // still needs to work.  In my case - that means watch out for the name
        tx.begin();
        test.setType(PetType.FISH);
        tx.commit();
        
        // next, read it back from the database and assert your update was OK
        test = em.find(Pet.class, test.getId());
        assertEquals(PetType.FISH, test.getType());
    }


    @Test
    public void testDelete() {
        // create an entity
        Pet cat = new Pet("Fluffy", LocalDate.of(2020, Month.DECEMBER, 12), PetType.FELINE);
        tx.begin();
        em.persist(cat);
        tx.commit();

        // assert created OK
        assertNotNull(cat.getId());
        
        // remove it
        tx.begin();
        em.remove(cat);
        tx.commit();
        
        // assert it was removed OK by trying to re-find it from the database
        cat = em.find(Pet.class, cat.getId());
        assertNull(cat);
    }

}
