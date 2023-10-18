package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CallServiceV2 {

//    private final ApplicationContext applicationContext;

    private final ObjectProvider<CallServiceV2> callServiceProvider;

    public void external() {
        log.info("call external");
        CallServiceV2 callServiceV2 = callServiceProvider.getObject();
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        callServiceV2.internal();
    }

    public void internal() {
         log.info("call internal");
    }
}
