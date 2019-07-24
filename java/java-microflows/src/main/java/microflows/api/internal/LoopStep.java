package microflows.api.internal;


import microflows.api.FlowCondition;
import microflows.api.FlowContext;

/**
 * Created by bogdan.mocanu on 10/23/2014.
 */
public class LoopStep extends BaseStep {

    private FlowCondition condition;

    private String conditionName;

    private ThenPart fork;

    public LoopStep(FlowCondition condition, String conditionName, ThenPart subflow) {
        this.condition = condition;
        this.conditionName = conditionName;
        this.fork = subflow;
    }

    public FlowCondition getCondition() {
        return condition;
    }

    public String getConditionName() {
        return conditionName;
    }

    public ThenPart getFork() {
        return fork;
    }

    @Override
    public StepResult executeStep(FlowContext context) {
        System.out.println("Executing condition " + conditionName + ". Hardcoded iterating ONCE");
        return new StepResult(StepResultOutcome.SUBFLOW, fork.getThenFlow());
    }

}
