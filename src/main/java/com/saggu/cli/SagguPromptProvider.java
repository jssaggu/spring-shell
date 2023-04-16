package com.saggu.cli;

import org.jline.utils.AttributedString;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class SagguPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("Saggu:> ");
    }
}
