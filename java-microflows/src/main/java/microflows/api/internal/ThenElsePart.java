package microflows.api.internal;

import microflows.api.FlowTemplate;

/**
 * Created by bogdan.mocanu on 10/27/2014.
 */
public class ThenElsePart extends ElsePart {

    private FlowTemplate thenFlow;

    public ElsePart then_(FlowTemplate subflow) {
        this.thenFlow = subflow;
        return this;
    }

    public FlowTemplate getThenFlow() {
        return thenFlow;
    }

}
