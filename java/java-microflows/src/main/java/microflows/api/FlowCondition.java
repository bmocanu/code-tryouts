package microflows.api;

public interface FlowCondition<Context extends FlowContext> {

    boolean evaluate(Context context);

}
