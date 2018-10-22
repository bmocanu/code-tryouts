package microflows.usage.definitions;


import microflows.api.FlowCondition;
import microflows.api.FlowContext;
import microflows.usage.customization.MyFlowContext;

public class MyConditions {

    public static FlowCondition deviceIsRegistered() {
        return new FlowCondition<MyFlowContext>() {
            @Override
            public boolean evaluate(MyFlowContext context) {
                return false;
            }
        };
    }

    public static FlowCondition pinNeedsToBeGenerated() {
        return new FlowCondition() {
            @Override
            public boolean evaluate(FlowContext context) {
                return false;
            }
        };
    }

    public static FlowCondition keysNeedToBeGeneratedForThisDevice() {
        return new FlowCondition<MyFlowContext>() {
            @Override
            public boolean evaluate(MyFlowContext context) {
                return false;
            }
        };
    }

    public static FlowCondition operationsArePending() {
        return new FlowCondition<MyFlowContext>() {
            @Override
            public boolean evaluate(MyFlowContext context) {
                return false;
            }
        };
    }

    public static FlowCondition userConfirmed() {
        return new FlowCondition<MyFlowContext>() {
            @Override
            public boolean evaluate(MyFlowContext context) {
                return false;
            }
        };
    }

    public static FlowCondition pinIsValid() {
        return new FlowCondition<MyFlowContext>() {
            @Override
            public boolean evaluate(MyFlowContext context) {
                return false;
            }
        };
    }

}
