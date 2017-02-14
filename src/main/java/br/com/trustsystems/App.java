package br.com.trustsystems;

import br.com.trustsystems.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App {
    private static final String PERSISTENCE_UNIT_NAME = "persons";
    private static EntityManagerFactory factory;

    public static void main (String[]args){
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      EntityManager em = factory.createEntityManager();


      em.getTransaction().begin();
      Person person = new Person();
      person.setName("Wenderson Ferreira de Souza");
      em.persist(person);
      em.getTransaction().commit();

      Query q = em.createQuery("select p from Person p");
      List<Person> personList = q.getResultList();
      for (Person p : personList) {
        System.out.println(p);
      }
      System.out.println("Size: " + personList.size());

      em.close();

    }
}