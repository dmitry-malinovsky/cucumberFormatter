package cucumberFormatter;

import cucumberFormatter.adapters.CustomScenario;
import cucumberFormatter.adapters.CustomStep;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.*;
import utils.RestUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CustomFormatter implements Formatter, Reporter {
    private CustomScenario customScenario;
    private List<Step> steps = new LinkedList<>();
    private int stepId;


    @Override
    public void scenario(Scenario scenario) {
        customScenario = new CustomScenario(scenario);
    }

    @Override
    public void step(Step step) {
        this.steps.add(step);
    }

    @Override
    public void result(Result result) {
        customScenario.addStep(new CustomStep(this.steps.get(stepId), result));
        stepId++;
    }


    @Override
    public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {

    }

    @Override
    public void uri(String s) {

    }

    @Override
    public void feature(Feature feature) {

    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {

    }

    @Override
    public void examples(Examples examples) {

    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {

    }

    @Override
    public void background(Background background) {

    }

    @Override
    public void endOfScenarioLifeCycle(Scenario scenario) {
        try {
            RestUtils.post("http://localhost:9200/testing/test-1", customScenario.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void done() {

    }

    @Override
    public void close() {

    }

    @Override
    public void eof() {

    }

    @Override
    public void before(Match match, Result result) {

    }

    @Override
    public void after(Match match, Result result) {

    }

    @Override
    public void match(Match match) {

    }

    @Override
    public void embedding(String s, byte[] bytes) {

    }

    @Override
    public void write(String s) {

    }

}
