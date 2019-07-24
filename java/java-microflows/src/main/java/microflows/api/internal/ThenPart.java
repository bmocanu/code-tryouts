package microflows.api.internal;

import microflows.api.FlowTemplate;

/**
 * Created by bogdan.mocanu on 10/27/2014.
 */
public class ThenPart {

    private FlowTemplate thenFlow;

    public void then_(FlowTemplate subflow) {
        this.thenFlow = subflow;
    }

    public FlowTemplate getThenFlow() {
        return thenFlow;
    }

}
