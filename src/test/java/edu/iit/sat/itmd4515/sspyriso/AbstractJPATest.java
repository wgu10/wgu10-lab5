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
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ganGuwen
 */
public abstract class AbstractJPATest {
    
    private static final Logger LOG = Logger.getLogger(AbstractJPATest.class.getName());
    
    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @BeforeEach
    public void beforeEach(){
        em = emf.createEntityManager();
        tx = em.getTransaction();
        
        // just like our JDBC test cases - let's stage some consistent test
        // data to work with across our test classes
        Pet test = new Pet("TESTPET", LocalDate.of(2020, Month.DECEMBER, 12), PetType.FELINE);
        tx.begin();
        em.persist(test);
        tx.commit();
        
        LOG.info("beforeEach\t" + test.toString());
    }
    
    @AfterEach
    public void afterEach(){
        // just like our JDBC test cases - let's clean up our test data
        // after each test case
        Pet test = em
                .createNamedQuery("Pet.findPetByName", Pet.class)
                .setParameter("NAME", "TESTPET")
                .getSingleResult();
        
        tx.begin();
        em.remove(test);
        tx.commit();
        
        em.close();
    }
    
    @AfterAll
    public static void afterAll(){
        emf.close();
    }
    
}
