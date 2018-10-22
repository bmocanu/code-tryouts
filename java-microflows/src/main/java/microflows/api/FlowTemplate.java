package microflows.api;


import microflows.api.internal.*;

import java.util.ArrayList;
import java.util.List;

public abstract class FlowTemplate {

    private List<BaseStep> steps = new ArrayList<>();

    private BaseStep onAnyError;

    public FlowTemplate() {
        // TODO not good! think about something else
        define();
    }

    public <T extends FlowStep> void run_(Class<T> stepClass) {
        steps.add(new ClassStep(stepClass));
    }

    public ThenElsePart if_(FlowCondition condition) {
        return if_(condition, null);
    }

    public ThenElsePart if_(String conditionName) {
        return if_(null, conditionName);
    }

    public ThenElsePart if_(FlowCondition condition, String conditionName) {
        ThenElsePart fork = new ThenElsePart();
        steps.add(new ConditionStep(condition, conditionName, fork));
        return fork;
    }

    public ThenPart while_(FlowCondition condition) {
        return while_(condition, null);
    }

    public ThenPart while_(String conditionName) {
        return while_(null, conditionName);
    }

    public ThenPart while_(FlowCondition condition, String conditionName) {
        ThenPart subflow = new ThenPart();
        steps.add(new LoopStep(condition, conditionName, subflow));
        return subflow;
    }

    public <T extends FlowStep> void onAnyError_(Class<T> stepClass) {
        onAnyError = new ClassStep(stepClass);
    }

    public abstract void define();

    public List<BaseStep> getSteps() {
        return steps;
    }
}
