package microflows.api;

public class FlowContext<Input, Output> {

    private Input input;

    private Output output;

    public Input getInput() {
        return input;
    }

    public Output getOutput() {
        return output;
    }
}
