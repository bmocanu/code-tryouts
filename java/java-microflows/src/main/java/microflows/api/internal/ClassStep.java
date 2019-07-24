package microflows.api.internal;

import microflows.api.FlowContext;

/**
 * Created by bogdan.mocanu on 10/23/2014.
 */
public class ClassStep extends BaseStep {

    private Class stepClass;

    public ClassStep(Class stepClass) {
        this.stepClass = stepClass;
    }

    public Class getStepClass() {
        return stepClass;
    }

    @Override
    public StepResult executeStep(FlowContext context) {
        System.out.println("Executing " + stepClass.getSimpleName());
        return new StepResult(StepResultOutcome.DONE);
    }

}
