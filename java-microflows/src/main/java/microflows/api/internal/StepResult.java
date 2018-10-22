package microflows.api.internal;

import microflows.api.FlowTemplate;

/**
 * Created by bogdan.mocanu on 10/28/2014.
 */
public class StepResult {

    private StepResultOutcome outcome;
    private FlowTemplate subflow;

    public StepResult(StepResultOutcome outcome) {
        this.outcome = outcome;
    }

    public StepResult(StepResultOutcome outcome, FlowTemplate subflow) {
        this.outcome = outcome;
        this.subflow = subflow;
    }

    public StepResultOutcome getOutcome() {
        return outcome;
    }

    public FlowTemplate getSubflow() {
        return subflow;
    }
}
