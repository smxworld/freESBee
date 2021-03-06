package it.unibas.silvio.processor;

import it.unibas.silvio.persistenza.SilvioException;
import it.unibas.silvio.persistenza.hibernate.DAOUtilHibernate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ProcessorHibernateCommit implements Processor {

    private Log logger = LogFactory.getLog(this.getClass());

    public void process(Exchange exchange) throws Exception {
        logger.debug("ProcessorHibernateCommit processa il messaggio");
        SessionFactory sessionFactory = DAOUtilHibernate.getSessionFactory();
        try {
            sessionFactory.getCurrentSession().getTransaction().commit();
        } catch (Exception ex) {
            logger.error("Impossibile fare il commit della sessione di hibernate " + ex);
            try {
                if (sessionFactory.getCurrentSession().getTransaction().isActive()) {
                    sessionFactory.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
            }
            throw new SilvioException(ex);
        }
    }
}
