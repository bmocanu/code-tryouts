package microflows.usage.customization;

import microflows.api.FlowContext;
import microflows.driver.FlowDriverImpl;
import microflows.usage.model.DeviceRequest;
import microflows.usage.model.DeviceResponse;

/**
 * Created by bogdan.mocanu on 10/24/2014.
 */
public class MyFlowDriverImpl extends FlowDriverImpl<DeviceRequest, DeviceResponse> {

    @Override
    protected FlowContext<DeviceRequest, DeviceResponse> createFlowContext() {
        return new MyFlowContext();
    }

}
