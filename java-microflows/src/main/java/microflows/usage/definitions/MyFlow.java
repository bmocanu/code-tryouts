package microflows.usage.definitions;


import microflows.api.FlowTemplate;
import microflows.usage.steps.*;
import microflows.usage.steps.operations.*;

import static microflows.usage.definitions.MyConditions.*;

public class MyFlow extends FlowTemplate {

    public void define() {
        getSteps().clear();
        run_(Start.class);
        if_(deviceIsRegistered()).then_(new FlowTemplate() {
            @Override
            public void define() {
                // no code here
            }
        }).else_(new FlowTemplate() {
            @Override
            public void define() {
                run_(RetrieveDeviceDetails.class);
                run_(RetrieveUsernameAndPassword.class);
            }
        });
        if_(pinNeedsToBeGenerated()).then_(new FlowTemplate() {
            @Override
            public void define() {
                run_(GeneratePin.class);
            }
        });
        while_(keysNeedToBeGeneratedForThisDevice()).then_(new FlowTemplate() {
            @Override
            public void define() {
                run_(PrepareKeyMaterialGeneration.class);
                run_(RetrievePublicKeyMaterial.class);
            }
        });
        while_(operationsArePending()).then_(new FlowTemplate() {
            @Override
            public void define() {
                run_(AllocateOperation.class);
                run_(ConfirmOperation.class);
                if_(userConfirmed()).then_(new FlowTemplate() {
                    @Override
                    public void define() {
                        run_(RetrievePin.class);
                        if_(pinIsValid()).then_(new FlowTemplate() {
                            @Override
                            public void define() {
                                run_(PerformPkiSignature.class);
                                run_(ValidatePkiSignature.class);
                                run_(StorePkiSignature.class);
                                run_(ClearMemoryData.class);
                                run_(DisplayOperationSuccess.class);
                            }
                        }).else_(new FlowTemplate() {
                            @Override
                            public void define() {
                                run_(BlockAccount.class);
                                run_(DisplayAccountBlocked.class);
                            }
                        }).else_(new FlowTemplate() {
                            @Override
                            public void define() {
                                run_(HandleUserRejection.class);
                            }
                        });
                    }
                });
            }
        });
        onAnyError_(DisplayError.class);
    }

}
