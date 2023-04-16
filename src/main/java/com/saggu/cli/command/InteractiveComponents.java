package com.saggu.cli.command;

import org.springframework.shell.component.ConfirmationInput;
import org.springframework.shell.component.MultiItemSelector;
import org.springframework.shell.component.SingleItemSelector;
import org.springframework.shell.component.support.SelectorItem;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ShellComponent
public class InteractiveComponents extends AbstractShellComponent {

    @ShellMethod(key = "multi", value = "Multi selector")
    public String multiSelector() {
        List<SelectorItem<String>> items = new ArrayList<>();
        items.add(SelectorItem.of("key1", "value1"));
        items.add(SelectorItem.of("key2", "value2", false, true));
//        items.add(SelectorItem.of("key2", "value2", false, true));
        items.add(SelectorItem.of("key3", "value3"));
        MultiItemSelector<String, SelectorItem<String>> component = new MultiItemSelector<>(getTerminal(),
                items, "testSimple", null);
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        MultiItemSelector.MultiItemSelectorContext<String, SelectorItem<String>> context = component
                .run(MultiItemSelector.MultiItemSelectorContext.empty());
        String result = context.getResultItems().stream()
                .map(si -> si.getItem())
                .collect(Collectors.joining(","));
        return "You have selected: " + result;
    }

    @ShellMethod(key = "single", value = "Single selector")
    public String singleSelector() {
        SelectorItem<String> i1 = SelectorItem.of("key1", "value1");
        SelectorItem<String> i2 = SelectorItem.of("key2", "value2");
        List<SelectorItem<String>> items = Arrays.asList(i1, i2);
        SingleItemSelector<String, SelectorItem<String>> component = new SingleItemSelector<>(getTerminal(),
                items, "testSimple", null);
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        SingleItemSelector.SingleItemSelectorContext<String, SelectorItem<String>> context = component
                .run(SingleItemSelector.SingleItemSelectorContext.empty());
        String result = context.getResultItem().flatMap(si -> Optional.ofNullable(si.getItem())).get();
        return "You have selected: " + result;
    }

    @ShellMethod(key = "confirmation", value = "Confirmation input")
    public String confirmationInput() {
        ConfirmationInput component = new ConfirmationInput(getTerminal(), "Enter value");
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        ConfirmationInput.ConfirmationInputContext context = component.run(ConfirmationInput.ConfirmationInputContext.empty());
        return "Got value " + context.getResultValue();
    }
}