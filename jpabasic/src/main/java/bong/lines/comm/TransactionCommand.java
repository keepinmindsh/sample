package bong.lines.comm;


import javax.persistence.EntityManager;

@FunctionalInterface
public interface TransactionCommand {
    void procedure(EntityManager entityManager);
}
