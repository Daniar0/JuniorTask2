import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonRepository {
    private EntityManagerFactory emf;
    public PersonRepository() {
        this.emf=
                Persistence.createEntityManagerFactory("personPU");
    }
    public void addPerson(Person person) {
        EntityManager em =
                emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }
    public void updatePerson(Long id,String name,int age) {
        EntityManager em=
                emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if(person!=null) {
            person.setName(name);
            person.setAge(age);
            em.merge(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deletePerson(Long id) {
        EntityManager em =
                emf.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, id);
        if (person!= null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();

       }
       public Person getPerson(Long id) {
        EntityManager em=
                emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
       }

    }


