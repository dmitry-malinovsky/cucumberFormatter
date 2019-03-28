package cucumberFormatter.adapters;

import gherkin.formatter.model.Result;
import gherkin.formatter.model.Step;

public class CustomStep {
    private String name;
    private Status status;
    private String output;
    private Long duration;

    public CustomStep(Step step, Result result) {
        this.name = step.getName();
        this.duration = result.getDuration();
        this.status = Status.valueOf(result.getStatus().toUpperCase());
        this.output = result.getErrorMessage() == null ? "" : result.getErrorMessage();
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public String getOutput() {
        return output;
    }

    public Long getDuration() {
        return duration;
    }
}
