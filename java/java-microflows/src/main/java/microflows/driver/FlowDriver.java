package microflows.driver;

import microflows.api.FlowTemplate;

/**
 *
 */
public interface FlowDriver<Input> {

    FlowCapsule startNewFlow(FlowTemplate flowTemplate);

    void resumeFlow(FlowCapsule capsule, Input input);

}
