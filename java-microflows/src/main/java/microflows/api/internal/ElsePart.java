package microflows.api.internal;

import microflows.api.FlowTemplate;

/**
 * Created by bogdan.mocanu on 10/27/2014.
 */
public class ElsePart {

    private FlowTemplate elseFlow;

    public ElsePart else_(FlowTemplate subflow) {
        this.elseFlow = subflow;
        return this;
    }

    public FlowTemplate getElseFlow() {
        return elseFlow;
    }

}
