package microflows.usage;

import microflows.driver.FlowCapsule;
import microflows.driver.FlowDriverImpl;
import microflows.usage.customization.MyFlowContext;
import microflows.usage.customization.MyFlowDriverImpl;
import microflows.usage.definitions.MyFlow;

public class TestMicroflows {

    /*-
     * Scenario:
     * 1. device connects, it is a brand new device
     * 2. device provides device details
     * 3. device provides username and password (taken from the end user)
     * 4. device is instructed to allow the end user to device the PIN
     * 5. device needs to generate 3 key materials, return the PbKs to the server
     * 6. if operations are available for device to perform
     *      6.a first operation is taken
     *      6.b device asks the end user to confirm the operation
     *      6.c device asks the end user to enter the PIN
     *      6.d device performs the signature
     *      6.e server validates the signature
     *      6.f server stores the signature
     *      6.g device clears the memory data
     *      6.h repeat from 6.a until no more ops are to perform
     * 7. end of flow
     */
    public static void main(String[] args) {
        FlowDriverImpl driver = new MyFlowDriverImpl();
        FlowCapsule capsule = driver.startNewFlow(new MyFlow());
        driver.resumeFlow(capsule, null);
    }

}
