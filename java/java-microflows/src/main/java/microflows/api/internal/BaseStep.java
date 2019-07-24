package microflows.api.internal;

import microflows.api.FlowContext;

/**
 * Created by bogdan.mocanu on 10/23/2014.
 */
public abstract class BaseStep {

    public abstract StepResult executeStep(FlowContext context);

}
