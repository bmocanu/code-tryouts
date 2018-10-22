package microflows.driver;

import microflows.api.FlowContext;
import microflows.api.internal.BaseStep;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by bogdan.mocanu on 10/24/2014.
 */
public class FlowCapsule {

    private FlowContext context;

    private Stack<Iterator<BaseStep>> iteratorStack = new Stack<>();

    public FlowCapsule(FlowContext context) {
        this.context = context;
    }

    public FlowContext getContext() {
        return context;
    }

    public Stack<Iterator<BaseStep>> getIteratorStack() {
        return iteratorStack;
    }
}
