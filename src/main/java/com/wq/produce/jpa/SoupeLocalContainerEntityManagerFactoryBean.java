//package com.wq.produce.jpa;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.metamodel.EntityType;
//import javax.persistence.spi.PersistenceUnitInfo;
//
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//
//public class SoupeLocalContainerEntityManagerFactoryBean extends LocalContainerEntityManagerFactoryBean {
//
//    @Override
//    protected void postProcessEntityManagerFactory(EntityManagerFactory emf, PersistenceUnitInfo pui) {
//        Set<EntityType<?>> entityTypes = emf.getMetamodel().getEntities();
//
//        Set<String> invalidEntities = new HashSet<String>();
//        for (EntityType entityType : entityTypes) {
//            Class classType = entityType.getJavaType();
//            if (true) {
//                invalidEntities.add(classType.getName());
//            }
//        }
//
//        if (invalidEntities.size() > 0) {
//            StringBuilder message = new StringBuilder();
//            message.append("Entities:\n");
//
//            for (String invalidEntity : invalidEntities) {
//                message.append("\t").append(invalidEntity).append("\n");
//            }
//
//            message.append("not manageable!").append("\n");
//            message.append("Your entity must extend one of these:\n");
//
//            throw new IllegalStateException(message.toString());
//        }
//    }
//
//}
