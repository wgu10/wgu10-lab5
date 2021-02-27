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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ganGuwen
 */
public class Driver {

    private static final Logger LOG = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {

        Pet cat = new Pet("Fluffy", LocalDate.of(2020, Month.DECEMBER, 12), PetType.FELINE);
        Pet dog = new Pet("Spike", LocalDate.of(2020, Month.NOVEMBER, 22), PetType.CANINE);

        LOG.info("Before em.persist==========================================>");
        LOG.info(cat.toString());
        LOG.info(dog.toString());

        // reading the persistence.xml is the entry point where entities are created as tables
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //
        // do some JPA work
        em.persist(cat);
        em.persist(dog);

        LOG.info("After em.persist, before tx.commit ==========================================>");
        LOG.info(cat.toString());
        LOG.info(dog.toString());

        em.flush();

        LOG.info("After em.persist, before tx.commit, after em.flush ==========================================>");
        LOG.info(cat.toString());
        LOG.info(dog.toString());

        //
        tx.commit();

        LOG.info("After em.persist, after tx.commit ==========================================>");
        LOG.info(cat.toString());
        LOG.info(dog.toString());

        Pet foundPetFromDatabase = em.find(Pet.class, 1l);
        LOG.info("Found Pet 1: " + foundPetFromDatabase.toString());

        // JPQL query example
        foundPetFromDatabase = em
                .createQuery("select p from Pet p where p.name = :NAME", Pet.class)
                .setParameter("NAME", "Spike")
                .getSingleResult();

        LOG.info("Found Spike: " + foundPetFromDatabase.toString());

        foundPetFromDatabase = em
                .createNamedQuery("Pet.findPetByName", Pet.class)
                .setParameter("NAME", "Fluffy")
                .getSingleResult();

        LOG.info("Found Fluffy: " + foundPetFromDatabase.toString());

        List<Pet> pets = new ArrayList<>();
        pets = em.createNamedQuery("Pet.findAll", Pet.class).getResultList();

        for (Pet p : pets) {
            LOG.info(p.toString());
        }

        em.close();
        emf.close();
    }
}
