public class Main {
    public static void main(String[] args) {
      PersonRepository dao = new PersonRepository();

      Person person=new Person("Bob",45);
      dao.addPerson(person);
        System.out.println("Добавлен персон: "+person);


     dao.updatePerson(person.getId(), "Bob Smith",65);
     Person updatedPerson=dao.getPerson(person.getId());
        System.out.println("Обновлен персон: "+updatedPerson);

     dao.deletePerson(person.getId());
     Person deletedPerson=dao.getPerson(person.getId());
        System.out.println("Удален персон: "+deletedPerson);

    }
}