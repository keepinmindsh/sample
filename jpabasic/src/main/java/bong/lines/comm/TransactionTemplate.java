package bong.lines.comm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransactionTemplate implements Transaction {

    private final TransactionCommand transactionCommand;

    public TransactionTemplate(TransactionCommand transactionCommand) {
        this.transactionCommand = transactionCommand;
    }

    @Override
    public void process() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("wings-persistence");
        EntityManager entityManagerProxy = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManagerProxy.getTransaction();
        entityTransaction.begin();

        try{
            transactionCommand.procedure(entityManagerProxy);

            entityTransaction.commit();
        }catch (Exception exception){

            System.err.println(exception.getLocalizedMessage());

            entityTransaction.rollback();
        }finally {

            System.out.println("처리완료");

            entityManagerProxy.close();
        }

        entityManagerFactory.close();
    }
}
