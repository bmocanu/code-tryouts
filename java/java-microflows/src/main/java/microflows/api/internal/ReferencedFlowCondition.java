package microflows.api.internal;

import microflows.api.FlowCondition;
import microflows.api.FlowContext;

/**
 * Created by bogdan.mocanu on 10/27/2014.
 */
public class ReferencedFlowCondition implements FlowCondition<FlowContext> {

    private String conditionName;

    public ReferencedFlowCondition(String conditionName) {
        this.conditionName = conditionName;
    }

    @Override
    public boolean evaluate(FlowContext context) {
        throw new UnsupportedOperationException("This methid is not implemented yet");
    }

}
