package microflows.driver;

import microflows.api.FlowContext;
import microflows.api.FlowTemplate;
import microflows.api.internal.BaseStep;
import microflows.api.internal.StepResult;
import microflows.api.internal.StepResultOutcome;

import java.util.Iterator;
import java.util.Stack;

public abstract class FlowDriverImpl<Input, Output> implements FlowDriver<Input> {

    @Override
    public FlowCapsule startNewFlow(FlowTemplate flowTemplate) {
        FlowCapsule capsule = new FlowCapsule(createFlowContext());
        capsule.getIteratorStack().push(flowTemplate.getSteps().iterator());
        return capsule;
    }

    @Override
    public void resumeFlow(FlowCapsule capsule, Input input) {
        FlowContext context = capsule.getContext();
        Stack<Iterator<BaseStep>> iteratorStack = capsule.getIteratorStack();
        while (!iteratorStack.isEmpty()) {
            Iterator<BaseStep> currentIterator = iteratorStack.peek();
            while (currentIterator.hasNext()) {
                BaseStep currentStep = currentIterator.next();
                StepResult currentStepResult = currentStep.executeStep(context);
                if (currentStepResult.getOutcome() == StepResultOutcome.SUBFLOW) {
                    FlowTemplate subflow = currentStepResult.getSubflow();
                    currentIterator = subflow.getSteps().iterator();
                    iteratorStack.push(currentIterator);
                }
            }
            iteratorStack.pop();
        }
        System.out.println("Flow is finished");
    }

    protected abstract FlowContext<Input, Output> createFlowContext();

}
