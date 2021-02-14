package com.wings;

import com.schedular.WINGSSchedularContext;
import com.wings.util.builder.ApplicationBuilder;
import com.wings.util.starter.ApplicationStarter;

public class WingsSchedularApplication {
    public static void main(String[] args) throws Exception {
        ApplicationStarter.run(
                ApplicationBuilder.builder()
                        .args(args)
                        .systemId("B_SAMPLE")
                        .parentApplicationContext(new Class[]{ WingsSchedularApplication.class })
                        .childNoneApplcationContext(new Class[]{
                                WINGSSchedularContext.class
                        }).build());
    }
}
