package it.unibas.silvio.route;

import it.unibas.silvio.route.processors.ProcessorLog;

public class RouteTransazioneBD extends AbstractRoute {
    private org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory.getLog(this.getClass().getName());

    @Override
    public void configure() throws Exception {

        this.from(SEDA_TRANSAZIONE_BD)
                .process(new ProcessorLog(this))
                .process(new ProcessorProssimoStep())
            .recipientList(header(PROSSIMO_STEP));
    }

}
