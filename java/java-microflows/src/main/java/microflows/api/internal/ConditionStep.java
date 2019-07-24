package microflows.api.internal;


import microflows.api.FlowCondition;
import microflows.api.FlowContext;

/**
 * Created by bogdan.mocanu on 10/23/2014.
 */
public class ConditionStep extends BaseStep {

    private FlowCondition condition;

    private String conditionName;

    private ThenElsePart fork;

    public ConditionStep(FlowCondition condition, String conditionName, ThenElsePart fork) {
        this.condition = condition;
        this.conditionName = conditionName;
        this.fork = fork;
    }

    public FlowCondition getCondition() {
        return condition;
    }

    public String getConditionName() {
        return conditionName;
    }

    public ThenElsePart getFork() {
        return fork;
    }

    @Override
    public StepResult executeStep(FlowContext context) {
        System.out.println("Executing condition " + conditionName + ". Hardcoded going with TRUE");
        return new StepResult(StepResultOutcome.SUBFLOW, fork.getThenFlow());
    }

}
