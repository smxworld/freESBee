package it.unibas.freesbee.monitoraggio.calcolo.functions.aggregate;

import it.unibas.freesbee.monitoraggio.calcolo.wsaIcarGuaranteeTerms.type.BasicMetric;
import it.unibas.freesbee.monitoraggio.calcolo.wsaIcarGuaranteeTerms.type.FunctionType;
import it.unibas.freesbee.monitoraggio.calcolo.wsaIcarGuaranteeTerms.type.Window;
import it.unibas.freesbee.monitoraggio.exception.inf2exception.INF2Exception;
import it.unibas.freesbee.monitoraggio.exception.inf2exception.INF2NotDeterminatedAlgorithmException;
import java.util.Collections;
import java.util.List;

public class MaxFunction extends AggregateFunction {
    
    protected MaxFunction(FunctionType funType, Window win, BasicMetric bm) {
        super("MAX");
        this.functionType = funType;
        this.window = win;
        this.basicMetric = bm;        
    }

    @Override
    public double getResultOperationComplex(List<Double> listaRisultato) throws INF2Exception {
        if(listaRisultato.size() != 0 && listaRisultato != null) {
            return Collections.max(listaRisultato);
        }
        throw new INF2Exception(INF2NotDeterminatedAlgorithmException.MSG_ERROR_001);
    }
}
