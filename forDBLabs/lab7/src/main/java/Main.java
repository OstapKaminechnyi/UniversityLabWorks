import com.scrubele.MobileEntity;
import com.scrubele.CpuEntity;
import com.scrubele.CustomerEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import java.util.Scanner;
import java.util.TimeZone;

public class Main {

    private static final SessionFactory ourSessionFactory;


    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void printValues(Session session) {
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {

        }
    }
    public static void printJoinTable(Session session){
        session.beginTransaction();
        final Query query = session.createQuery(" from MobileEntity");
        System.out.println("executing: " + query.getQueryString());
        for (Object o : query.list()) {
            MobileEntity mobileEntity = (MobileEntity) o;
            System.out.println("  " + mobileEntity.toStringJoinTable());
        }

    }
    public static void addToJoinTable(Session session){
        session.beginTransaction();
        Scanner input = new Scanner(System.in);
        System.out.println("Input an id of mobile: ");
        int mobile_id = input.nextInt();
        System.out.println("Input an id of customer: ");
        int customer_id = input.nextInt();

        Query query1 = session.createQuery("from MobileEntity  where id= :mobile_id");
        query1.setParameter("mobile_id", mobile_id);
        MobileEntity mobileEntity = (MobileEntity) query1.list().get(0);
        Query query2 = session.createQuery("from CustomerEntity  where id= :customer_id");
        query2.setParameter("customer_id", customer_id);
        CustomerEntity customerEntity = (CustomerEntity) query2.list().get(0);
        mobileEntity.addOwnership(customerEntity);
        session.getTransaction().commit();
        System.out.println("Added to join table.");
    }

    public static void deleteFromJoinTable(Session session){
        session.beginTransaction();
        Scanner input = new Scanner(System.in);
        System.out.println("Input an id of mobile: ");
        int mobile_id = input.nextInt();
        System.out.println("Input an id of customer: ");
        int customer_id = input.nextInt();

        Query query1 = session.createQuery("from MobileEntity  where id= :mobile_id");
        query1.setParameter("mobile_id", mobile_id);
        MobileEntity mobileEntity = (MobileEntity) query1.list().get(0);
        Query query2 = session.createQuery("from CustomerEntity  where id= :customer_id");
        query2.setParameter("customer_id", customer_id);
        CustomerEntity customerEntity = (CustomerEntity) query2.list().get(0);
        mobileEntity.deleteCustomerEntity(customerEntity);
        session.getTransaction().commit();
        System.out.println("Deleted from join table.");
        //artistsEntity.setProjects();
    }
    private static void insertDataMobile(Session session) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a new mobile: ");
        String newMobile_category = input.next();
        String newMobile_mark = input.next();
        String newMobile_colour = input.next();
        String newMobile_v_number = input.next();
        String newMobile_specifics = input.next();
        String newMobile_image = input.next();
        int cpu_id = input.nextInt();

        CpuEntity cpuEntity = new CpuEntity(cpu_id);

        session.beginTransaction();
        MobileEntity mobileEntity = new MobileEntity(newMobile_category, newMobile_mark,
                newMobile_colour,newMobile_v_number,newMobile_specifics,newMobile_image, cpuEntity);
        session.save(mobileEntity);
        session.getTransaction().commit();

        System.out.println("end insert mobile");


    }
    @Transactional
    private static void deleteDataMobile(Session session) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input id of mobile for delete: ");
        int mobile_id = input.nextInt();

        session.beginTransaction();
        Query query = session.createQuery("delete MobileEntity where id=:mobile_id");
        query.setParameter("mobile_id", mobile_id);

        int result = query.executeUpdate();
        session.getTransaction().commit();

        System.out.println("end delete mobile");
    }

    private static void updateDataMobile(Session session) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input id  of mobile what you want to update: ");
        Integer mobile_id = input.nextInt();
        System.out.println("Input new mark of mobile for %s: "+ mobile_id);
        String mark_new = input.next();

        session.beginTransaction();
        Query query = session.createQuery("update MobileEntity SET mark=:mark_new " +
                " where id=:mobile_id");
        query.setParameter("mobile_id", mobile_id);
        query.setParameter("mark_new", mark_new);

        int result = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("Updated.");

    }

    public static void main(final String[] args) throws Exception {
        System.out.println(TimeZone.getDefault());
        final Session session = getSession();

        Scanner input = new Scanner(System.in);
        int x = 10000;
        while (x != 0) {
            System.out.println("Enter 1-readData(),\n 2 -insertDataMobile()," +
                    "\n 3 - deleteDataMobile(),\n 4 - updateDataMobile(), \n 5 - print joinTable()," +
                    "\n 6 - added record to joinTable(),\n 7 - delete record from joinTable(),\n0 - exit");
            x = input.nextInt();
            switch (x) {
                case 1: {
                    printValues(session);
                    break;
                }
                case 2: {
                    insertDataMobile(session);
                    break;
                }
                case 3: {
                    deleteDataMobile(session);
                    break;
                }
                case 4: {
                    updateDataMobile(session);
                    break;
                }
                case 5: {
                    printJoinTable(session);
                    break;
                }
                case 6: {
                    addToJoinTable(session);
                    break;
                }
                case 7: {
                    deleteFromJoinTable(session);
                    break;
                }
            }
        }
    }
}